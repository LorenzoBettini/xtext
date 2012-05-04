/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/eplv10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmConstraintOwner;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge Initial contribution and API
 * @author Holger Schill
 */
@Singleton
public class FeatureOverridesService {

	@Inject
	private SuperTypeCollector superTypeCollector;

	@Inject
	private TypeArgumentContextProvider contextProvider;

	@Inject
	protected FeatureOverridesService() {
	}

	public FeatureOverridesService(SuperTypeCollector superTypeCollector, TypeArgumentContextProvider contextProvider) {
		this.superTypeCollector = superTypeCollector;
		this.contextProvider = contextProvider;
	}

	public Iterable<JvmFeature> getAllJvmFeatures(JvmTypeReference type) {
		if (type == null)
			return Collections.emptyList();
		ITypeArgumentContext context = contextProvider
				.getTypeArgumentContext(new TypeArgumentContextProvider.ReceiverRequest(type));
		JvmType rawType = type.getType();
		if (rawType == null || rawType.eIsProxy() || !(rawType instanceof JvmDeclaredType))
			return Collections.emptyList();
		return getAllJvmFeatures((JvmDeclaredType) rawType, context);
	}

	public Iterable<JvmFeature> getAllJvmFeatures(JvmDeclaredType type, ITypeArgumentContext ctx) {
		Multimap<Triple<EClass, String, Integer>, JvmFeature> featureIndex = LinkedHashMultimap.create();
		indexFeatures(type, featureIndex);
		Set<JvmTypeReference> types = superTypeCollector.collectSuperTypes(type);
		for (JvmTypeReference jvmTypeReference : types) {
			JvmType jvmType = jvmTypeReference.getType();
			if (jvmType instanceof JvmDeclaredType) {
				indexFeatures((JvmDeclaredType) jvmType, featureIndex);
			}
		}
		return removeOverridden(featureIndex, ctx);
	}

	protected void indexFeatures(JvmDeclaredType type, Multimap<Triple<EClass, String, Integer>, JvmFeature> index) {
		for (JvmMember member : type.getMembers()) {
			if (member instanceof JvmExecutable) {
				Triple<EClass, String, Integer> key = Tuples.create(member.eClass(), member.getSimpleName(),
						((JvmExecutable) member).getParameters().size());
				index.put(key, (JvmFeature) member);
			} else if (member instanceof JvmField) {
				Triple<EClass, String, Integer> key = Tuples.create(member.eClass(), member.getSimpleName(), -1);
				index.put(key, (JvmFeature) member);
			}
		}
	}

	protected Iterable<JvmFeature> removeOverridden(Multimap<Triple<EClass, String, Integer>, JvmFeature> featureIndex,
			ITypeArgumentContext ctx) {
		Set<JvmFeature> result = Sets.newLinkedHashSet(featureIndex.values());
		for (Collection<JvmFeature> featuresWithSameName : featureIndex.asMap().values()) {
			if (featuresWithSameName.size() > 1) {
				for (JvmFeature op1 : featuresWithSameName) {
					for (JvmFeature op2 : featuresWithSameName) {
						if (result.contains(op1) && op1.getDeclaringType() != op2.getDeclaringType()
								&& internalIsOverridden(op1, op2, ctx, true))
							result.remove(op2);
					}
				}
			}
		}
		return result;
	}

	protected boolean internalIsOverridden(JvmFeature overriding, JvmFeature overridden, ITypeArgumentContext context,
			boolean isCheckInheritance) {
		if (overriding == overridden)
			return false;
		if (!isNameEqual(overriding, overridden))
			return false;
		if (overriding instanceof JvmOperation && overridden instanceof JvmOperation) {
			JvmOperation overridingOp = (JvmOperation) overriding;
			JvmOperation overriddenOp = (JvmOperation) overridden;
			if(!isSameNumberOfTypeParameter(overridingOp, overriddenOp))
				return false;
			if (!isSameNumberOfArguments(overridingOp, overriddenOp))
				return false;
			if (!isSameArgumentTypes(overridingOp, overriddenOp, context))
				return false;
		}
		if (overriding instanceof JvmField && overridden instanceof JvmField) {
			JvmField overridingField = (JvmField) overriding;
			JvmField overriddenField = (JvmField) overridden;
			if (overridingField.isStatic() != overriddenField.isStatic())
				return false;
		}
		return true;
	}

	public boolean isOverridden(JvmFeature overriding, JvmFeature overridden, ITypeArgumentContext context,
			boolean isCheckInheritance) {
		if (overriding == overridden)
			return false;
		if (overridden.getClass() != overriding.getClass())
			return false;
		if (!isNameEqual(overriding, overridden))
			return false;
		if (isCheckInheritance && !isInheritanceRelation(overriding, overridden))
			return false;
		return internalIsOverridden(overriding, overridden, context, isCheckInheritance);
	}

	protected boolean isNameEqual(JvmFeature overriding, JvmFeature overridden) {
		return overriding.getSimpleName().equals(overridden.getSimpleName());
	}

	protected boolean isSameNumberOfTypeParameter(JvmOperation overriding, JvmOperation overridden){
		return overriding.getTypeParameters().size() == overridden.getTypeParameters().size();
	}

	protected boolean isSameNumberOfArguments(JvmOperation overriding, JvmOperation overridden) {
		return overriding.getParameters().size() == overridden.getParameters().size();
	}

