package com.github.idnbso.hit.java.assignments.innerclasses.comparator;

public class Student
{
    private long id;
    private double average;

    public Student(long id, double average)
    {
        super();
        this.id = id;
        this.average = average;
    }

    public long getId()
    {
        return id;
    }

    public double getAverage()
    {
        return average;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public void setAverage(double average)
    {
        this.average = average;
    }

    @Override
    public String toString()
    {
        return "Student [id=" + id + ", average=" + average + "]";
    }
}
