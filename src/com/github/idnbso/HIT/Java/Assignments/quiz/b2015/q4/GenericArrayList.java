package com.github.idnbso.hit.java.assignments.quiz.b2015.q4;

import java.util.*;

public class GenericArrayList
{

    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
        list.add("I liked Java");
        String s = (String) list.get(0);
        System.out.println(s);
    }

}
