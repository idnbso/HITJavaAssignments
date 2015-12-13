package com.github.idnbso.hit.java.assignments.generics;

public class Media
{
    private String typeName;

    public Media(String typeName)
    {
        super();
        this.typeName = typeName;
    }

    public void open()
    {
        System.out.println("Openning Media File...");
    }
    
    @Override
    public String toString()
    {
        return "Media [typeName=" + typeName + "]";
    }
}
