package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class ArrayOfASCIIChars
{
    public static void main(String[] args)
    {
        byte[] b = new byte[(127-32)*2 + 1];
        int index = 0;
        for (int i = 32; i < 127; i++)
        {
            b[index++] = (byte) i;
            if ((i - 2) % 10 == 0)
                b[index++] = (byte) '\n';
            else
                b[index++] = (byte) '\t';
        }
        b[index++] = (byte) '\n';
        try
        {
            System.out.write(b);
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
    }
}