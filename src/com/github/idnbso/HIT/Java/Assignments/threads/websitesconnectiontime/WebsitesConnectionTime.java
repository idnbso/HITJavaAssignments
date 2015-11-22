package com.github.idnbso.hit.java.assignments.threads.websitesconnectiontime;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class WebsitesConnectionTime
{
    CyclicBarrier barrier;

    List<ConnectionTime> vec = new Vector<ConnectionTime>();

    public static long calculateConnectionTime(String website)
    {
        long start = System.currentTimeMillis();
        try
        {
            new URL(website).openConnection().connect();
        }
        catch (UnknownHostException e)
        {
            System.out.println(e.getMessage() + " is probably offline.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return -1;
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public void showResults()
    {
        Collections.sort(vec);
        for (ConnectionTime ob : vec)
        {
            System.out.printf("%s : %d\n", ob.website, ob.time);
        }
    }

    public void start(String[] sites)
    {
        Runnable showResultsRunnable = new Runnable()
        {
            public void run()
            {
                System.out.println();
                showResults();
                vec.clear();
            }
        };

        barrier = new CyclicBarrier(sites.length, showResultsRunnable);

        for (final String website : sites)
        {
            Thread thread = new Thread()
            {
                public void run()
                {
                    long time = calculateConnectionTime(website);
                    vec.add(new ConnectionTime(time, website));
                    try
                    {
                        barrier.await();
                    }
                    catch (BrokenBarrierException e)
                    {
                        return;
                    }
                    catch (InterruptedException e)
                    {
                        return;
                    }
                }
            };
            thread.start();
        }
    }

    public static void main(String[] args) throws IOException
    {
        WebsitesConnectionTime ob = new WebsitesConnectionTime();
        String[] sites = new String[] { "http://www.jacado.com", "http://www.abelski.com",
                "http://www.gagamo.com", "http://www.movaco.com", "http://www.zompix.com",
                "http://www.gagamo.com", "http://www.zindell.com", "http://www.mobizex.com",
                "http://www.comzex.com", "http://www.zindego.com", "http://www.zuntel.com",
                "http://www.xperato.com" };
        ob.start(sites);
    }
}