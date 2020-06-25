package sef.module6.activity;

public class Rectangle extends Shape {
	private double lengh;
	private double breath;

	public Rectangle() { // Def cobstructor
		this.lengh = 0;
		this.breath = 0;
	}
	public Rectangle(double lengh, double breath) { //Parameterized constructor
		this.lengh = lengh;
		this.breath = breath;
	}
	
	public double getLengh() {
		return lengh;
	}
	public void setLengh(double lengh) {
		this.lengh = lengh;
	}
	public double getBreath() {
		return breath;
	}
	public void setBreath(double breath) {
		this.breath = breath;
	}

	@Override
	public double calculateArea() {
		return lengh*breath;
	}
	@Override
	public double calculatePerimeter() {
		return (lengh+breath)*2;
	}
}
