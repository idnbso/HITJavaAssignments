package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class  DirectoryRecursiveDelete
{
    public static void main(String[] args)
    {
        if (deleteDir(new File(args[0])))
        {
            System.out.println("The directory was successfully deleted.");
        }
        else
        {
            System.out.println("The directory wasn't deleted");
        }
    }

    public static boolean deleteDir(File file)
    {
        if (file.isDirectory())
        {
            String[] children = file.list();
            for (int i = 0; i < children.length; i++)
            {
                boolean success = deleteDir(new File(file, children[i]));
                if (!success)
                {
                    return false;
                }
            }
        }
        return file.delete();
    }
}