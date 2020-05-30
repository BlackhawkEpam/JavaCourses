package com.epam.maksim_iashkov.java.lesson7.model;

/**
 * Абстрактный класс летных транспортных средств
 */
public abstract class AirTransport {

    private transient double cost;    //Цена транспортного средства
    private transient int passCapacity;   //Пассажировместимость транспорта
    private transient double velocity;    //Скорость транспорта

    /**
     * Конструктор абстрактного класса летных ТС
     */
    public AirTransport(double cost, int passCapacity, double velocity) {
        this.cost = cost;
        this.passCapacity = passCapacity;
        this.velocity = velocity;
    }

    /*Блок геттеров для параметров летных ТС*/
    public double getCost() {
        return cost;
    }

    public int getPassCapacity() {
        return passCapacity;
    }

    public double getVelocity() {
        return velocity;
    }
}