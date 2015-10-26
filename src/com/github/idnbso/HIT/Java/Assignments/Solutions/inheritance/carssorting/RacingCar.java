package com.github.idnbso.hit.java.assignments.solutions.inheritance.carssorting;

public class RacingCar extends SportCar
{
    private String sponsorName;

    public RacingCar(int horsePower, String modelName, boolean isManualCar,
            String sponsorName)
    {
        super(horsePower, modelName, isManualCar);
        setSponsorName(sponsorName);
    }

    public String getSponsorName()
    {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName)
    {
        this.sponsorName = sponsorName;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", RacingCar info: [sponsorName()="
                + getSponsorName() + "]";
    }
}
