package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class ReadTextualFile
{
    public static void main(String[] args)
    {
        FileReader fr = null;
        BufferedReader in = null;
        try
        {
            fr = new FileReader(args[0]);
            in = new BufferedReader(fr);
            String str = in.readLine();
            while (str != null)
            {
                System.out.println("==> " + str);
                str = in.readLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (in != null)
            {
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (fr != null)
            {
                try
                {
                    fr.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}