package com.github.idnbso.hit.java.assignments.threads.stringsexchaning;

import java.util.concurrent.Exchanger;

class SendStrings
{
    public static void main(String args[])
    {
        Exchanger<String> exchanger = new Exchanger<String>();
        StringsGenerator generator1 = new StringsGenerator(exchanger,
                new String[] { "Europe", "Asia", "America", "Africa", "Australia" });
        StringsGenerator generator2 = new StringsGenerator(exchanger,
                new String[] { "Canada", "France", "Lebanon", "Mexico", "Russia" });
        Thread t1 = new Thread(generator1);
        t1.start();
        Thread t2 = new Thread(generator2);
        t2.start();
    }
}