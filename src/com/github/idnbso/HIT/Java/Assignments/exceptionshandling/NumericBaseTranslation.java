package com.github.idnbso.hit.java.assignments.exceptionshandling;

public class NumericBaseTranslation
{
    // args parameters: [number to convert] [base]
    public static void main(String[] args)
    {
        try
        {
            int numberToConvert = Integer.parseInt(args[0]);
            int baseToConvertTo = Integer.parseInt(args[1]);
            String numberInNewBase = Integer.toString(numberToConvert, baseToConvertTo);
            System.out.println(String.format("%d in base %d is %s", numberToConvert, baseToConvertTo, numberInNewBase));
        }
        catch (NumberFormatException e)
        {
            throw new NumberFormatException("The input string does not contain a parsable int.");
        }

    }

}
