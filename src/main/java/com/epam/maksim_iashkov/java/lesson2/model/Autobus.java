package com.epam.maksim_iashkov.java.lesson2.model;

public class Autobus extends Transport {
    private double times;
    private int passanger;
    private int freePlace;

    public Autobus(double cost, int fuelFlow, int passCapacity, double velocity, double times, int passanger) {
        super(cost, fuelFlow, passCapacity, velocity);
        this.times = times;
        this.passanger = passanger;
    }

    @Override
    public void moving() {
        System.out.println("Автобус перемещается по городу");
        double distance = 0.00;
        double flow = 0.00;
        distance = times * getVelocity();
        flow = distance * getFuelFlow();
    }

    @Override
    public void declareStation() {
        System.out.println("Осторожно, двери закрываются! Автобус следует до следующей станции");
    }

    public int freePlace(int passanger) {
        if (passanger > getPassCapacity()) {
        return freePlace = 0;
        }
    else {
        return freePlace = getPassCapacity() - passanger;
        }
    }
}