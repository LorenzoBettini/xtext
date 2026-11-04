package test

import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtend.lib.macro.file.FileLocations

class XtendA extends JavaB implements FileLocations {

	@Delegate FileLocations locations

	def void use(java.util.function.Consumer<String> consumer) {}

	def void convert((String)=>void fn) {
		use(fn)
	}

	def JavaB test2(XtendC s) {
		return s.foo.newJavaB
	}

	def JavaB newJavaB() {
		return new JavaB()
	}

	def JavaRecord newJavaRecord() {
		return new JavaRecord("a test")
	}
}