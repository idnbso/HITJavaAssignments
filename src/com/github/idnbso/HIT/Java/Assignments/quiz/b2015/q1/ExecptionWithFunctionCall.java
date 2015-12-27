package com.github.idnbso.hit.java.assignments.quiz.b2015.q1;

import java.io.*;

public class ExecptionWithFunctionCall
{

    public static void main(String[] args) throws IOException
    {
        FileInputStream in = null;
        FileOutputStream out = null;
        try
        {
            in = new FileInputStream("input.txt");
            out = new FileOutputStream("output.txt"); // the missing code
            int c;
            while ((c = in.read()) != -1)
            {
                out.write(c);
            }
        }
        catch (IOException e)
        {
            functionB();
            if (in != null)
            {
                in.close();
            }
        }
    }

    private static void functionB()
    {
        // TODO Auto-generated method stub

    }
}
