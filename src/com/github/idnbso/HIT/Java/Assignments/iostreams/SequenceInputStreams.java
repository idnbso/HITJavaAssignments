package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;
import java.util.*;

public class SequenceInputStreams
{
    public static void main(String[] args)
    {

        Vector<InputStream> streams = new Vector<InputStream>();

        for (int i = 0; i < args.length; i++)
        {
            try
            {
                FileInputStream fin = new FileInputStream(args[i]);
                streams.addElement(fin);
            }
            catch (IOException e)
            {
                System.err.println(e);
            }
        }
        
        Enumeration<? extends InputStream> streamsEnumeration = streams.elements();
        SequenceInputStream sin = new SequenceInputStream(streamsEnumeration);

        try
        {
            IOUtils.streamCopy(sin, System.out);
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
        finally
        {
            if (sin != null)
            {
                try
                {
                    sin.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }

}