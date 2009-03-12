/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.Collections;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LoggingGeneratorFragment implements IGeneratorFragment {

	private static Logger log = Logger.getLogger(LoggingGeneratorFragment.class);

	private String message;

	private Level level;

	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		if (message != null)
			log.log(level, message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
	}

	public void addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {
	}

	public void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {
	}

	public String[] getExportedPackagesRt(Grammar grammar) {
		return Strings.EMPTY_ARRAY;
	}

	public String[] getExportedPackagesUi(Grammar grammar) {
		return Strings.EMPTY_ARRAY;
	}

	public Map<String, String> getGuiceBindingsRt(Grammar grammar) {
		return Collections.emptyMap();
	}

	public Map<String, String> getGuiceBindingsUi(Grammar grammar) {
		return Collections.emptyMap();
	}

	public String[] getRequiredBundlesRt(Grammar grammar) {
		return Strings.EMPTY_ARRAY;
	}

	public String[] getRequiredBundlesUi(Grammar grammar) {
		return Strings.EMPTY_ARRAY;
	}

}
