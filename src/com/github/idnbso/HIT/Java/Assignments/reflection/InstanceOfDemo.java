package com.github.idnbso.hit.java.assignments.reflection;

import java.lang.reflect.*;
import java.util.*;
import com.github.idnbso.hit.java.assignments.inheritance.carssorting.*;

public class InstanceOfDemo
{
    public static void main(String args[])
    {
        try
        {
            SportCar sc = new RacingCar();
            if (sc instanceof RacingCar)
            {
                System.out.println("The object is of the RacingCar type");
            }
            String packageInfo = "com.github.idnbso.hit.java.assignments.inheritance.carssorting.";
            Class classObj = Class.forName(packageInfo + "RacingCar");
            if (classObj.isInstance(sc))
            {
                System.out.println("The object is of the RacingCar type");
            }
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
    }
}