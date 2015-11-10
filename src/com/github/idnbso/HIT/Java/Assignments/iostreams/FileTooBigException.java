package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class FileTooBigException extends IOException
{
    public final static long serialVersionUID = 1;

    public FileTooBigException()
    {
    }

    public FileTooBigException(String arg0)
    {
        super(arg0);
    }

    public FileTooBigException(Throwable arg0)
    {
        super(arg0);
    }

    public FileTooBigException(String arg0, Throwable arg1)
    {
        super(arg0, arg1);
    }
}