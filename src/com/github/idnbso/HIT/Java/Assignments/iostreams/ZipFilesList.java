package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;
import java.util.*;
import java.util.zip.*;

public class ZipFilesList
{
    public static void main(String[] args)
    {

        for (int i = 0; i < args.length; i++)
        {
            try
            {
                ZipFile zf = new ZipFile(args[i]);
                Enumeration<? extends ZipEntry> e = zf.entries();
                while (e.hasMoreElements())
                {
                    System.out.println(e.nextElement());
                }
                
                System.out.println("end of zip file content listing...");
                try
                {
                    zf.close();
                }
                catch (IOException e2)
                {
                    e2.printStackTrace();
                }
                
            }
            catch (IOException e)
            {
                System.err.println(e);
            }
        }
    }
}