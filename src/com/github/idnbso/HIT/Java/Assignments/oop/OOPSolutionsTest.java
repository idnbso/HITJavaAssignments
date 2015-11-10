package com.github.idnbso.hit.java.assignments.oop;

import com.github.idnbso.hit.java.assignments.oop.bankaccount.*;
import com.github.idnbso.hit.java.assignments.oop.parallellines.*;

public class OOPSolutionsTest
{

    public static void main(String[] args)
    {
        testExercise("BankAccount");
        testExercise("ParallelLines");
    }

    private static void testExercise(String iExerciseName)
    {
        System.out.println("### Starting Test of Exercise: " + iExerciseName + " ###");
        System.out.print(System.lineSeparator());
        
        switch (iExerciseName)
        {
            case "BankAccount":
                BankAccountTest.main(null);
                break;
            case "ParallelLines":
                LinesTest.main(null);
                break;
            default:
                System.out.println("# ERROR: There is no exercise with such name.");
                break;
        }
        System.out.print(System.lineSeparator());
        System.out.println("### Finished Test of Exercise: " + iExerciseName + " ###");
    }

}
