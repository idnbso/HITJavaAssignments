package com.github.idnbso.hit.java.assignments.threads.countdown;

import java.util.concurrent.CountDownLatch;

public class CountDown
{
    public static void main(String args[])
    {
        CountDownLatch counter = new CountDownLatch(30);
        PrintNumbers obA = new PrintNumbers(counter);
        PrintNumbers obB = new PrintNumbers(counter);
        PrintNumbers obC = new PrintNumbers(counter);
        obA.start();
        obB.start();
        obC.start();
        try
        {
            counter.await();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Done. 30 random numbers have just been generated.");
    }
}