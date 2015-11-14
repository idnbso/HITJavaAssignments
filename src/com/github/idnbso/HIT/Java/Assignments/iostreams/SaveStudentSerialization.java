package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class SaveStudentSerialization
{
    public static void main(String[] args)
    {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try
        {
            long id = Integer.parseInt(args[0]);
            String privateName = args[1];
            String familyName = args[2];
            long telephone = Integer.parseInt(args[3]);
            double markAverage = Double.parseDouble(args[4]);
            
            // instantiate the new object of class Person
            Student studentObject = new Student(id, privateName, familyName, telephone, markAverage);
            
            // make a new file with its name as the student's id number,
            // and save the object to the new file
            String newFileName = new String("files/");
            newFileName = newFileName.concat(String.valueOf(id));
            newFileName = newFileName.concat(".student");
            fos = new FileOutputStream(newFileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(studentObject);

        }
        catch (NumberFormatException e1)
        {
            e1.printStackTrace();
        }
        catch (IOException e2)
        {
            e2.printStackTrace();
        }
        finally
        {
            if (oos != null)
            {
                try
                {
                    oos.close();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (fos != null)
            {

                try
                {
                    fos.close();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    }
}
