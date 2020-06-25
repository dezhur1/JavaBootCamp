package sef.module6.activity;

public abstract class Shape {

	private String color;// Changed to private
	
	public Shape() {

	}
	
	// Complete the code and Add abstract method calculateArea() and calculatePerimeter() with return type as double
	public abstract double calculateArea();
	public abstract double calculatePerimeter();
	
	public void setColor(String c) {
		color = c;
	}
	public String getColor() {
		return color;
	}
	
	

}
