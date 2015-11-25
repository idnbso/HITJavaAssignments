package com.github.idnbso.hit.java.assignments.reflection;

import java.lang.reflect.*;
import java.util.*;

public class MethodsList
{
    public static void main(String args[])
    {
        try
        {
            Class classObj = Class.forName("java.lang.Math");
            Method[] methods = classObj.getDeclaredMethods();
            for (int index = 0; index < methods.length; index++)
            {
                System.out.println("method #" + index + " " + methods[index].getName());
            }
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
    }
}