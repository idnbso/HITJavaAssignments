package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class TextualFileAppend
{
    public static void main(String[] args)
    {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try
        {
            fw = new FileWriter(args[0], true);
            bw = new BufferedWriter(fw);
            bw.write(System.lineSeparator() + args[1]);
            bw.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (fw != null)
            {
                try
                {
                    fw.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (bw != null)
            {
                try
                {
                    bw.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }
}