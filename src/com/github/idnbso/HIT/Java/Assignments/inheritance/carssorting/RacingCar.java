package com.github.idnbso.hit.java.assignments.inheritance.carssorting;

public class RacingCar extends SportCar
{
    private String sponsorName;

    public RacingCar(int horsePower, String modelName, boolean isManualCar,
            String sponsorName)
    {
        super(horsePower, modelName, isManualCar);
        setSponsorName(sponsorName);
    }

    public RacingCar()
    {
        this(0, "modelName", false, "sponserName");
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
