package com.epam.maksim_iashkov.java.lesson2.model;

public class Ferry extends Transport {
    private double times;
    public Ferry(double cost, int fuelFlow, int passCapacity, double velocity, double times) {
        super(cost, fuelFlow, passCapacity, velocity);
        this.times = times;
    }

    @Override
    public void moving() {
        System.out.println("Паром перемещается по рекам");
        double distance = 0.00;
        double flow = 0.00;
        distance = times * getVelocity();
        flow = distance * getFuelFlow();
    }

    @Override
    public void declareStation() {
        System.out.println("Посадка окончена, паром следует до следующей остановки");
    }
}
