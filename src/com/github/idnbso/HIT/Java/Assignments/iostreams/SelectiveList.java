package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class SelectiveList
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
            File[] children = file.listFiles(new JPGFilter());
            for (int i = 0; i < children.length; i++)
            {
                System.out.println(children[i].getName());
            }
        }
    }

    static class JPGFilter implements FileFilter
    {
        public boolean accept(File file)
        {
            return file.getName().endsWith(".jpg") || file.getName().endsWith(".jpeg");
        }
    }
}