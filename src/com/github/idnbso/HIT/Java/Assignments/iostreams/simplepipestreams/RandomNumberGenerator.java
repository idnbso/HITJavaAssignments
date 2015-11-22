package com.github.idnbso.hit.java.assignments.iostreams.simplepipestreams;

import java.io.*;

public class RandomNumberGenerator extends Thread
{
    private DataOutputStream output;
    private int numOfNumbers;

    public RandomNumberGenerator(OutputStream out, int num) throws IOException
    {
        output = new DataOutputStream(out);
        numOfNumbers = num;
    }

    public RandomNumberGenerator(OutputStream out)
    {
        output = new DataOutputStream(out);
        numOfNumbers = 20;
    }

    @Override
    public void run()
    {
        try
        {
            for (int i = 0; i < numOfNumbers; i++)
            {
                int temp = Math.abs((int) (100 * Math.random()));
                output.writeInt(temp);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (output != null)
            {
                try
                {
                    output.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

}