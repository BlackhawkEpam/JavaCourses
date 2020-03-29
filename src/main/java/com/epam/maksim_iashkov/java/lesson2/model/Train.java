package com.epam.maksim_iashkov.java.lesson2.model;

public class Train extends Transport implements Chargeable, Incomeable {
    private double times;
    private double chargeHeat;
    private double money;
    public Train(double cost, int fuelFlow, int passCapacity, double velocity, double times) {
        super(cost, fuelFlow, passCapacity, velocity);
        this.times = times;
    }

    @Override
    public void moving() {
        System.out.println("Поезд двигается по путям");
        double distance = 0.00;
        distance = times * getVelocity();
    }

    @Override
    public void declareStation() {
        System.out.println("Осторожно, двери закрываются! Поезд следует до следующей станции");
    }

    public double charge() {
        final int VOLTAGE = 220;
        final int AMPER = 5;
        return chargeHeat = VOLTAGE*AMPER*times;
    }

    public double income() {
        final int RATE = 200;
        return money = RATE*times;
    }
}
