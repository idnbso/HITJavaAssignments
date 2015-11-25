package com.github.idnbso.hit.java.assignments.reflection;

public class UnknownClassInstantiation
{

    public static void main(String[] args)
    {
        try
        {
            Class<?> classObj = Class.forName(args[0]);
            Object ob = classObj.newInstance();
            System.out.println(ob.toString());
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
