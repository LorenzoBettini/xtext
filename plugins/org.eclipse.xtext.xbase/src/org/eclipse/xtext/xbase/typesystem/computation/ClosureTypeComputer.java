/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

/**
 * Externalized strategy for closure type computation which allows for easier unit testing.
 * Clients will usually not alter the implementation. Public methods are mostly public 
 * for testing purpose.
 * 
 * @see XbaseTypeComputer#_computeTypes(XClosure, ITypeComputationState)
 * @noinstantiate This class is not intended to be instantiated by clients.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ClosureTypeComputer {

	private final XClosure closure;
	private final ITypeComputationState state;
	
	private final CommonTypeComputationServices services;
	private final FunctionTypes functionTypes;
	private final ITypeExpectation expectation;
	private AbstractClosureTypeHelper strategy;
	
	public ClosureTypeComputer(XClosure closure, ITypeExpectation expectation, ITypeComputationState state) {
		this.closure = closure;
		this.expectation = expectation;
		this.state = state;
		this.services = state.getReferenceOwner().getServices();
		this.functionTypes = services.getFunctionTypes();
	}
	
	public void computeTypes() {
		selectStrategy();
		strategy.computeTypes();
	}
	
	/**
	 * This method is only public for testing purpose.
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void selectStrategy() {
		LightweightTypeReference expectedType = expectation.getExpectedType();
		if (expectedType == null) {
			strategy = new ClosureWithoutExpectationHelper(closure, expectation, state);
		} else {
			JvmOperation operation = functionTypes.findImplementingOperation(expectedType);
			JvmType type = expectedType.getType();
			int closureParameterSize = closure.getFormalParameters().size();
			if (operation == null || operation.getParameters().size() != closureParameterSize || type == null) {
				strategy = new ClosureWithoutExpectationHelper(closure, expectation, state);
			} else {
				strategy = new ClosureWithExpectationHelper(closure, operation, expectation, state);
			}
		}
		
	}

	/**
	 * This method is only public for testing purpose.
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public FunctionTypeReference getExpectedClosureType() {
		return strategy.getExpectedClosureType();
	}

	/**
	 * This method is only public for testing purpose.
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public JvmOperation getOperation() {
		return strategy.getOperation();
	}
}