	protected boolean isSameArgumentTypes(JvmOperation overriding, JvmOperation overridden,
			final ITypeArgumentContext context) {
		for (int i = 0; i < overriding.getParameters().size(); i++) {
			JvmFormalParameter overridingParam = overriding.getParameters().get(i);
			JvmFormalParameter overriddenParam = overridden.getParameters().get(i);
			JvmTypeReference overridingType = context.getLowerBound(overridingParam.getParameterType());
			JvmTypeReference overriddenType = context.getLowerBound(overriddenParam.getParameterType());
			if (!EcoreUtil.equals(overridingType, overriddenType)) {
				boolean result = new DeepChecker(context).visit(overridingType, overriddenType);
				if (!result)
					return result;
			}
		}
		return true;
	}

	protected boolean isSameConstraints(JvmConstraintOwner overridingConstraintOwner,
			JvmConstraintOwner overriddenConstraintOwner, ITypeArgumentContext context) {
		EList<JvmTypeConstraint> constraints = overriddenConstraintOwner.getConstraints();
		Set<JvmLowerBound> lowerBoundConstraints = Sets.newHashSet(Iterables.filter(constraints, JvmLowerBound.class));
		Set<JvmUpperBound> upperBoundConstraints = Sets.newHashSet(Iterables.filter(constraints, JvmUpperBound.class));
		Set<JvmTypeConstraint> overriddenConstraints = Sets.newHashSet(lowerBoundConstraints.size()>0?lowerBoundConstraints:upperBoundConstraints);
		for (JvmTypeConstraint overridingConstraint : overridingConstraintOwner.getConstraints()) {
			boolean matches = false;
			Iterator<JvmTypeConstraint> iter = overriddenConstraints.iterator();
			while (iter.hasNext() && !matches) {
				JvmTypeConstraint overriddenConstraint = iter.next();
				overriddenConstraint.getSimpleName();
				JvmTypeReference overridingType = context.getLowerBound(overridingConstraint.getTypeReference());
				JvmTypeReference overriddenType = context.getLowerBound(overriddenConstraint.getTypeReference());
				if (EcoreUtil.equals(overridingType, overriddenType)) {
					matches = true;
					iter.remove();
				} else {
					boolean result = new DeepChecker(context).visit(overridingType, overriddenType);
					if(result){
						matches = true;
						iter.remove();
					}
				}
			}
			if (!matches)
				return false;
		}
		if (overriddenConstraints.isEmpty())
			return true;
		return false;
	}

	protected boolean isInheritanceRelation(JvmMember overriding, JvmMember overridden) {
		return superTypeCollector.isSuperType(overriding.getDeclaringType(), overridden.getDeclaringType());
	}

	private final class DeepChecker extends
			AbstractTypeReferenceVisitorWithParameter.InheritanceAware<JvmTypeReference, Boolean> {
		private final ITypeArgumentContext context;

		private DeepChecker(ITypeArgumentContext context) {
			this.context = context;
		}

		@Override
		public Boolean doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, JvmTypeReference param) {
			if (!(param instanceof JvmGenericArrayTypeReference)) {
				return Boolean.FALSE;
			}
			JvmTypeReference myComponentType = reference.getComponentType();
			JvmTypeReference otherComponentType = ((JvmGenericArrayTypeReference) param).getComponentType();
			return visit(myComponentType, otherComponentType);
		}

		@Override
		public Boolean doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, JvmTypeReference param) {
			if (!(param instanceof JvmParameterizedTypeReference)) {
				return Boolean.FALSE;
			}
			JvmParameterizedTypeReference other = (JvmParameterizedTypeReference) param;
			if (reference.getArguments().size() != other.getArguments().size()) {
				return Boolean.FALSE;
			}
			if (reference.getType() != other.getType()) {
				JvmType plainOverridingType = reference.getType();
				JvmType plainOverriddenType = param.getType();
				if (plainOverridingType instanceof JvmTypeParameter && plainOverriddenType instanceof JvmTypeParameter) {
					JvmTypeParameter overridingTypeParameter = (JvmTypeParameter) plainOverridingType;
					JvmTypeParameter overriddenTypeParameter = (JvmTypeParameter) plainOverriddenType;
					return isSameConstraints(overridingTypeParameter, overriddenTypeParameter, context);

				}
				return Boolean.FALSE;
			} else {
				int typeParamCount = reference.getArguments().size();
				for (int i = 0; i < typeParamCount; i++) {
					JvmTypeReference myTypeArgument = reference.getArguments().get(i);
					JvmTypeReference otherTypeArgument = other.getArguments().get(i);
					if (!visit(myTypeArgument, otherTypeArgument)) {
						return Boolean.FALSE;
					}
				}
			}
			return Boolean.TRUE;
		}

		@Override
		public Boolean doVisitTypeReference(JvmTypeReference reference, JvmTypeReference param) {
			return Boolean.FALSE;
		}

		@Override
		public Boolean doVisitWildcardTypeReference(JvmWildcardTypeReference reference, JvmTypeReference param) {
			if (!(param instanceof JvmWildcardTypeReference)) {
				return Boolean.FALSE;
			}
			JvmWildcardTypeReference other = (JvmWildcardTypeReference) param;
			return isSameConstraints(reference, other, context);
		}
	}
}