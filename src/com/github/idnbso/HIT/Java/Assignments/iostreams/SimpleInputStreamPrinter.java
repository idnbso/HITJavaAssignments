package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class SimpleInputStreamPrinter
{
    InputStream input;

    public static void main(String[] args)
    {
        SimpleInputStreamPrinter demo = new SimpleInputStreamPrinter(System.in);
        demo.start();
    }

    public SimpleInputStreamPrinter(InputStream input)
    {
        this.input = input;
    }

    public void start()
    {
        try
        {
            int data = input.read();
            while (data != '\n')
            {
                System.out.println((char) data);
                data = input.read();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (input != null)
            {
                try
                {
                    input.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}