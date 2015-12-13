package com.github.idnbso.hit.java.assignments.threads.bankaccount;

public class Account
{
    private long id;
    private double balance;

    public Account()
    {
        this(0L, 0.0d);
    }

    public Account(long id, double balance)
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

    synchronized public void withdraw(double amount)
    {
        try
        {
            if (balance < amount)
            {
                System.out.println("Cannot withdraw amount of " + amount + "$ from total of " + balance + "$, entering wait mode.");
            }
            while (balance < amount)
            {
                wait();
            }
            setBalance(balance - amount);
            System.out.println(
                    "# Withdrawn " + amount + "$ from new total of " + balance);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void deposit(double amount)
    {
        synchronized (this)
        {
            setBalance(balance + amount);
            System.out.println(
                    "# Deposited " + amount + "$ to new total of " + balance);
            notifyAll();
        }
    }

    protected void setId(long id)
    {
        this.id = id;
    }

    protected void setBalance(double balance)
    {
        this.balance = balance;
    }
}
