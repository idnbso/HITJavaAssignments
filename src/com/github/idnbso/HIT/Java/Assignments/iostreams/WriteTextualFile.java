package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class WriteTextualFile
{
    // args input: [file output] [string to write] [append/overwrite]
    public static void main(String[] args)
    {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try
        {
            final boolean isAppendToTheEnd = true;
            if (args[2] == "append")
            {
                fw = new FileWriter(args[0], isAppendToTheEnd); 
            }
            else
            {
                fw = new FileWriter(args[0]); 
            }
            
            bw = new BufferedWriter(fw);
            bw.write(args[1]);
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