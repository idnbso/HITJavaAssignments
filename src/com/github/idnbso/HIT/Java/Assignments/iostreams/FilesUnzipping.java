package com.github.idnbso.hit.java.assignments.iostreams;

import java.util.*;
import java.util.zip.*;
import java.io.*;

public class FilesUnzipping
{
    public static void main(String[] args)
    {

        for (int i = 0; i < args.length; i++)
        {
            InputStream in = null;
            FileOutputStream fout = null;
            try
            {
                ZipFile zf = new ZipFile(args[i]);
                Enumeration<? extends ZipEntry> e = zf.entries();
                while (e.hasMoreElements())
                {
                    ZipEntry ze = e.nextElement();
                    System.out.println(ze.getName() + " unzipping...");
                    try
                    {

                        fout = new FileOutputStream("files/FilesUnzipping/" + ze);
                        in = zf.getInputStream(ze);
                        IOUtils.streamCopy(in, fout);

                    }
                    catch (IOException e1)
                    {
                        e1.printStackTrace();
                    }
                    finally
                    {
                        if (in != null)
                        {
                            try
                            {
                                in.close();
                            }
                            catch (IOException e2)
                            {
                                e2.printStackTrace();
                            }
                        }
                        if (fout != null)
                        {
                            try
                            {
                                fout.close();
                            }
                            catch (IOException e3)
                            {
                                e3.printStackTrace();
                            }
                        }
                    }
                }

                System.out.println("finished unzipping file " + args[i]);
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
                e.printStackTrace();
            }
        }

    }

}