package com.github.idnbso.hit.java.assignments.threads;

public class SalamPeaceDemo
{
    public static void main(String[] args)
    {
        final int totalIterations = 20;
        Thread salam = new Thread() {
            
            @Override
            public void run()
            {
                for (int i = 0; i < totalIterations; i++)
                {
                    System.out.println("Salam");
                    try
                    {
                        Thread.sleep(50);
                    }
                    catch (InterruptedException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            } 
        };
        
        Thread peace = new Thread() {
            
            @Override
            public void run()
            {
                for (int i = 0; i < totalIterations; i++)
                {
                    System.out.println("Peace");
                    try
                    {
                        Thread.sleep(50);
                    }
                    catch (InterruptedException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            } 
        };
        
        
        salam.start();
        peace.start();
    }

}
