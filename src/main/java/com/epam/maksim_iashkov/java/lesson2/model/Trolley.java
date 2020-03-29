package com.epam.maksim_iashkov.java.lesson2.model;

public class Trolley extends Transport implements Chargeable {
    private double times;
    private double chargeHeat;
    public Trolley(double cost, int fuelFlow, int passCapacity, double velocity, double times) {
        super(cost, fuelFlow, passCapacity, velocity);
        this.times = times;
    }

    public double charge() {
        final int VOLTAGE = 220;
        final int AMPER = 5;
        return chargeHeat = VOLTAGE*AMPER*times;
    }

    @Override
    public void moving() {
        System.out.println("Троллейбус перемещается вдоль линий");
        double distance = 0.00;
        double flow = 0.00;
        distance = times * getVelocity();
    }

    @Override
    public void declareStation() {
        System.out.println("Осторожно, двери закрываются! Троллейбус следует до следующей станции");
    }
}
