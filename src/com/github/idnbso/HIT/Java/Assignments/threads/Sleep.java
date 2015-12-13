package com.github.idnbso.hit.java.assignments.threads;

public class Sleep extends Thread
{
    private final static int totalPrintIterations = 100;
    
    public static void main(String[] args) throws InterruptedException
    {
        String strToPrint = args[0];
        long delayInMilliseconds = Integer.parseInt(args[1]);
        
        for (int iteration = 1; iteration <= totalPrintIterations; iteration++)
        {
            sleep(delayInMilliseconds);
            System.out.println(iteration + ": " + strToPrint);
        }
    }

}
