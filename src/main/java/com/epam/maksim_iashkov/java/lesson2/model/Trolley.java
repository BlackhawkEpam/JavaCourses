package com.epam.maksim_iashkov.java.lesson2.model;

/**
 * Класс, описывающий троллейбусы
 */
public class Trolley extends Transport implements Chargeable {
    private double times;   //Время троллейбуса в пути
    private int powers; //Мощность двигателя троллейбуса
    private final double ENGOPERATION = 300.00;
    private final int VOLTAGE = 220;
    private final int AMPER = 3;

    /*Конструктор для троллейбусов*/
    public Trolley(double cost, int fuelFlow, int passCapacity, double velocity, double times, int powers) {
        super(cost, fuelFlow, passCapacity, velocity);
        this.times = times;
        this.powers = powers;
    }

    /**
     * Реализация метода электростатических процессов в токоприемнике троллейбуса
     * Имплементация метода из интерфейса Chargeable
     */
    @Override
    public double charge() {
        System.out.println("Троллейбусы не потребляют топливо, они потребляют заряд линий");
        //Энергия, выделяющаяся при работе электрического тока в токоприемниках
        double chargeHeat;
        return chargeHeat = VOLTAGE*AMPER*times;
    }

    /**
     * Метод движения троллейбуса - считает дистанцию, которую проехал троллейбус
     */
    @Override
    public void moving() {
        System.out.println("Троллейбус перемещается вдоль линий");
        double distance;
        distance = times * getVelocity() * (1 + powers*times/(2*ENGOPERATION));
        System.out.println("Пройденная троллейбусом дистанция = "+distance);
    }

    /**
     * Метод объявления на каждой троллейбусной остановке
     */
    @Override
    public void declareStation() {
        System.out.println("Осторожно, двери закрываются! Троллейбус следует до следующей станции");
    }

    /**
     * Метод для вывода экземпляров Троллейбусов не в виде хэша
     */
    @Override
    public String toString() {
        return "Троллейбус. Параметры троллейбус: " +
                "Цена = " + getCost() + " руб" +
                ", Расход топлива = " + getFuelFlow() + " л/км" +
                ", Пассажировместимость = " + getPassCapacity() + " чел" +
                ", Скорость = " + getVelocity() + " км/ч";
    }
}