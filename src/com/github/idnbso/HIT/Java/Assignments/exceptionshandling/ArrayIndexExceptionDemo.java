package com.github.idnbso.hit.java.assignments.exceptionshandling;

public class ArrayIndexExceptionDemo
{

    public static void main(String[] args)
    {
        final int totalNumbers = 100;
        int vec[] = new int[totalNumbers];

        try
        {
            int lastNumber = 0;
            for (int number : vec)
            {
                number += lastNumber + 1;
                lastNumber = number;
                System.out.print(String.format("%d\n", number));
            }
            vec[101] = 0;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw new ArrayIndexOutOfBoundsException("An index out of bounds of the array was used to access an element.");
        }
    }
}
