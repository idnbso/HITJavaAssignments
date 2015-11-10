package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class FileExist
{
    public static void main(String[] args)
    {
        String filePath = args[0];
        File fileObject = new File(filePath);
        boolean exist = fileObject.exists();
        if (exist)
        {
            System.out.println("The file " + filePath + " exists.");
        }
        else
        {
            System.out.println("The file " + filePath + " doesn't exist.");
        }
    }
}