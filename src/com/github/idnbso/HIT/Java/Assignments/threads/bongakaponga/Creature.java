package com.github.idnbso.hit.java.assignments.threads.bongakaponga;

public abstract class Creature implements Runnable
{
    protected String name;
    protected final int totalPrintIterations;

    public Creature(String name, int totalPrintIterations)
    {
        this.totalPrintIterations = totalPrintIterations;
        this.name = name;
    }

    public final int getTotalPrintIterations()
    {
        return totalPrintIterations;
    }

    public final String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return "Creature [name=" + name + "]";
    }

    @Override
    public void run()
    {
        for (int i = 0; i < totalPrintIterations; i++)
        {
            System.out.println(name);
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
}
