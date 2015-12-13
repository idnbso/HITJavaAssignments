package com.github.idnbso.hit.java.assignments.threads.microanimals;

public class MicroAnimalsDemo
{
    public static void main(String[] args)
    {
        MicroDog dogy = new MicroDog(150);
        MicroCat caty = new MicroCat(200);
        Thread t1 = new Thread(dogy);
        Thread t2 = new Thread(caty);
        t1.start();
        t2.start();
    }
}
