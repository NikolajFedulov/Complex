package complex.tests;
import complex.core.Complex;

class TestCaseImpl implements DbDbToCompTest, DbToCompTest, 
							DbDbToBoolTest, DbToBoolTest, 
							CompDbToBoolTest, CompToBoolTest,
							CompCompDbToBoolTest, CompCompToBoolTest, 
							CompCompToCompTest, CompIntToCompTest{
	private double doubleInput1;
	private double doubleInput2;
	private Complex complexInput1;
	private Complex complexInput2;
	private int intInput;
	
	private Complex complexExpected;
	private boolean booleanExpected;
	
	private String description;
	
	
	private TestCaseImpl() {}
	
	TestCaseImpl(double input1, double input2, Complex expected, String description){
		this.doubleInput1 = input1;
		this.doubleInput2 = input2;
		this.complexExpected = expected;
		this.description = description;
	}
	
	TestCaseImpl(double input1, Complex expected, String description){
		this(input1, 0.0, expected, description);
	}
	
	TestCaseImpl(double input1, double input2, boolean expected, String description){
		this.doubleInput1 = input1;
		this.doubleInput2 = input2;
		this.booleanExpected = expected;
		this.description = description;
	}
	
	TestCaseImpl(double input1, boolean expected, String description){
		this(input1, 0.0, expected, description);
	}
	
	TestCaseImpl(Complex input1, double input2, boolean expected, String description){
		this.complexInput1 = input1;
		this.doubleInput1 = input2;
		this.booleanExpected = expected;
		this.description = description;
	}
	
	TestCaseImpl(Complex input1, boolean expected, String description){
		this(input1, 0.0, expected, description);
	}
	
	TestCaseImpl(Complex input1, Complex input2, double input3, boolean expected, String description){
		this.complexInput1 = input1;
		this.complexInput2 = input2;
		this.doubleInput1 = input3;
		this.booleanExpected = expected;
		this.description = description;
	}
	
	TestCaseImpl(Complex input1, Complex input2, boolean expected, String description){
		this(input1, input2, 0.0, expected, description);
	}
	
	TestCaseImpl(Complex input1, Complex input2, Complex expected, String description){
		this.complexInput1 = input1;
		this.complexInput2 = input2;
		this.complexExpected = expected;
		this.description = description;
	}
	
	TestCaseImpl(Complex input1, int input2, Complex expected, String description){
		this.complexInput1 = input1;
		this.intInput = input2;
		this.complexExpected = expected;
		this.description = description;
	}
	
	@Override
	public double getDoubleInput1() {
		return this.doubleInput1;
	}
	
	@Override
	public double getDoubleInput2() {
		return this.doubleInput2;
	}
	
	@Override
	public Complex getComplexInput1() {
		return this.complexInput1;
	}
	
	@Override
	public Complex getComplexInput2() {
		return this.complexInput2;
	}
	
	@Override
	public int getIntInput() {
		return this.intInput;
	}
	
	@Override
	public Complex getComplexExpected() {
		return this.complexExpected;
	}
	
	@Override
	public boolean getBooleanExpected() {
		return this.booleanExpected;
	}
	
	@Override
	public String getDescription() {
		return this.description;
	}
	
	@Override
	public Complex getComplexInput() {
		return getComplexInput1();
	}
	
	@Override
	public double getDoubleInput() {
		return getDoubleInput1();
	}
}
