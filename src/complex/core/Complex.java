package complex.core;
import java.util.Objects;

public class Complex {
	public static final Complex ZERO = new Complex(0.0, 0.0);
	public static final Complex ONE = new Complex(1.0, 0.0);
	public static final Complex I = new Complex(0.0, 1.0);
	public static final Complex NaN = new Complex(Double.NaN, Double.NaN);
	public static final Complex INF = new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
	private static final double EPS = 1e-12;
	private final double real;
	private final double imaginary;
	
	
	// Constructors
	
	private Complex(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	private Complex() {
		this(0.0, 0.0);
	}
	
	
	// Static methods for object creation
	
	/**
	 * @param real
	 * @param imaginary
	 * @return
	 */
	public static Complex fromCartesian(double real, double imaginary) {
		if (Double.isInfinite(real) || Double.isInfinite(imaginary)) {
		    return INF;
		}
		if (Double.isNaN(real) || Double.isNaN(imaginary)) {
			System.err.println("WARNING: The real or imaginary part cannot be Not-a-Number (NaN). Returning Complex.NaN");
			return NaN;
		}
		if (real == 0.0 && imaginary == 0.0) {
			return ZERO;
		}
		if (real == 1 && imaginary == 0.0) {
			return ONE;
		}
		if (real == 0.0 && imaginary == 1) {
			return I;
		}
		return new Complex(real, imaginary);
	}
	
	/**
	 * @param real
	 * @return
	 */
	public static Complex fromRealOnly(double real) {
		return fromCartesian(real, 0.0);
	}
	
	/** 
	 * @param imaginary
	 * @return
	 */
	public static Complex fromImaginaryOnly(double imaginary) {
		return fromCartesian(0.0, imaginary);
	}
	
	/**
	 * @param modulus
	 * @param argument
	 * @return
	 */
	public static Complex fromPolar(double modulus, double argument) {
		if (Double.isNaN(modulus)) {
			System.err.println("WARNING: The modulus cannot be Not-a-Number (NaN). Returning Complex.NaN");
	        return NaN; 
	    }
		if (Double.isInfinite(argument)) {
	        System.err.println("WARNING: The argument cannot be infinite. Returning Complex.NaN");
	        return NaN;
	    }
		if (modulus < 0 && !Double.isInfinite(modulus)) {
			throw new IllegalArgumentException("The modulus cannot be negative.");
		}
	    if (Double.isInfinite(modulus) || modulus == 0.0) {
	        if (Double.isNaN(argument)) {
	        	return  Double.isInfinite(modulus)? INF : ZERO ;
	        } else {
	        	System.err.println("WARNING: Invalid argument for zero or infinite modulus: the argument must be Not-a-Number (NaN). Returning Complex.NaN");
	        	return NaN;
	        } 
	    }
        double real = modulus * Math.cos(argument);
        double imaginary = modulus * Math.sin(argument);
        return fromCartesian(real, imaginary);
    }
	
	
	// Static methods "is"
	
	/**
	 * @param complex
	 * @return
	 */
	public static boolean isZERO(Complex complex) {
		checkComplexNull(complex);
		return complex.real == 0.0 && complex.imaginary == 0.0;
	}
	
	/**
	 * @param complex
	 * @return
	 */
	public static boolean isONE(Complex complex) {
		checkComplexNull(complex);
		return complex.real == 1.0 && complex.imaginary == 0.0;
	}
	
	/**
	 * @param complex
	 * @return
	 */
	public static boolean isI(Complex complex) {
		checkComplexNull(complex);
		return complex.real == 0.0 && complex.imaginary == 1.0;
	}
	
	/**
	 * @param complex
	 * @return
	 */
	public static boolean isNaN(Complex complex) {
		checkComplexNull(complex);
		return Double.isNaN(complex.real) || Double.isNaN(complex.imaginary);
	}
	
	/**
	 * @param complex
	 * @return
	 */
	public static boolean isINF(Complex complex) {
		checkComplexNull(complex);
		return Double.isInfinite(complex.real) || Double.isInfinite(complex.imaginary);
	}
	
	/**
	 * @param real
	 * @param eps
	 * @return
	 */
	public static boolean isRealNearlyZero(double real, double eps) {
		checkEps(eps);
		return Math.abs(real) < eps;
	}
	
	/**
	 * @param real
	 * @return
	 */
	public static boolean isRealNearlyZero(double real) {
		return isRealNearlyZero(real, EPS);
	}
	
	/**
	 * @param complex
	 * @param eps
	 * @return
	 */
	public static boolean isRealNearlyZero(Complex complex, double eps) {
		checkComplexNull(complex);
		checkEps(eps);
		return Math.abs(complex.real) < eps;
	}
	
	/**
	 * @param complex
	 * @return
	 */
	public static boolean isRealNearlyZero(Complex complex) {
		return isRealNearlyZero(complex, EPS);
	}
	
	/**
	 * @param imaginary
	 * @param eps
	 * @return
	 */
	public static boolean isImaginaryNearlyZero(double imaginary, double eps) {
		checkEps(eps);
		return Math.abs(imaginary) < eps;
	}
	
	/**
	 * @param imaginary
	 * @return
	 */
	public static boolean isImaginaryNearlyZero(double imaginary) {
		return isImaginaryNearlyZero(imaginary, EPS);
	}
	
	/**
	 * @param complex
	 * @param eps
	 * @return
	 */
	public static boolean isImaginaryNearlyZero(Complex complex, double eps) {
		checkComplexNull(complex);
		checkEps(eps);
		return Math.abs(complex.imaginary) < eps;
	}
	
	/**
	 * @param complex
	 * @return
	 */
	public static boolean isImaginaryNearlyZero(Complex complex) {
		return isImaginaryNearlyZero(complex, EPS);
	}
	
	/**
	 * @param complex
	 * @param eps
	 * @return
	 */
	public static boolean isCloseToZERO(Complex complex, double eps) {
		checkComplexNull(complex);
		checkEps(eps);
		return Math.abs(complex.real) < eps && Math.abs(complex.imaginary) < eps;
	}
	
	/**
	 * @param complex
	 * @return
	 */
	public static boolean isCloseToZERO(Complex complex) {
		return isCloseToZERO(complex, EPS);
	}
	
	/**
	 * @param complex
	 * @param eps
	 * @return
	 */
	public static boolean isCloseToONE(Complex complex, double eps) {
		checkComplexNull(complex);
		checkEps(eps);
		return Math.abs(1 - complex.real) < eps && Math.abs(complex.imaginary) < eps;
	} 
	
	/**
	 * @param complex
	 * @return
	 */
	public static boolean isCloseToONE(Complex complex) {
		return isCloseToONE(complex, EPS);
	}
	
	/**
	 * @param complex
	 * @param eps
	 * @return
	 */
	public static boolean isCloseToI(Complex complex, double eps) {
		checkComplexNull(complex);
		checkEps(eps);
		return Math.abs(complex.real) < eps && Math.abs(1 - complex.imaginary) < eps;
	}
	
	/**
	 * @param complex
	 * @return
	 */
	public static boolean isCloseToI(Complex complex) {
		return isCloseToI(complex, EPS);
	}
	
	/**
	 * @param complex1
	 * @param complex2
	 * @param eps
	 * @return
	 */
	public static boolean compareComplexApproximately(Complex complex1, Complex complex2, double eps) {
		checkComplexNull(complex1, complex2);
		checkEps(eps);
		
		if(isNaN(complex1) || isNaN(complex2)) {
			throw new IllegalArgumentException("The complex argument cannot be Not-a-Number (NaN).");
		}
		if(isINF(complex1) || isINF(complex2)) {
			throw new IllegalArgumentException("The complex argument cannot be infinite.");
		}
		
		double absRealDifference = Math.abs(complex1.getReal() - complex2.getReal());
		double absImagDifference = Math.abs(complex1.getImaginary() - complex2.getImaginary());
		return absRealDifference < eps && absImagDifference < eps;
	}
	
	/**
	 * @param complex1
	 * @param complex2
	 * @return
	 */
	public static boolean compareComplexApproximately(Complex complex1, Complex complex2) {
		return compareComplexApproximately(complex1, complex2, EPS);
	}
	
	
	// get methods
	
	/**
	 * @return
	 */
	public double getReal() {
		return real;
	} 
	
	/**
	 * @return
	 */
	public double getImaginary() {
		return imaginary;
	}
	
	/**
	 * @return
	 */
	public double getModulus() {
		return modulus(real, imaginary);
	}
	
	/**
	 * @return
	 */
	public double getArgument() {
		return argument(real, imaginary);
	}
	
	/**
	 * @return
	 */
	public double getArgumentInRadians0To2Pi() {
	    double rad = argument(real, imaginary);
	    if (Double.isNaN(rad)) {
	        return Double.NaN; 
	    }
	    return (rad < 0) ? (rad + 2 * Math.PI) : rad;
	}
	
	/**
	 * @return
	 */
	public double getArgumentInDegrees0To360() {
	    double deg = Math.toDegrees(argument(real, imaginary));
	    if (Double.isNaN(deg)) {
	        return Double.NaN;
	    }
	    return (deg < 0) ? (deg + 360.0) : deg;
	}
	
	
	// equals, hashCode, toString
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		Complex complex = (Complex) o;
		 return Double.compare(complex.real, real) == 0 && Double.compare(complex.imaginary, imaginary) == 0;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(real, imaginary);
	}
	
