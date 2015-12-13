package com.github.idnbso.hit.java.assignments.threads.bankaccount;

public class BankClient extends Thread
{
    private int totalTransactions = 5;
    private Account account;
    private final TransactionChoice choice;

    public BankClient(Account account, TransactionChoice choice)
    {
        super();
        setAccount(account);
        this.choice = choice;
    }

    public int getTotalTransactions()
    {
        return totalTransactions;
    }

    public void setTotalTransactions(int totalTransactions)
    {
        this.totalTransactions = totalTransactions;
    }

    public final Account getAccount()
    {
        return account;
    }

    public final void setAccount(Account account)
    {
        this.account = account;
    }

    @Override
    public void run()
    {
        for (int transaction = 0; transaction < totalTransactions; transaction++)
        {
            int amount = (int) (Math.random() * 50) + 1;
            try
            {
                if (choice == TransactionChoice.DEPOSIT)
                {
                    account.deposit(amount);
                    sleep(20);
                }
                else
                {
                    account.withdraw(amount);
                    sleep(20);
                }
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public enum TransactionChoice
    {
        WITHDRAW, DEPOSIT
    }
}
