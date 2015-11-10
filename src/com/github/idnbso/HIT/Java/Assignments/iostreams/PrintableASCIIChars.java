package com.github.idnbso.hit.java.assignments.iostreams;

public class PrintableASCIIChars
{
    public static void main(String[] args)
    {
        for (int i = 32; i < 127; i++)
        {
            System.out.write(i);
            if (i % 7 == 0)
                System.out.write('\n');
            else
                System.out.write('\t');
        }
        System.out.write('\n');

    }
}