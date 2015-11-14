package com.github.idnbso.hit.java.assignments.iostreams;

import java.io.*;

public class AccountClassLogFiles
{

    public static void main(String[] args)
    {
        LoggingBankAccount account = new LoggingBankAccount(123, 1_000.5, new File(args[0]), true);

        account.deposit(5);
        account.withdraw(10.55);
        account.deposit(0.45);
    }

}
