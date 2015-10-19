package com.github.idnbso.HIT.Java.Assignments.Solutions.OOP;

import com.github.idnbso.HIT.Java.Assignments.Solutions.OOP.BankAccount.BankAccount;
import com.github.idnbso.HIT.Java.Assignments.Solutions.OOP.ParallelLines.LinesTest;

public class TestOOPSolutions
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
                testBankAccount();
                break;
            case "ParallelLines":
                LinesTest.main(null);
                break;
            default:
                System.out.println("# ERROR: There is no Exercise with such name.");
                break;
        }
        System.out.print(System.lineSeparator());
        System.out.println("### Finished Test of Exercise: " + iExerciseName + " ###");
    }

    private static void testBankAccount()
    {
        BankAccount myBankAccount = new BankAccount(123_456_789, 0);
        System.out.println("# BankAccount myBankAccount was created.");
        System.out.println("myBankAccount Id number is: " + myBankAccount.getId());
        System.out.println("myBankAccount current balance is: " + myBankAccount.getBalance() + "$");

        System.out.println("# Depositing 100.5$ to myBankAccount.");
        myBankAccount.deposit(100.5);
        System.out.println("myBankAccount current balance is: " + myBankAccount.getBalance() + "$");

        System.out.println("# Withdrawing 10.2$ from myBankAccount.");
        myBankAccount.withdraw(10.2);
        System.out.println("myBankAccount current balance is: " + myBankAccount.getBalance() + "$");
    }

}
