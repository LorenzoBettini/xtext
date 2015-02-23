/*
 * generated by Xtext
 */
package org.eclipse.xtext.example.fowlerdsl.validation

import org.eclipse.xtext.example.fowlerdsl.statemachine.StatemachinePackage
import org.eclipse.xtext.validation.Check

/**
 * Custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/15_runtime_concepts.html#validation
 */
class StatemachineValidator extends AbstractStatemachineValidator {

  	public static val INVALID_NAME = 'invalidName'

	@Check
	def checkGreetingStartsWithCapital(org.eclipse.xtext.example.fowlerdsl.statemachine.State state) {
		if (Character.isUpperCase(state.name.charAt(0))) {
			warning('Name should start with a lower case letter', 
					StatemachinePackage.Literals.STATE__NAME,
					INVALID_NAME, state.name)
		}
	}
}
