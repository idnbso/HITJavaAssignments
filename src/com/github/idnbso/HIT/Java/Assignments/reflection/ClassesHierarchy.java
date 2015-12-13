package com.github.idnbso.hit.java.assignments.reflection;

public class ClassesHierarchy
{

    public static void main(String[] args) throws ClassNotFoundException
    {
        Class<?> classObj = Class.forName(args[0]);
        printSuperClass(classObj);
    }

    private static void printSuperClass(Class<?> classObj)
    {
        Class<?> classObjSuper = classObj.getSuperclass();
        if (classObjSuper != null)
        {
            printSuperClass(classObjSuper);
        }
        System.out.println(classObj.getName());
    }
    
}
