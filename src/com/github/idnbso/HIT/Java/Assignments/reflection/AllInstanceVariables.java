package com.github.idnbso.hit.java.assignments.reflection;

import java.lang.reflect.*;
import java.util.*;

public class AllInstanceVariables
{
    public static void main(String args[])
    {
        try
        {
            Class classObj = Class.forName(args[0]);
            List<Field> list = new LinkedList<Field>();
            while (classObj != null)
            {
                Field[] fields = classObj.getDeclaredFields();
                for (int index = 0; index < fields.length; index++)
                {
                    if (!Modifier.isStatic(fields[index].getModifiers()))
                        list.add(fields[index]);
                }
                classObj = classObj.getSuperclass();
            }
            Iterator<Field> iterator = list.iterator();
            while (iterator.hasNext())
            {
                System.out.println(iterator.next().getName());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}