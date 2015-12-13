package com.github.idnbso.hit.java.assignments.threads.leftright;

import com.github.idnbso.hit.java.assignments.threads.leftright.SidePrinter.Side;

public class LeftRightThreads
{

    public static void main(String[] args)
    {
        SidePrinter right = new SidePrinter(Side.RIGHT);
        SidePrinter left = new SidePrinter(Side.LEFT);
        Thread t1 = new Thread(right, "Right Thread");
        Thread t2 = new Thread(left, "Left Thread");
        t1.start();
        t2.start();
        System.out.println("Both t1 and t2 ended");
    }

}
