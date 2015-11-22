package com.github.idnbso.hit.java.assignments.threads.stringsexchaning;

import java.util.concurrent.Exchanger;

class StringsGenerator implements Runnable
{
    Exchanger<String> exchanger;
    String vec[];

    StringsGenerator(Exchanger<String> exchanger, String vec[])
    {
        this.exchanger = exchanger;
        this.vec = vec;
    }

    public void run()
    {
        for (int i = 0; i < vec.length; i++)
        {
            try
            {
                String str = exchanger.exchange(vec[i]);
                System.out.println(Thread.currentThread().getName() + "  " + " \treceived=" + str
                        + "  " + " \tsent=" + vec[i]);
            }
            catch (InterruptedException e)
            {
                System.out.println(e);
            }
        }
    }
}