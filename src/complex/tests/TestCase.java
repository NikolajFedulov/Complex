package complex.tests;

import complex.core.*;
import java.util.Map;
import java.util.EnumMap;
import java.util.ArrayList;

public class TestCase {
	
	public static class FromCartesian {
		private double realInput;
		private double imaginaryInput;
		private Complex complexExpected;
		private String description;
		
		private FromCartesian() {}
		
		private FromCartesian (double realInput, double imaginaryInput, Complex complexExpected, String description) {
			this.realInput = realInput;
			this.imaginaryInput = imaginaryInput;
			this.complexExpected = complexExpected;
			this.description = description;
		}
		
		public double getRealInput() {
			return this.realInput;
		}
		
		public double getimaginaryInput() {
			return this.imaginaryInput;
		}
		
		public Complex getComplexExpected() {
			return this.complexExpected;
		}
		
		public String getDescription() {
			return this.description;
		}
		
		public static FromCartesian create(double realInput, double imaginaryInput, Complex complexExpected, String description) {
			return new FromCartesian (realInput, imaginaryInput, complexExpected, description);
		}
	}
}
