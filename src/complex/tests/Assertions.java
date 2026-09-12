package complex.tests;
import complex.core.Complex;

public class Assertions {
	private static int totalTests = 0;
    private static int passedTests = 0;
	
	public static final double EPS = 1e-9;
	
	public static void assertEquals(DbDbToCompTest testCase, Complex actual, double eps) {
		checkNull(testCase);
		checkNull(testCase.getComplexExpected());
		checkNull(actual);
		checkEps(eps);
		
		totalTests++;
		
        if (complexCheck(testCase.getComplexExpected(), actual, eps)) {
        	passedTests++;
        } else {
        	printFail(testCase.getDescription(), Double.toString(testCase.getDoubleInput1()), Double.toString(testCase.getDoubleInput2()), "", 
        			testCase.getComplexExpected().toString(), actual.toString());
        }
	}
	
	public static void assertEquals(DbToCompTest testCase, Complex actual, double eps) {
		checkNull(testCase);
		checkNull(testCase.getComplexExpected());
		checkNull(actual);
		checkEps(eps);
		
		totalTests++;
		
        if (complexCheck(testCase.getComplexExpected(), actual, eps)) {
        	passedTests++;
        } else {
        	printFail(testCase.getDescription(), Double.toString(testCase.getDoubleInput()), "", "", 
        			testCase.getComplexExpected().toString(), actual.toString());
        }
	}
	
	public static void assertEquals(CompCompToCompTest testCase, Complex actual, double eps) {
		checkNull(testCase);
		checkNull(testCase.getComplexExpected());
		checkNull(testCase.getComplexInput1());
		checkNull(testCase.getComplexInput2());
		checkNull(actual);
		checkEps(eps);
		
		totalTests++;
		
        if (complexCheck(testCase.getComplexExpected(), actual, eps)) {
        	passedTests++;
        } else {
        	printFail(testCase.getDescription(), testCase.getComplexInput1().toString(), testCase.getComplexInput2().toString(), "", 
        			testCase.getComplexExpected().toString(), actual.toString());
        }
	}
	
	public static void assertEquals(CompIntToCompTest testCase, Complex actual, double eps) {
		checkNull(testCase);
		checkNull(testCase.getComplexExpected());
		checkNull(testCase.getComplexInput());
		checkNull(actual);
		checkEps(eps);
		
		totalTests++;
		
        if (complexCheck(testCase.getComplexExpected(), actual, eps)) {
        	passedTests++;
        } else {
        	printFail(testCase.getDescription(), testCase.getComplexInput().toString(), Integer.toString(testCase.getIntInput()), "", 
        			testCase.getComplexExpected().toString(), actual.toString());
        }
	}
	
	public static void assertEquals(DbDbToBoolTest testCase, boolean actual) {
		checkNull(testCase);
		totalTests++;
		
		if (!(testCase.getBooleanExpected()^actual)) {
			passedTests++;
		} else {
			printFail(testCase.getDescription(), Double.toString(testCase.getDoubleInput1()), Double.toString(testCase.getDoubleInput2()), "",
					Boolean.toString(testCase.getBooleanExpected()), Boolean.toString(actual));
		}
	}
	
    public static void assertEquals(DbToBoolTest testCase, boolean actual) {
        checkNull(testCase);
        totalTests++;
        
        if (!(testCase.getBooleanExpected() ^ actual)) {
            passedTests++;
        } else {
            printFail(testCase.getDescription(), Double.toString(testCase.getDoubleInput()), "", "",
                    Boolean.toString(testCase.getBooleanExpected()), Boolean.toString(actual));
        }
    }

    public static void assertEquals(CompDbToBoolTest testCase, boolean actual) {
        checkNull(testCase);
        checkNull(testCase.getComplexInput());
        totalTests++;
        
        if (!(testCase.getBooleanExpected() ^ actual)) {
            passedTests++;
        } else {
            printFail(testCase.getDescription(), testCase.getComplexInput().toString(), Double.toString(testCase.getDoubleInput()), "",
                    Boolean.toString(testCase.getBooleanExpected()), Boolean.toString(actual));
        }
    }

