import complex.core.Complex;
import complex.tests.*;

public class TestOfComplex {
	
	public static void main(String[] args) {
		var fromCartesian = TestCase.FromCartesian.create(0.0, 0.0, Complex.ZERO, "test");
		double real = fromCartesian.getRealInput();
	}

}
