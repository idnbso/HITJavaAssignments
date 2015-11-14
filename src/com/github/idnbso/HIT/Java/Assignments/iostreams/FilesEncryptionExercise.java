package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class FilesEncryptionExercise
{
    // expects: [command] [key] [inputFile] [outputFile]
    // where command is either encrypt or decrypt and key is integer of 0-9
    public static void main(String[] args)
    {
        FileOutputStream output = null;
        
        try
        {
            output = new FileOutputStream(args[3]);
            File file = new File(args[2]);
            int key = Integer.parseInt(args[1]);
            byte vec[] = null;
            vec = FileToBytes.convertFileToBytes(file);

            key *= (args[0].equalsIgnoreCase("encrypt") ? 1 : -1);
            for (int i = 0; i < vec.length; i++)
            {
                vec[i] += key;
            }
            
            output.write(vec);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (output != null)
            {
                try
                {
                    output.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
