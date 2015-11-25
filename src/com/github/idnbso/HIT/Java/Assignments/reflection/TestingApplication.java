package com.github.idnbso.hit.java.assignments.reflection;

import java.lang.reflect.*;
import java.util.*;

public class TestingApplication
{

    public static void main(String[] args)
    {
        try
        {
            Class<?> classObj = Class.forName(args[0]);
            Method[] methods = classObj.getMethods();
            ArrayList<Method> methodsList = new ArrayList<Method>();
            for (Method method : methods)
            {
                if (method.getName().substring(0, "test".length()).equals("test"))
                {
                    methodsList.add(method);
                }
            }
            
            Object ob = classObj.newInstance();
            for (Method method : methodsList)
            {
                method.invoke(ob, null);
            }
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
