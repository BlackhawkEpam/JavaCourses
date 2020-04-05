package com.epam.maksim_iashkov.java.lesson2.model;

/**
 * Абстрактный класс всех транспортных средств, от которых будут наследоваться:
 * Автобусы
 * Троллейбусы
 * Поезда
 * Паромы
 * Такси
 */
public abstract class Transport implements Comparable<Transport>{
    private double cost;    //Цена транспортного средства
    private int fuelFlow;   //Расход топлива транспортного средства
    private int passCapacity;   //Пассажировместимость транспорта
    private double velocity;    //Скорость транспорта

    /**
     * Конструктор абстрактного класса транспортных средств
     */
    public Transport(double cost, int fuelFlow, int passCapacity, double velocity) {
        this.cost = cost;
        this.fuelFlow = fuelFlow;
        this.passCapacity = passCapacity;
        this.velocity = velocity;
    }

    /*Блок геттеров для параметров транспортов*/
    public double getCost() { return cost; }
    public int getFuelFlow() { return fuelFlow; }
    public int getPassCapacity() { return passCapacity; }
    public double getVelocity() { return velocity; }

    /**
     * Переопределение компаратора, использующегося в статическом методе sort
     * Для класса TransportSort
     */
    @Override
    public int compareTo(Transport o) {
        if (fuelFlow < o.fuelFlow) return -1;
        if (fuelFlow > o.fuelFlow) return 1;
        return 0;
    }
}
