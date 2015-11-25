package com.github.idnbso.hit.java.assignments.reflection;

import java.lang.reflect.*;

public class ClassesEquality
{
    public static void main(String args[])
    {
        Class classObj1;
        Class classObj2;
        try
        {
            classObj1 = Class.forName(args[0]);
            classObj2 = Class.forName(args[1]);
            
            if (isEquals(classObj1, classObj2))
            {
                System.out.println("The objects are equal.");
            }
            else
            {
                System.out.println("The objects are not equal.");
            }
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }

    public static boolean isEquals(Class<?> object1, Class<?> object2)
    {
        boolean isEquals = true;

        Field[] fields1 = object1.getDeclaredFields();
        Method[] methods1 = object1.getDeclaredMethods();
        Field[] fields2 = object2.getDeclaredFields();
        Method[] methods2 = object2.getDeclaredMethods();

        // check fields
        for (Field field1 : fields1)
        {
            boolean isFoundSimilarField = false;
            for (Field field2 : fields2)
            {
                if (field1.getName().equals(field2.getName())
                        && field1.getType().equals(field2.getType())
                        && (field1.getModifiers() == field2.getModifiers()))
                {
                    isFoundSimilarField = true;
                    break;
                }
            }

            if (!isFoundSimilarField)
            {
                isEquals = false;
                break;
            }
        }

        if (isEquals)
        {
            // check methods
            for (Method method1 : methods1)
            {
                boolean isFoundSimilarMethod = false;

                for (Method method2 : methods2)
                {
                    if (method1.getName().equals(method2.getName())
                            && method1.getParameterCount() == method2.getParameterCount()
                            && method1.getReturnType().equals(method2.getReturnType())
                            && method1.getModifiers() == method2.getModifiers())
                    {
                        if (method1.getParameterCount() > 0)
                        {
                            Class<?>[] method1Types = method1.getParameterTypes();
                            Class<?>[] method2Types = method2.getParameterTypes();
                            
                            for (Class<?> type1: method1Types)
                            {
                                boolean isFoundSimilarMethodType = true;
                                for (Class<?> type2: method2Types)
                                {
                                    if (!type1.getName().equals(type2.getName()))
                                    {
                                        isFoundSimilarMethodType = false;

                                    }
                                    else
                                    {
                                        isFoundSimilarMethodType = true;
                                        break;
                                    }
                                }
                                
                                if (!isFoundSimilarMethodType)
                                {
                                    isFoundSimilarMethod = false;
                                }
                                else
                                {
                                    isFoundSimilarMethod = true;
                                    break;
                                }
                            }
                        }
                        else
                        {
                            isFoundSimilarMethod = true;
                        }
                        
                        if (isFoundSimilarMethod)
                            break;
                        
                    }
                }

                if (!isFoundSimilarMethod)
                {
                    isEquals = false;
                    break;
                }
            }
        }

        return isEquals;
    }

}
