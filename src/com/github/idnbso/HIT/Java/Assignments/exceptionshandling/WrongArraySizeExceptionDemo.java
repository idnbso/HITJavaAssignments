package com.github.idnbso.hit.java.assignments.exceptionshandling;

public class WrongArraySizeExceptionDemo
{
    public static void main(String args[])
    {
        try
        {
            DoublesVec dVec = new DoublesVec(23, 98.4);
            dVec.set(23.3, 12);
            System.out.println(dVec);
            DoublesVec dVes = new DoublesVec(-2, 3);
            System.out.println(
                    "A DoublesVec instance with the size of -2 was successfully instantiated smile");
            dVes.toString();
        }
        catch (WrongArraySizeException e)
        {
            e.printStackTrace();
        }
    }
}