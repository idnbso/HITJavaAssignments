package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class Person implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String privateName;
    private String familyName;
    private long id;
    private long telephone;

    public Person(long id, String privateName, String familyName, long telephone)
    {
        super();
        setId(id);
        setPrivateName(privateName);
        setFamilyName(familyName);
        setTelephone(telephone);
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

    @Override
    public String toString()
    {
        return "Person [id=" + id + ", privateName=" + privateName + ", familyName=" + familyName
                + ", telephone=" + telephone + "]";
    }

}
