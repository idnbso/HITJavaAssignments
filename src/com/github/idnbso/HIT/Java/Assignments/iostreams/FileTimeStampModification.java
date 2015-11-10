package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class FileTimeStampModification
{
    public static void main(String[] args)
    {
        String filePath = args[0];
        File fileObject = new File(filePath);
        long newTimeStamp = System.currentTimeMillis();
        boolean changed = fileObject.setLastModified(newTimeStamp);
        if (changed)
        {
            System.out.println("The time stamp was successfully changed.");
        }
        else
        {
            System.out.println("The time stamp was not changed.");
        }
    }
}