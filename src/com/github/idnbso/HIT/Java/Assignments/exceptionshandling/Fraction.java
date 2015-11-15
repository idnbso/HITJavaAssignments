package com.github.idnbso.hit.java.assignments.exceptionshandling;

public class Fraction
{

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) throws FractionDivideByZeroException
    {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public int getNumerator()
    {
        return numerator;
    }

    public void setNumerator(int numerator)
    {
        this.numerator = numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public void setDenominator(int denominator) throws FractionDivideByZeroException
    {
        if (denominator != 0)
        {
            this.denominator = denominator;
        }
        else
        {
            throw new FractionDivideByZeroException(
                    "You cannot set a denominator with the value of 0.");
        }
    }

    @Override
    public String toString()
    {
        return "Fraction [numerator=" + numerator + ", denominator=" + denominator + "]";
    }

    public static Fraction divide(Fraction fraction1, Fraction fraction2) throws FractionDivideByZeroException
    {
        if (fraction2.getNumerator() == 0)
        {
            throw new FractionDivideByZeroException("You cannot divide a value of 0.");
        }
        
        return new Fraction(fraction1.getNumerator() * fraction2.getDenominator(),
                fraction1.getDenominator() * fraction2.getNumerator());
    }

}
