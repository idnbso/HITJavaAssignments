package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class FilesReversedOrderCopy
{
    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.err.println("You should pass two filenames");
        }
        else
        {
            try
            {
                copy(args[0], args[1]);
            }
            catch (IOException e)
            {
                System.err.println(e);
            }
        }
    }

    public static void copy(String inputFile, String outputFile) throws IOException
    {

        FileInputStream input = null;
        FileOutputStream output = null;

        try
        {
            input = new FileInputStream(inputFile);
            output = new FileOutputStream(outputFile);
            IOUtils.streamReverseOrderCopy(input, output);
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
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
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