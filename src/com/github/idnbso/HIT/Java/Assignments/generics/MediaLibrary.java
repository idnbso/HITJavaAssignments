package com.github.idnbso.hit.java.assignments.generics;

import java.util.*;

public class MediaLibrary
{
    ArrayList<? extends Media> library;

    public MediaLibrary(ArrayList<? extends Media> library)
    {
        super();
        setLibrary(library);
    }

    public final ArrayList<? extends Media> getLibrary()
    {
        return library;
    }

    public final void setLibrary(ArrayList<? extends Media> library)
    {
        this.library = library;
    }
    
        
}
