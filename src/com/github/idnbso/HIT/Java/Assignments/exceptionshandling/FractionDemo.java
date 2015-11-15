package com.github.idnbso.hit.java.assignments.exceptionshandling;

public class FractionDemo {

	public static void main(String[] args) {
		try 
		{
			Fraction x = new Fraction(3,4);
			Fraction y = new Fraction(0,8);
			Fraction z = Fraction.divide(x, y);
			System.out.println(z);
			
			
			
		}
		catch(FractionDivideByZeroException e) 
		{
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