	@Override
	public String toString() {
		return "Complex{real=" + real + ", imaginary=" + imaginary + "}";
	}
	
	
	// Operations on complex numbers
	
	/**
	 * @param complex
	 * @return
	 */
	public static Complex additiveInverse(Complex complex) {
		checkComplexNull(complex);
		if (isNaN(complex)) {
			return NaN;
		}
		if (isINF(complex)) {
			return INF;
		}
		if (isZERO(complex)) {
			return ZERO;
		}
		return fromCartesian(-complex.getReal(), -complex.getImaginary());
	}
	
	/**
	 * @param complex
	 * @return
	 */
	public static Complex complexConjugate(Complex complex) {
		checkComplexNull(complex);
		if (isNaN(complex)) {
			return NaN;
		}
		if (isINF(complex)) {
			return INF;
		}
		if (isZERO(complex)) {
			return ZERO;
		}
		return fromCartesian(complex.getReal(), -complex.getImaginary());
	}
	
	/**
	 * @param complex1
	 * @param complex2
	 * @return
	 */
	public static Complex add(Complex complex1, Complex complex2) {
		checkComplexNull(complex1, complex2);
		return fromCartesian(complex1.real + complex2.real, complex1.imaginary + complex2.imaginary);
	}
	
	/**
	 * @param complex1
	 * @param complex2
	 * @return
	 */
	public static Complex subtract(Complex complex1, Complex complex2) {
		checkComplexNull(complex1, complex2);
		return fromCartesian(complex1.real - complex2.real, complex1.imaginary - complex2.imaginary);
	}
	
