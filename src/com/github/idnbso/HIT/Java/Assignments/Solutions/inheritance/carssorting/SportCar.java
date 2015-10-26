package com.github.idnbso.hit.java.assignments.solutions.inheritance.carssorting;

public class SportCar extends Car
{
    private boolean isManualCar;
    
    public SportCar(int horsePower, String modelName, boolean isManualCar)
    {
        super(horsePower, modelName);
        setManualCar(isManualCar);
    }

    public boolean isManualCar()
    {
        return isManualCar;
    }

    public void setManualCar(boolean isManualCar)
    {
        this.isManualCar = isManualCar;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", SportCar info: [isManualCar()="
                + isManualCar() + "]";
    }

}
