package com.github.idnbso.hit.java.assignments.threads.momobobo;

import java.util.concurrent.Semaphore;

class RunnableObject implements Runnable
{
    Semaphore semaphore;
    String text;

    RunnableObject(Semaphore semaphore, String text)
    {
        this.semaphore = semaphore;
        this.text = text;
    }

    public void run()
    {
        try
        {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " has just acquired semaphore");
            for (int i = 0; i < 10; i++)
            {
                System.out.println(text);
                Thread.sleep(50);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println(Thread.currentThread().getName() + " is about to release semaphore");
            semaphore.release();
        }
    }
}