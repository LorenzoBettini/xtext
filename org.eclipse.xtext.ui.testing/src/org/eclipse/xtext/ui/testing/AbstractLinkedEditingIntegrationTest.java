/*******************************************************************************
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.testing;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Holger Schill - Initial contribution and API
 * 
 * @since 2.12
 */
public abstract class AbstractLinkedEditingIntegrationTest extends AbstractEditorTest {

	protected void waitForReconciler(final XtextEditor editor) {
		editor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				// do nothing
			}
		});
	}
	
	/**
	 * @deprecated, use the inherited {@link AbstractWorkbenchTest#waitForEventProcessing} method instead.
	 */
	@Deprecated
	protected void waitForDisplay() {
		while(Display.getDefault().readAndDispatch()) {
		}
	}
	
	protected void pressKeys(XtextEditor editor, String string) throws Exception {
		for(int i = 0; i < string.length(); i++) {
			pressKey(editor, string.charAt(i));
		}
	}

	protected void pressKey(XtextEditor editor, char c) throws Exception {
		StyledText textWidget = editor.getInternalSourceViewer().getTextWidget();
		Event e = new Event();
		e.character = c;
		e.type = SWT.KeyDown;
		e.doit = true;
		//XXX Hack!
		if (c == SWT.ESC) {
			e.keyCode = 27;
		}
		textWidget.notifyListeners(SWT.KeyDown, e);
	}
}
