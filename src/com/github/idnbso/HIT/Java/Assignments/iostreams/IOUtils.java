package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class IOUtils
{
    public static void streamCopy(InputStream in, OutputStream out) throws IOException
    {
        synchronized (out)
        {
            synchronized (in)
            {
                byte vec[] = new byte[256];
                int numOfBytes = in.read(vec);
                while (numOfBytes != -1)
                {
                    out.write(vec, 0, numOfBytes);
                    numOfBytes = in.read(vec);
                }
            }
        }
    }

    public static void streamReverseOrderCopy(InputStream in, OutputStream out) throws IOException
    {
        synchronized (out)
        {
            synchronized (in)
            {
                int size = (int) in.available();
                byte vec[] = new byte[size];
                int index = 0;
                int numOfBytes = in.read();
                while (numOfBytes != -1)
                {
                    vec[index++] = (byte) numOfBytes;
                    numOfBytes = in.read();
                }

                for (int i = vec.length - 1; i >= 0; --i)
                {
                    out.write(vec[i]);
                }
            }
        }
    }
}
