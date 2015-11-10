package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class SimpleList
{
    public static void main(String[] args)
    {
        list(new File(args[0]));
    }

    public static void list(File file)
    {
        if (file.isFile())
        {
            System.out.println("You should pass a directory name... not a file name.");
        }
        else if (file.isDirectory())
        {
            String[] children = file.list();
            for (int i = 0; i < children.length; i++)
            {
                System.out.println("Directory child " + (i+1) + " name is: " + children[i]);
            }
        }
    }
}