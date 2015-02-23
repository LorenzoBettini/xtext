/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.ui.labeling

import org.eclipse.xtext.xbase.ui.labeling.XbaseDescriptionLabelProvider

//import org.eclipse.xtext.resource.IEObjectDescription

/**
 * Provides labels for a IEObjectDescriptions and IResourceDescriptions.
 * 
 * See https://www.eclipse.org/Xtext/documentation/16_ide_concepts.html#label-provider
 */
class RuleEngineDescriptionLabelProvider extends XbaseDescriptionLabelProvider {

	// Labels and icons can be computed like this:
	
//	override text(IEObjectDescription ele) {
//		ele.name.toString
//	}
//	 
//	override image(IEObjectDescription ele) {
//		ele.EClass.name + '.gif'
//	}	 
}
