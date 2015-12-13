package com.github.idnbso.hit.java.assignments.threads.leftright;

public class SidePrinter implements Runnable
{
    private Side side;
    private final int totalPrintIterations;

    public SidePrinter(Side side)
    {
        super();
        setSideName(side);
        totalPrintIterations = (side == Side.RIGHT) ? 1000 : 100;
    }

    public final String getSideName()
    {
        return side.toString();
    }

    public final void setSideName(Side side)
    {
        this.side = side;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < totalPrintIterations; i++)
        {
            System.out.println(side.toString());
            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public enum Side
    {
        RIGHT("Right"), LEFT("left");

        private final String side;

        private Side(String side)
        {
            this.side = side;
        }

        public String toString()
        {
            return this.side;
        }
    }

}
