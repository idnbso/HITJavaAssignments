package com.github.idnbso.hit.java.assignments.generics;

import java.util.Vector;

public class GenericsDemo
{

    public static void main(String[] args)
    {
        Vector<? extends Object> vec1 = new Vector<String>();
        Vector<Object> vec2 = (Vector<Object>) vec1;
    }

}