    public static void assertEquals(CompToBoolTest testCase, boolean actual) {
        checkNull(testCase);
        checkNull(testCase.getComplexInput());
        totalTests++;
        
        if (!(testCase.getBooleanExpected() ^ actual)) {
            passedTests++;
        } else {
            printFail(testCase.getDescription(), testCase.getComplexInput().toString(), "", "",
                    Boolean.toString(testCase.getBooleanExpected()), Boolean.toString(actual));
        }
    }

    public static void assertEquals(CompCompDbToBoolTest testCase, boolean actual) {
        checkNull(testCase);
        checkNull(testCase.getComplexInput1());
        checkNull(testCase.getComplexInput2());
        totalTests++;
        
        if (!(testCase.getBooleanExpected() ^ actual)) {
            passedTests++;
        } else {
            printFail(testCase.getDescription(), testCase.getComplexInput1().toString(), testCase.getComplexInput2().toString(), Double.toString(testCase.getDoubleInput()),
                    Boolean.toString(testCase.getBooleanExpected()), Boolean.toString(actual));
        }
    }

    public static void assertEquals(CompCompToBoolTest testCase, boolean actual) {
        checkNull(testCase);
        checkNull(testCase.getComplexInput1());
        checkNull(testCase.getComplexInput2());
        totalTests++;
        
        if (!(testCase.getBooleanExpected() ^ actual)) {
            passedTests++;
        } else {
            printFail(testCase.getDescription(), testCase.getComplexInput1().toString(), testCase.getComplexInput2().toString(), "",
                    Boolean.toString(testCase.getBooleanExpected()), Boolean.toString(actual));
        }
    }
    
    public static void printSummary() {
        int failedTests = totalTests - passedTests;
        
        System.out.println("\n=== TEST SUMMARY ===");
        System.out.println("Total tests: " + totalTests);
        System.out.println("Passed:      " + passedTests);
        
        if (failedTests > 0) {
            System.err.println("Failed:      " + failedTests);
            System.err.println("STATUS:      SOME TESTS FAILED");
        } else {
            System.out.println("STATUS:      ALL TESTS PASSED SUCCESSFULLY!");
        }
    }
	
	private static boolean complexCheck(Complex expected, Complex actual, double eps) {
		boolean realMatch = false;
		boolean imagMatch = false;
		
		boolean expIsNaN = Double.isNaN(expected.getReal()) || Double.isNaN(expected.getImaginary());
        boolean expIsInf = Double.isInfinite(expected.getReal()) || Double.isInfinite(expected.getImaginary());
        
        if (expIsNaN) {
        	realMatch = Double.isNaN(actual.getReal());
        	imagMatch = Double.isNaN(actual.getImaginary());
        }
		
        if (expIsInf) {
        	realMatch = Double.isInfinite(actual.getReal());
        	imagMatch = Double.isInfinite(actual.getImaginary());
        }
        
        if (!expIsNaN && !expIsInf) {
        	realMatch = Math.abs(expected.getReal() - actual.getReal()) < eps;
            imagMatch = Math.abs(expected.getImaginary() - actual.getImaginary()) < eps;
        }
        
        return realMatch && imagMatch;
	}
	
	private static void printFail(String description, String input1, String input2, String input3, String expected, String actual) {
        System.err.printf("[FAIL] %s\n", description);
        System.err.printf("  Input Data: %s %s %s\n", input1, input2, input3);
        System.err.printf("  Expected: %s\n", expected);
        System.err.printf("  Received: %s\n\n", actual);
    }
	
	private static void checkNull(Object o) {
		if (o == null) {
			throw new NullPointerException("The object cannot be null.");
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
			throw new IllegalArgumentException("The epsilon value cannot be negative or zero.");
		}
	}
}
