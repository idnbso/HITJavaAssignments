package com.github.idnbso.hit.java.assignments.iostreams;

public class CurrentDirectory
{
    public static void main(String[] args)
    {
        // prints the name of the system property
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("The current directory is " + currentDirectory);
    }
}