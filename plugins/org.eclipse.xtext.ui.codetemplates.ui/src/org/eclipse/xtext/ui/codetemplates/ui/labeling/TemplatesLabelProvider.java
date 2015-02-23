/*
* generated by Xtext
*/
package org.eclipse.xtext.ui.codetemplates.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * See http://www.eclipse.org/Xtext/documentation/16_ide_concepts.html#label-provider
 */
public class TemplatesLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public TemplatesLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

/*
	//Labels and icons can be computed like this:
	
	String text(MyModel ele) {
	  return "my "+ele.getName();
	}
	 
    String image(MyModel ele) {
      return "MyModel.gif";
    }
*/
}
