package com.PatientRestApp;

public class testtoken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   RandToken randToken = new RandToken();
	   String string =	randToken.nextSessionId();
	   
	   System.out.println(string);

	}

}
