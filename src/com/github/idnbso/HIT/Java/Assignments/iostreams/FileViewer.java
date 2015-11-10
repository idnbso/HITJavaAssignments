package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class FileViewer
{

    public static void main(String[] args)
    {

        if (args.length < 1)
        {
            System.err.println("You should pass a file name");
        }
        else
        {
            dumpFile(args[0]);
        }
    }

    public static void dumpFile(String filename)
    {
        FileInputStream fin = null;
        byte[] buffer = new byte[20];
        int numOfBytes = 0;

        try
        {
            fin = new FileInputStream(filename);
            boolean end = false;
            while (!end)
            {
                numOfBytes = fin.read(buffer); 
                while (numOfBytes < buffer.length)
                {
                    int r = fin.read(buffer, numOfBytes, buffer.length - numOfBytes);
                    if (r == -1)
                    {
                        end = true;
                        break;
                    }
                    numOfBytes += r;
                }
                for (int i = 0; i < numOfBytes; i++)
                {
                    int hex = buffer[i];
                    if (hex < 0)
                        hex = 256 + hex;
                    if (hex >= 16)
                        System.out.print(Integer.toHexString(hex) + " ");
                    else
                        System.out.print("0" + Integer.toHexString(hex) + " ");
                }
                System.out.println();
            }
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
        finally
        {
            if (fin != null)
            {
                try
                {
                    fin.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}