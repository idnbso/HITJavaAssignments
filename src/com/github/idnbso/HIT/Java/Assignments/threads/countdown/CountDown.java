package com.github.idnbso.hit.java.assignments.threads.countdown;

import java.util.concurrent.CountDownLatch;

public class CountDown
{
    public static void main(String args[])
    {
        int total = 5;
        CountDownLatch counter = new CountDownLatch(total);
        PrintNumbers obA = new PrintNumbers(counter);
        PrintNumbers obB = new PrintNumbers(counter);
        PrintNumbers obC = new PrintNumbers(counter);
        obA.setDaemon(true);
        obB.setDaemon(true);
        obC.setDaemon(true);
        obA.start();
        obB.start();
        obC.start();
        try
        {
            counter.await();
            System.out.println("Done. " + total + " random numbers have just been generated.");
            System.out.println(obA.getName() + " printed " + obA.getTotalPrints() + " times.");
            System.out.println(obB.getName() + " printed " + obB.getTotalPrints() + " times.");
            System.out.println(obC.getName() + " printed " + obC.getTotalPrints() + " times.");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }
}