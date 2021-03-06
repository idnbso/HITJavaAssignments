package com.github.idnbso.hit.java.assignments.oop.parallellines;

class Point2D
{
    private double x;
    private double y;

    Point2D(double xVal, double yVal)
    {
        x = xVal;
        y = yVal;
    }

    double getX()
    {
        return x;
    }

    double getY()
    {
        return y;
    }

    void details()
    {
        System.out.println("(" + x + "," + y + ")");
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        Point2D other = (Point2D) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
        {
            return false;
        }
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
        {
            return false;
        }
        return true;
    }
}
