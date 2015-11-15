package com.github.idnbso.hit.java.assignments.exceptionshandling;

class DoublesVec
{
    private double vec[];

    DoublesVec(int size) throws WrongArraySizeException
    {
        if (size > 0)
        {
            vec = new double[size];
        }
        else
        {
            throw new WrongArraySizeException("The size of the array must be positive.");
        }
    }

    DoublesVec(int size, double value) throws WrongArraySizeException
    {
        this(size);
        for (int i = 0; i < vec.length; i++)
        {
            vec[i] = value;
        }
    }

    public double get(int index)
    {
        return vec[index];
    }

    public void set(double value, int index)
    {
        if (index >= 0 && index < vec.length)
        {
            vec[index] = value;
        }
    }

    public double getAverage()
    {
        double sum = 0;
        for (int i = 0; i < vec.length; i++)
        {
            sum += vec[i];
        }
        return sum / vec.length;
    }

    public String toString()
    {
        StringBuffer result = new StringBuffer("The values are : ");
        for (int i = 0; i < vec.length; i++)
        {
            result.append("\n" + vec[i]);
        }
        result.append("\nThe average is : " + getAverage());
        return result.toString();
    }
}