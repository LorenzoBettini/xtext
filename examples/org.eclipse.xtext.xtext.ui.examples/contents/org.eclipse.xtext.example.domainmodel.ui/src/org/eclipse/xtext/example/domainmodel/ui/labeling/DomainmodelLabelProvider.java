/*
* generated by Xtext
*/
package org.eclipse.xtext.example.domainmodel.ui.labeling;

import static org.eclipse.xtext.util.Strings.*;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * See http://www.eclipse.org/Xtext/documentation/16_ide_concepts.html#label-provider
 */
public class DomainmodelLabelProvider extends XbaseLabelProvider {

	@Inject
	public DomainmodelLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	@Override
	protected Object doGetImage(Object element) {
		if (element instanceof EObject && !(element instanceof JvmIdentifiableElement)) {
			return ((EObject) element).eClass().getName() + ".gif";
		}
		return super.doGetImage(element);
	}

	public String text(Property property) {
		StringBuilder builder = new StringBuilder();
		builder.append(notNull(property.getName()));
		builder.append(" : ");
		append(builder, property.getType());
		return builder.toString();
	}

	public String text(Operation operation) {
		StringBuilder builder = new StringBuilder();
		builder.append(notNull(operation.getName()));
		builder.append("(");
		boolean isFirst = true;
		for(JvmFormalParameter param: operation.getParams()) {
			if(!isFirst)
				builder.append(", ");
			isFirst = false;
			append(builder, param.getParameterType());
		}
		builder.append(") : ");
		append(builder, operation.getType());
		return builder.toString();
	}
	
	protected void append(StringBuilder builder, JvmTypeReference typeRef) {
		if (typeRef instanceof JvmParameterizedTypeReference) {
			final JvmType type = typeRef.getType();
			append(builder, type);
			EList<JvmTypeReference> arguments = ((JvmParameterizedTypeReference) typeRef).getArguments();
			if (!arguments.isEmpty()) {
				builder.append("<");
				Iterator<JvmTypeReference> iterator = arguments.iterator();
				while (iterator.hasNext()) {
					JvmTypeReference jvmTypeReference = iterator.next();
					append(builder, jvmTypeReference);
					if (iterator.hasNext())
						builder.append(",");
				}
				builder.append(">");
			}
		} else if (typeRef instanceof JvmWildcardTypeReference) {
			builder.append("?");
			Iterator<JvmTypeConstraint> iterator = ((JvmWildcardTypeReference) typeRef).getConstraints().iterator();
			while (iterator.hasNext()) {
				JvmTypeConstraint constraint = iterator.next();
				if (constraint instanceof JvmUpperBound) {
					builder.append(" extends ");
				} else {
					builder.append(" super ");
				}
				append(builder, constraint.getTypeReference());
				if (iterator.hasNext())
					builder.append(" & ");
			}
		} else if (typeRef instanceof JvmGenericArrayTypeReference) {
			append(builder, typeRef.getType());
		}
	}

	protected void append(StringBuilder builder, JvmType type) {
		if (type instanceof JvmArrayType) {
			append(builder, ((JvmArrayType) type).getComponentType());
			builder.append("[]");
		} else {
			builder.append(notNull(type.getSimpleName()));
		}
	}
}
