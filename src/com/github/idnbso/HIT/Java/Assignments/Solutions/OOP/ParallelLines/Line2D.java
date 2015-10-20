package com.github.idnbso.hit.java.assignments.solutions.oop.parallellines;

class Line2D
{
    Point2D first;
    Point2D second;

    Line2D(Point2D p1, Point2D p2)
    {
        first = p1;
        second = p2;
    }

    void details()
    {
        System.out.println(
                "((" + first.getX() + "," + first.getY() + ") , (" + second.getX() + "," + second.getY() + "))");
    }

    boolean isParallel(Line2D otherLine)
    {
        return (!this.equals(otherLine) && this.getSlope() == otherLine.getSlope());
    }

    double length()
    {
        return (Math.sqrt(getDeltaX() * getDeltaX() + getDeltaY() * getDeltaY()));
    }

    double getSlope()
    {
        return (getDeltaY() / getDeltaX());
    }

    double getDeltaX()
    {
        return (second.getX() - first.getX());
    }

    double getDeltaY()
    {
        return (second.getY() - first.getY());
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Line2D other = (Line2D) obj;
        if (first == null)
        {
            if (other.first != null)
                return false;
        }
        else if (!first.equals(other.first))
            return false;
        if (second == null)
        {
            if (other.second != null)
                return false;
        }
        else if (!second.equals(other.second))
            return false;
        return true;
    }
}
