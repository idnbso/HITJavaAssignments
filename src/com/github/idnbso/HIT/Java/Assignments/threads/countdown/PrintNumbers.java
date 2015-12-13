package com.github.idnbso.hit.java.assignments.threads.countdown;

import java.util.concurrent.CountDownLatch;

class PrintNumbers extends Thread
{
    CountDownLatch latch;
    private int totalPrints = 0;
    
    PrintNumbers(CountDownLatch c)
    {
        latch = c;
    }

    public final int getTotalPrints()
    {
        return totalPrints;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            if (latch.getCount() != 0) 
            {
                System.out.println(
                        Thread.currentThread().getName() + " .. " + (int) (100 * Math.random()));
                totalPrints++;
                latch.countDown();
            }
        }
    }
}