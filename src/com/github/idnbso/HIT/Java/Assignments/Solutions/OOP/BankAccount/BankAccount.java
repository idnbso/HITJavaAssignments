package com.github.idnbso.HIT.Java.Assignments.Solutions.OOP.BankAccount;

public class BankAccount
{
    private long id;
    private double balance;

    public BankAccount()
    {
        id = 0L;
        balance = 0.0d;
    }

    public BankAccount(long id, double balance)
    {
        setId(id);
        setBalance(balance);
    }

    public long getId()
    {
        return id;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public void withdraw(double amount)
    {
        balance -= amount;
    }

    public void deposit(double amount)
    {
        balance += amount;
    }
}
