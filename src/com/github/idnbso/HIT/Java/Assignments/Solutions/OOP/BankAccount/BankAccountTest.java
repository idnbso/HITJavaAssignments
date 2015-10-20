package com.github.idnbso.hit.java.assignments.solutions.oop.bankaccount;

public class BankAccountTest
{

    public static void main(String[] args)
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