	/**
	 * @param complex1
	 * @param complex2
	 * @return
	 */
	public static Complex multiply(Complex complex1, Complex complex2) {
		checkComplexNull(complex1, complex2);
		if (isNaN(complex1) || isNaN(complex2)) {
			return NaN;
		}
		if (isINF(complex1) || isINF(complex2)) {
			return INF;
		}
		return fromCartesian(complex1.real*complex2.real - complex1.imaginary*complex2.imaginary, 
				complex1.real*complex2.imaginary + complex2.real*complex1.imaginary);
	}
	
	/**
	 * @param complexNumerator
	 * @param complexDenominator
	 * @return
	 */
	public static Complex divide(Complex complexNumerator, Complex complexDenominator) {
		checkComplexNull(complexNumerator, complexDenominator);
		if (isNaN(complexNumerator) || isNaN(complexDenominator) || 
				(isINF(complexNumerator) && isINF(complexDenominator)) || 
				(isZERO(complexNumerator) && isZERO(complexDenominator))) {
			return NaN;
		}
		if (isINF(complexNumerator) || isZERO(complexDenominator)) {
			return INF;
		}
		if (isINF(complexDenominator)) {
			return ZERO;
		}
		// Robust complex division using Smith's method with exponent scaling (Stewart's approach) 
		// to protect against overflow/underflow
		double real1 = complexNumerator.real;
		double imaginary1 = complexNumerator.imaginary;
		double real2 = complexDenominator.real;
		double imaginary2 = complexDenominator.imaginary;
		
		int maxExp = Math.max(Math.getExponent(real2), Math.getExponent(imaginary2));
		int scale = (maxExp > 500 || maxExp < -500) ? -maxExp : 0;
		
		real1 = Math.scalb(real1, scale);
		imaginary1 = Math.scalb(imaginary1, scale);
		real2 = Math.scalb(real2, scale);
		imaginary2 = Math.scalb(imaginary2, scale);
		
		double resReal;
	    double resImaginary;
	    
	    if (Math.abs(real2) >= Math.abs(imaginary2)) {
	        double r = imaginary2 / real2;
	        double denominator = real2 + imaginary2 * r;
	        resReal = (real1 + imaginary1 * r) / denominator;
	        resImaginary = (imaginary1 - real1 * r) / denominator;
	    } else {
	        double r = real2 / imaginary2;
	        double denominator = imaginary2 + real2 * r;
	        resReal = (real1 * r + imaginary1) / denominator;
	        resImaginary = (imaginary1 * r - real1) / denominator;
	    }
		
	    return fromCartesian(Math.scalb(resReal, scale), Math.scalb(resImaginary, scale));		
	}
	
