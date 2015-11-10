package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class FileLength
{
    public static void main(String[] args)
    {
        String filePath = args[0];
        File fileObject = new File(filePath);
        long fileSize = fileObject.length();
        System.out.println("The size of the file is " + fileSize + " bytes.");
    }
}