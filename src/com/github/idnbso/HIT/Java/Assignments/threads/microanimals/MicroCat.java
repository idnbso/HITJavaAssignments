package com.github.idnbso.hit.java.assignments.threads.microanimals;

public class MicroCat implements Runnable
{
    private int totalIterations;
    private final String noise = "Miau Miau";
    public MicroCat(int totalIterations)
    {
        super();
        setTotalIterations(totalIterations);
    }

    @Override
    public void run()
    {
        for (int i = 0; i < totalIterations; i++)
        {
            System.out.println(noise);
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

    public int getTotalIterations()
    {
        return totalIterations;
    }

    public void setTotalIterations(int totalIterations)
    {
        this.totalIterations = totalIterations;
    }

}
