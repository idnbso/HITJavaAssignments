package com.github.idnbso.hit.java.assignments.exceptionshandling;

public class FractionDivideByZeroException extends Exception {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    public FractionDivideByZeroException(String str) {
		super(str);
	}
	
	public FractionDivideByZeroException(String str, Throwable cause) {
		super(str,cause);
	}
	
}
