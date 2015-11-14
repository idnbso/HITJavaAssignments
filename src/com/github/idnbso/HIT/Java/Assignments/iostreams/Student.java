package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class Student implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String privateName;
    private String familyName;
    private long id;
    private long telephone;
    private double markAverage;

    public Student(long id, String privateName, String familyName, long telephone,
                    double markAverage)
    {
        super();
        setId(id);
        setPrivateName(privateName);
        setFamilyName(familyName);
        setTelephone(telephone);
        setMarkAverage(markAverage);
    }

    public String getPrivateName()
    {
        return privateName;
    }

    public String getFamilyName()
    {
        return familyName;
    }

    public long getId()
    {
        return id;
    }

    public long getTelephone()
    {
        return telephone;
    }

    public void setPrivateName(String privateName)
    {
        this.privateName = privateName;
    }

    public void setFamilyName(String familyName)
    {
        this.familyName = familyName;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public void setTelephone(long telephone)
    {
        this.telephone = telephone;
    }

    public double getMarkAverage()
    {
        return markAverage;
    }

    public void setMarkAverage(double markAverage)
    {
        this.markAverage = markAverage;
    }

    @Override
    public String toString()
    {
        return "Student [id=" + id + ", privateName=" + privateName + ", familyName=" + familyName
                + ", telephone=" + telephone + ", markAverage=" + markAverage + "]";
    }
}
