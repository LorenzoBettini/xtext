/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal.tests;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguageRuntimeModule;
import org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguageStandaloneSetup;
import org.eclipse.xtext.testing.GlobalRegistries;
import org.eclipse.xtext.testing.GlobalRegistries.GlobalStateMemento;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.IRegistryConfigurator;

public class RegionAccessTestLanguageInjectorProvider implements IInjectorProvider, IRegistryConfigurator {

	protected GlobalStateMemento stateBeforeInjectorCreation;
	protected GlobalStateMemento stateAfterInjectorCreation;
	protected Injector injector;

	static {
		GlobalRegistries.initializeDefaults();
	}

	@Override
	public Injector getInjector() {
		if (injector == null) {
			this.injector = internalCreateInjector();
			stateAfterInjectorCreation = GlobalRegistries.makeCopyOfGlobalState();
		}
		return injector;
	}

	protected Injector internalCreateInjector() {
		return new RegionAccessTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(createRuntimeModule());
			}
		}.createInjectorAndDoEMFRegistration();
	}

	protected RegionAccessTestLanguageRuntimeModule createRuntimeModule() {
		// make it work also with Maven/Tycho and OSGI
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=493672
		return new RegionAccessTestLanguageRuntimeModule() {
			@Override
			public ClassLoader bindClassLoaderToInstance() {
				return RegionAccessTestLanguageInjectorProvider.class
						.getClassLoader();
			}
		};
	}

	@Override
	public void restoreRegistry() {
		stateBeforeInjectorCreation.restoreGlobalState();
		stateBeforeInjectorCreation = null;
	}

	@Override
	public void setupRegistry() {
		stateBeforeInjectorCreation = GlobalRegistries.makeCopyOfGlobalState();
		if (injector == null) {
			getInjector();
		}
		stateAfterInjectorCreation.restoreGlobalState();
	}
}
