package com.github.idnbso.hit.java.assignments.solutions.inheritance.carssorting;

public class Car implements Comparable
{
    private int horsePower;
    private String modelName;

    public Car(int horsePower, String modelName)
    {
        setHorsePower(horsePower);
        setModelName(modelName);
    }

    public int getHorsePower()
    {
        return horsePower;
    }

    public String getModelName()
    {
        return modelName;
    }

    public void setHorsePower(int horsePower)
    {
        this.horsePower = horsePower;
    }

    public void setModelName(String modelName)
    {
        this.modelName = modelName;
    }

    @Override
    public int compareTo(Object otherCar)
    {
        int difference = this.getHorsePower()
                - ((Car) otherCar).getHorsePower();
        return difference;
    }

    @Override
    public String toString()
    {
        return "Car info: [horsePower=" + horsePower + ", modelName="
                + modelName + "]";
    }

}
