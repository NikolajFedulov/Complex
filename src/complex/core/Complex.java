public class Complex {
	private static final double EPS = 1e-12;
	private double re;
	private double im;
	
	Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	Complex(double re) {
		this(re, 0.0);
	}
	
	Complex() {
		this(0.0, 0.0);
	}
	
	Complex(Complex z) {
		this(z.re, z.im);
	}
	
	@Override
	public boolean equals(Object o) {
		Complex z = (Complex) o;
		return Math.abs(this.re - z.re) < EPS && Math.abs(this.im - z.im) < EPS;
	}
	
	@Override
	public String toString() {
		return "Complex: " + re + " " + im;
	}
	
	public double getRe() {
		return this.re;
	}
	
	public double getIm() {
		return this.im;
	}
	
	public Complex getZ() {
		return new Complex(this.re, this.im);
	}
	
	public void setRe(double re) {
		this.re = re;
	}
	
	public void setIm(double im) {
		this.im = im;
	}
	
	public void setZ(Complex z) {
		this.re = z.re;
		this.im = z.im;
	}
	
	public double mod() {
		return Math.sqrt(re*re + im*im);
	}
	
	public double arg() {
		return Math.atan2(re, im);
	}
	
	public boolean isReal() {
		return Math.abs(im) < EPS;
	}
	
	public void pr() {
		System.out.println(re + (im < 0.0 ? "" : "+") + im + "i");
	}
	
	public void add(Complex z) {
		re += z.re;
		im += z.im;
	}
	
	public void sub(Complex z) {
		re -= z.re;
		im -= z.im;
	}
	
	public void mul(Complex z) {
		double t = re*z.re - im*z.im;
		im = re*z.im + im*z.re;
		re = t;
	}
	
	public void div(Complex z) {
		double denominator = z.re*z.re + z.im*z.im;
		double t = re*z.re + im*z.im;
		im = (im*z.re - re*z.im)/denominator;
		re = t/denominator;
	}
	
	public Complex plus(Complex z) {
		return new Complex(re + z.re, im + z.im);
	}
	
	public Complex minus(Complex z) {
		return new Complex(re - z.re, im - z.im);
	}
	
	public Complex asterisk(Complex z) {
		return new Complex(re*z.re - im*z.im, re*z.im + im*z.re);
	}
	
	public Complex slash(Complex z) {
		double denominator = z.re*z.re + z.im*z.im;
		return new Complex((re*z.re + im*z.im)/denominator, (im*z.re - re*z.im)/denominator);
	}
}
