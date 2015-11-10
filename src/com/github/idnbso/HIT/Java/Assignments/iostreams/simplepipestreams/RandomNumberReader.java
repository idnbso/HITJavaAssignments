package com.github.idnbso.hit.java.assignments.iostreams.simplepipestreams;

import java.io.*;

public class RandomNumberReader extends Thread
{
    private DataInputStream dis;

    public RandomNumberReader(InputStream input)
    {
        dis = new DataInputStream(input);
    }

    public void run()
    {
        try
        {
            while (true)
            {
                System.out.println(dis.readInt());
                try
                {
                    Thread.sleep(800);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e)
        {
            // end of stream
        }
        finally
        {
            if (dis != null)
            {
                try
                {
                    dis.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}