package com.github.idnbso.hit.java.assignments.threads.bankaccount;

import com.github.idnbso.hit.java.assignments.threads.bankaccount.BankClient.TransactionChoice;

public class AccountDemo
{

    public static void main(String[] args)
    {
        Account myBankAccount = new Account(123_456_789, 10);
        BankClient clientWithdraw = new BankClient(myBankAccount, TransactionChoice.WITHDRAW);
        BankClient clientDeposit = new BankClient(myBankAccount, TransactionChoice.DEPOSIT);
        
        System.out.println("# BankAccount myBankAccount was created.");
        System.out.println("myBankAccount Id number is: " + myBankAccount.getId());
        System.out.println("myBankAccount current balance is: " + myBankAccount.getBalance() + "$");
        
        
        clientWithdraw.start();
        clientDeposit.start();
    }
}