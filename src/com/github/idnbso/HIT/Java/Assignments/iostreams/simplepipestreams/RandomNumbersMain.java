package com.github.idnbso.hit.java.assignments.iostreams.simplepipestreams;

import java.io.*;

public class RandomNumbersMain
{
    public static void main(String[] args)
    {
        PipedOutputStream pipeOutput = null;
        PipedInputStream pipeInput = null;
        RandomNumberGenerator generator = null;
        RandomNumberReader reader = null;
        int numOfNumbers = 20;
        try
        {
            numOfNumbers = Integer.parseInt(args[0]);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            pipeOutput = new PipedOutputStream();
            pipeInput = new PipedInputStream(pipeOutput);
            generator = new RandomNumberGenerator(pipeOutput, numOfNumbers);
            reader = new RandomNumberReader(pipeInput);
            generator.start();
            reader.start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}