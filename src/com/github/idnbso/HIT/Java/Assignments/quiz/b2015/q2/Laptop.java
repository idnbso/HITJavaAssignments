package com.github.idnbso.hit.java.assignments.quiz.b2015.q2;

public class Laptop extends Computer
{
    public static void sketch()
    {
        System.out.println("Laptop.sketch()");// Compile error

    }
    
    public static void main(String[] args)
    {
        sketch();
    }

    @Override
    public void something()
    {
        // TODO Auto-generated method stub
        
    }


}
