package complex.tests;
import complex.core.Complex;

interface CompDbToBoolTest {
	Complex getComplexInput();
	double getDoubleInput();
	boolean getBooleanExpected();
	String getDescription();
}
