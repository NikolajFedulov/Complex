package complex.tests;
import complex.core.Complex;

public class TestFactory {
	
	private TestFactory() {}
	
	public static DbDbToCompTest createTestCase(double input1, double input2, Complex expected, String description) {
		DbDbToCompTest testCase = new TestCaseImpl(input1, input2, expected, description);
		return testCase;
	}
	
	public static DbToCompTest createTestCase(double input, Complex expected, String description) {
		return new TestCaseImpl(input, expected, description);
	}
	
	public static CompDbToBoolTest createTestCase(Complex input1, double input2, boolean expected, String description) {
		return new TestCaseImpl(input1, input2, expected, description);
	}
	
	public static CompToBoolTest createTestCase(Complex input, boolean expected, String description) {
		return new TestCaseImpl(input, expected, description);
	}
	
	public static DbDbToBoolTest createTestCase(double input1, double input2, boolean expected, String description){
		return new TestCaseImpl(input1, input2, expected, description);
	}
	
	public static DbToBoolTest createTestCase(double input, boolean expected, String description){
		return new TestCaseImpl(input, expected, description);
	}
	
	public static CompCompDbToBoolTest createTestCase(Complex input1, Complex input2, double input3, boolean expected, String description) {
		return new TestCaseImpl(input1, input2, input3, expected, description);
	}
	
	public static CompCompToBoolTest createTestCase(Complex input1, Complex input2, boolean expected, String description) {
		return new TestCaseImpl(input1, input2, expected, description);
	}
	
	public static CompCompToCompTest createTestCase(Complex input1, Complex input2, Complex expected, String description) {
		return new TestCaseImpl(input1, input2, expected, description);
	}
	
	public static CompIntToCompTest createTestCase(Complex input1, int input2, Complex expected, String description){
		return new TestCaseImpl(input1, input2, expected, description);
	}
}
