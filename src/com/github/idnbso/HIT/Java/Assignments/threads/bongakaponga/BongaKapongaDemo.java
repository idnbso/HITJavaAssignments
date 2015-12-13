package com.github.idnbso.hit.java.assignments.threads.bongakaponga;

public class BongaKapongaDemo
{
    public static void main(String[] args)
    {
        Bonga bonga = new Bonga(15);
        Kaponga kaponga = new Kaponga(3);
        Thread t1 = new Thread(bonga);
        Thread t2 = new Thread(kaponga);
        t1.start();
        t2.start();
    }
}
