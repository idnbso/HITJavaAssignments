package com.github.idnbso.hit.java.assignments.solutions.oop.bankaccount;

public class BankAccount
{
    private long id;
    private double balance;

    public BankAccount()
    {
        this(0L, 0.0d);
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

    public void withdraw(double amount)
    {
        setBalance(balance - amount);
    }

    public void deposit(double amount)
    {
        setBalance(balance + amount);
    }

    private void setBalance(double balance)
    {
        this.balance = balance;
    }
}
