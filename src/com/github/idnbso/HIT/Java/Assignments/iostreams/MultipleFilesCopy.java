package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class MultipleFilesCopy
{
    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            System.out.println(
                    "java MultipleFilesCopy inpufFile outputFile1 outputFile2 outputFile3...");
        }
        else
        {
            FileInputStream inputFile = null;
            FileOutputStream outputFile = null;
            MultipleOutputStream multipleOutput = null;

            try
            {
                inputFile = new FileInputStream(args[0]);
                outputFile = new FileOutputStream(args[1]);
                multipleOutput = new MultipleOutputStream(outputFile);
                for (int i = 2; i < args.length; i++)
                {
                    multipleOutput.addOutputStream(new FileOutputStream(args[i]));
                }
                IOUtils.streamCopy(inputFile, multipleOutput);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                if (multipleOutput != null)
                {
                    try
                    {
                        multipleOutput.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                if (inputFile != null)
                {
                    try
                    {
                        inputFile.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}