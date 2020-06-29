package sef.module8.activity;
//Needs to be completed
//1 - extend this class from Exception class
public class CustomExceptionActivity extends Exception{

	//2 - Override getMessage() and provide the following message 
	// "You are not allowed to use this program"
	
	
	public String getMessage() {
		String msg = "You are not allowed to use this program";
		return msg;
	}
	
}
