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
        double deltaX = getDeltaX();
        double deltaY = getDeltaY();
        return (Math.sqrt(deltaX * deltaX + deltaY * deltaY));
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((first == null) ? 0 : first.hashCode());
        result = prime * result + ((second == null) ? 0 : second.hashCode());
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
        Line2D other = (Line2D) obj;
        if (first == null)
        {
            if (other.first != null)
            {
                return false;
            }
        }
        else if (!first.equals(other.first))
        {
            return false;
        }
        if (second == null)
        {
            if (other.second != null)
            {
                return false;
            }
        }
        else if (!second.equals(other.second))
        {
            return false;
        }
        return true;
    }

    protected double getSlope()
    {
        return (getDeltaY() / getDeltaX());
    }

    protected double getDeltaX()
    {
        return (second.getX() - first.getX());
    }

    protected double getDeltaY()
    {
        return (second.getY() - first.getY());
    }
}
