/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.example.entities.idea.facet

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.StoragePathMacros
import com.intellij.openapi.components.StorageScheme
import org.eclipse.xtext.xbase.idea.facet.XbaseFacetConfiguration
import org.eclipse.xtext.xbase.idea.facet.XbaseGeneratorConfigurationState

@State(name = "org.eclipse.xtext.idea.example.entities.EntitiesGenerator", storages = #[
		@Storage(id = "default", file = StoragePathMacros.PROJECT_FILE),
		@Storage(id = "dir", file = StoragePathMacros.PROJECT_CONFIG_DIR
				+ "/EntitiesGeneratorConfig.xml", scheme = StorageScheme.DIRECTORY_BASED)])
 class EntitiesFacetConfiguration extends XbaseFacetConfiguration implements PersistentStateComponent<XbaseGeneratorConfigurationState>{

}
