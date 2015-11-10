package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;
import java.util.zip.*;

public class SimpleFilesDeflator
{
    public static void main(String[] args)
    {

        Deflater deflater = new Deflater();
        byte[] inputVec = new byte[1024];
        byte[] outputVec = new byte[1024];

        for (int i = 0; i < args.length; i++)
        {
            FileInputStream fileInput = null;
            FileOutputStream fileOutput = null;

            try
            {
                fileInput = new FileInputStream(args[i]);
                fileOutput = new FileOutputStream(args[i] + ".dflator");

                while (true)
                {
                    int numRead = fileInput.read();
                    if (numRead != -1)
                    {
                        deflater.setInput(inputVec, 0, numRead);
                        while (!deflater.needsInput())
                        {
                            int numCompressedBytes = deflater.deflate(outputVec, 0,
                                    outputVec.length);
                            if (numCompressedBytes > 0)
                            {
                                fileOutput.write(outputVec, 0, numCompressedBytes);
                            }
                        }
                    }
                    else
                    {
                        deflater.finish();
                        while (!deflater.finished())
                        {
                            int numCompressedBytes = deflater.deflate(outputVec, 0,
                                    outputVec.length);
                            if (numCompressedBytes > 0)
                            {
                                fileOutput.write(outputVec, 0, numCompressedBytes);
                            }
                        }
                        break;
                    }
                }
                fileOutput.flush();
                deflater.reset();
            }
            catch (IOException e)
            {
                System.err.println(e);
            }
            finally
            {
                if (fileInput != null)
                {
                    try
                    {
                        fileInput.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            if (fileOutput != null)
            {
                try
                {
                    fileOutput.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }

}