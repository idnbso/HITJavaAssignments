package com.github.idnbso.hit.java.assignments.reflection;

class Rectangle
{
    double width;
    double height;

    public void testRectangle(String msg)
    {
        if (msg != null)
        {
            System.out.println(msg);
        }
        else
        {
            System.out.println("This is a test.");
        }
    }

    public String toString()
    {
        return "width=" + width + "  height=" + height;
    }
}