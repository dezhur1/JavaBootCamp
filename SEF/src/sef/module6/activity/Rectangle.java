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
	public double calculateArea(double lengh, double breath) {
		return lengh*breath;
	}
	public calculatePerimeter(double lengh, double breath) {
		return lengh*breath*2
		
	}
}
