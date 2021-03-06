package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class ReadPersonSerialization
{
    public static void main(String[] args)
    {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try
        {
            String fileName = "files/" + args[0];
            fileName = fileName.concat(".person");
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            System.out.println(ois.readObject());
        }
        catch (FileNotFoundException e)
        {
            System.out.println("file not found");
        }
        catch (IOException e)
        {
            System.out.println("problem reading data");
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            System.out.println("class is missing");
        }

    }
}
