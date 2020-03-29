package com.epam.maksim_iashkov.java.lesson2.model;

public class Taxi extends Transport implements Incomeable {
    private double money;
    private double times;

    public Taxi(double cost, int fuelFlow, int passCapacity, double velocity, double times) {
        super(cost, fuelFlow, passCapacity, velocity);
        this.times = times;
    }

    @Override
    public void moving() {
        System.out.println("Такси перемещается по городу");
        double distance = 0.00;
        double flow = 0.00;
        distance = times * getVelocity();
        flow = distance * getFuelFlow();
    }

    @Override
    public void declareStation() {
        System.out.println("Пока не ясно, это бы не применять");
    }

    @Override
    public double income() {
        final int RATE = 200;
        return money = RATE*times;
    }
}
