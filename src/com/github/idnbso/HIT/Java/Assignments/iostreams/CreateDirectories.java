package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class CreateDirectories
{
    public static void main(String[] args)
    {
        File file = new File(args[0]);
        boolean succeeded = file.mkdirs();
        if (succeeded)
        {
            System.out.println("The directories were successfully created");
        }
        else
        {
            System.out.println("The directories were not created");
        }
    }
}