package com.epam.maksim_iashkov.java.lesson2.model;

public abstract class Transport {
    private double cost;
    private int fuelFlow;
    private int passCapacity;
    private double velocity;

    public Transport(double cost, int fuelFlow, int passCapacity, double velocity) {
        this.cost = cost;
        this.fuelFlow = fuelFlow;
        this.passCapacity = passCapacity;
        this.velocity = velocity;
    }

    public double getCost() { return cost; }
    public int getFuelFlow() { return fuelFlow; }
    public int getPassCapacity() { return passCapacity; }
    public double getVelocity() { return velocity; }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setFuelFlow(int fuelFlow) {
        this.fuelFlow = fuelFlow;
    }

    public void setPassCapacity(int passCapacity) {
        this.passCapacity = passCapacity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public abstract void moving();
    public abstract void declareStation();
}
