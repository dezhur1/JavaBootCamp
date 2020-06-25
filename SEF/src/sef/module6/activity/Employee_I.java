package sef.module6.activity;

// class Employee_I must extend class Person_I. Complete code for the same
public class Employee_I extends Person_I {
	
	//Attributes
	private double salary;
	private String title;
	
	//Behavior - write default constructor. Print 'I'm an Employee_I Constructor'
	public Employee_I () {
		this.salary = 0;
		this.title = "no title";
		System.out.println("I am an Employee_I constructor");
	}
	
	// write getter for int salary
	public double getSalary() {
		return salary;
	}
	
	// write setter for int salary
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	// write getter for String title
	public String getTitle() {
		return title;
	}
	
	// write setter for String title
	public void setTitle(String title) {
		this.title = title;
	}
}
