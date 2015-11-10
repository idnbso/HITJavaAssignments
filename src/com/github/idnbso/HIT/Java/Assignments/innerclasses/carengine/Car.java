package com.github.idnbso.hit.java.assignments.innerclasses.carengine;

public class Car
{
    private Engine engine;
    private Wheel[] wheels;
    private int drivingSpeed;

    public Car(Engine engine, Wheel wheel)
    {
        super();
        this.engine = engine;

        wheels = new Wheel[4];
        for (Wheel carsWheel : wheels)
        {
            carsWheel = wheel;
        }
    }

    public Engine getEngine()
    {
        return engine;
    }

    public Wheel[] getWheels()
    {
        return wheels;
    }

    public int getDrivingSpeed()
    {
        return drivingSpeed;
    }

    public void setEngine(Engine engine)
    {
        this.engine = engine;
    }

    public void setWheels(Wheel[] wheels)
    {
        this.wheels = wheels;
    }

    private void setWheelsSpeed(int speed)
    {
        for (Wheel wheel : wheels)
        {
            wheel.setSpeed(speed);
        }
    }

    class Engine
    {
        private double capacity;

        public Engine(double capacity)
        {
            super();
            this.capacity = capacity;
        }

        public double getCapacity()
        {
            return capacity;
        }

        public void setCapacity(double capacity)
        {
            this.capacity = capacity;
        }

        private void setSpeed(int speed)
        {
            drivingSpeed = speed;
            setWheelsSpeed(speed);
        }
    }

    class Wheel
    {
        private int speed;

        public Wheel(int speed)
        {
            super();
            this.speed = speed;
        }

        public int getSpeed()
        {
            return speed;
        }

        private void setSpeed(int speed)
        {
            this.speed = speed;
        }
    }
}
