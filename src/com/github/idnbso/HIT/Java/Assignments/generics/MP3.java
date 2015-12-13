package com.github.idnbso.hit.java.assignments.generics;

public class MP3 extends Media
{

    public MP3(String typeName)
    {
        super(typeName);
    }
    
    public void listen()
    {
        super.open();
        System.out.println("Now Playing MP3 File...");
    }
}