	/**
	 * @param complex
	 * @param exponent
	 * @return
	 */
	public static Complex power(Complex complex, int exponent) {
		checkComplexNull(complex);
		if (isNaN(complex)) {
			return NaN;
		}
		if (isINF(complex)) {
			return (exponent > 0) ? INF : ZERO;
		}
		if (isZERO(complex)) {
			return (exponent > 0) ? ZERO : INF;
		}
		
		if (exponent == 0) {
			return (isZERO(complex) || isINF(complex)) ? NaN : ONE;
		}
		if (exponent == 1) {
			return complex;
		}
		if (exponent == -1) {
			return divide(ONE, complex);
		}
		if (exponent == 2) {
			return multiply(complex, complex);
		}
		if (exponent == -2) {
			return divide(ONE, multiply(complex, complex));
		}
		
		double modulus = modulus(complex.real, complex.imaginary);
		double argument = exponent*argument(complex.real, complex.imaginary);
		modulus = Math.pow(modulus, exponent);
		
		return polarToCartesian(modulus, argument);
	}
	
	/**
	 * @param complex
	 * @param exponent
	 * @return
	 */
	public static Complex[] root(Complex complex, int exponent) {
		checkComplexNull(complex);
		
		if (exponent == 0) {
			throw new IllegalArgumentException("The exponent cannot be zero.");
		}
		
		int absExponent = Math.abs(exponent);
		Complex[] complexArray = new Complex[absExponent];
		
		if (isNaN(complex)) {
			for (int i=0; i < absExponent; i++) {
				complexArray[i] = NaN;
			}
			return complexArray;
		}
		if ((isINF(complex) && exponent > 0) || (isZERO(complex) && exponent < 0)) {
			for (int i=0; i < absExponent; i++) {
				complexArray[i] = INF;
			}
			return complexArray;
		}
		if ((isINF(complex) && exponent < 0) || (isZERO(complex) && exponent > 0)) {
			for (int i=0; i < absExponent; i++) {
				complexArray[i] = ZERO;
			}
			return complexArray;
		}
		
		if(exponent == 1) {
			complexArray[0] = complex;
			return complexArray;
		}
		if(exponent == -1) {
			complexArray[0] = divide(ONE, complex);
			return complexArray;
		}
		
		double invertedExponent = 1.0/exponent;
		
		double modulus = modulus(complex.real, complex.imaginary);
		modulus = Math.pow(modulus, invertedExponent);
		
		double argument = argument(complex.real, complex.imaginary);
		double argumentArray[] = new double[absExponent];
		for (int i=0; i<absExponent; i++) {
			argumentArray[i] = (argument + i*2*Math.PI)/exponent;
		}
		
		for (int i=0; i<absExponent; i++) {
			complexArray[i] = polarToCartesian(modulus, argumentArray[i]);
		}
		
		return complexArray;
	}
	
	
	// Private methods
	
	private static void checkComplexNull(Complex complex1, Complex complex2) {
		if(complex1 == null || complex2 == null) {
			throw new NullPointerException("The complex argument cannot be null.");
		}
	}
	
	private static void checkComplexNull(Complex complex) {
		if(complex == null) {
			throw new NullPointerException("The complex argument cannot be null.");
		}
	}
	
	private static void checkEps(double eps) {
		if (Double.isNaN(eps)) {
	        throw new IllegalArgumentException("The epsilon value cannot be Not-a-Number (NaN).");
	    }
		if (Double.isInfinite(eps)) {
	        throw new IllegalArgumentException("The epsilon value cannot be infinite.");
	    }
		if (eps <= 0) {
	        throw new IllegalArgumentException("The epsilon value cannot be negative.");
	    }
	}
	
	private static double modulus(double real, double imaginary) {
		return Math.hypot(real, imaginary);
	}
	
	private static double argument(double real, double imaginary) {
		if ((Double.isInfinite(real) || Double.isInfinite(imaginary)) ||
				(real == 0.0 && imaginary == 0.0)) {
			return Double.NaN;
		}
		return Math.atan2(imaginary, real);
	}
	
	private static Complex polarToCartesian(double modulus, double argument) {
		double real = modulus * Math.cos(argument);
		double imaginary = modulus * Math.sin(argument);
		return fromCartesian(real, imaginary);
	}
	
}
