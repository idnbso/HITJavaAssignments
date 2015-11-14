package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LoggingBankAccount
{
    private long id;
    private double balance;
    private File logFile;

    public LoggingBankAccount()
    {
        this(0L, 0.0d);
    }

    public LoggingBankAccount(long id, double balance)
    {
        setId(id);
        setBalance(balance);
    }

    public LoggingBankAccount(long id, double balance, File logFile)
    {
        this(id, balance);
        setLogFile(logFile);
    }

    public LoggingBankAccount(long id, double balance, File logFile, boolean isNewLogFile)
    {
        this(id, balance);
        if (isNewLogFile)
        {
            setNewLogFile(logFile);
        }
        else
        {
            setLogFile(logFile);
        }
    }

    public long getId()
    {
        return id;
    }

    public double getBalance()
    {
        return balance;
    }

    public File getLogFile()
    {
        return logFile;
    }

    public void setLogFile(File logFile)
    {
        this.logFile = logFile;
    }

    public void setNewLogFile(File logFile)
    {
        this.logFile = logFile;
        String message = String.format("\t%s\t\t\t|\t%s\t|\t\t%s%s", "Date & Hour", "Amount", "Balance",
                System.lineSeparator());

        final String flag = "overwrite";
        String args[] = { logFile.getAbsolutePath(), message, flag };
        WriteTextualFile.main(args);
    }

    public void withdraw(double amount)
    {
        setBalance(balance - amount);
        writeToLogFile(LogMessageType.WITHDRAW, amount);
    }

    public void deposit(double amount)
    {
        setBalance(balance + amount);
        writeToLogFile(LogMessageType.DEPOSIT, amount);
    }

    protected void setId(long id)
    {
        this.id = id;
    }

    protected void setBalance(double balance)
    {
        this.balance = balance;
    }

    protected void writeToLogFile(LogMessageType type, double amount)
    {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd @ HH:mm:ss")
                .format(Calendar.getInstance().getTime());

        String signOfSum = (type == LogMessageType.WITHDRAW ? "-" : "+");

        String message = String.format("%s\t|\t%s%.2f\t|\t\t%.2f%s", timeStamp, signOfSum, amount,
                balance, System.lineSeparator());

        final String flag = "append";
        String args[] = { logFile.getAbsolutePath(), message, flag };
        WriteTextualFile.main(args);
    }

    @Override
    public String toString()
    {
        return "LoggingBankAccount [id=" + id + ", balance=" + balance + "]";
    }

    private enum LogMessageType
    {
        WITHDRAW, DEPOSIT;
    }
}
