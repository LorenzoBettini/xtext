/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.typing;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * Represents the function ASTNode -> Type, which is the main concept of a type system. 
 */
public interface ITypeProvider<T> {

	/**
	 * computes the type of the given astNode.
	 * @param astNode - the node for which to compute the type T
	 * 
	 * @return the type T or null. <code>null</code> indicates a problem with type resolution. 
	 * 		   Clients shouldn't register follow up errors in that case.
	 */
	public T getType(EObject astNode);
	
}
