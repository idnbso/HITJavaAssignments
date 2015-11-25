package com.github.idnbso.hit.java.assignments.reflection;

import java.lang.reflect.*;
import java.util.*;

public class FieldValueSetting
{
    public static void main(String args[])
    {
     try
     {
         Rectangle rec = new Rectangle();
         Class classObj = rec.getClass();
         Field widthField = classObj.getDeclaredField("width");
         Field heightField = classObj.getDeclaredField("height");
         System.out.println("before... "+rec);
         widthField.setDouble(rec,2);
         heightField.setDouble(rec,8);
         System.out.println("after... "+rec);
     }
     catch (Throwable e)
     {
         e.printStackTrace();
     }
  }
}
