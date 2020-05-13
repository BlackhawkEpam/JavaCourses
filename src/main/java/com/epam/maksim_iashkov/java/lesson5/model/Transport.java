package com.epam.maksim_iashkov.java.lesson5.model;

import java.io.Serializable;

/**
 * Абстрактный класс всех транспортных средств, от которых будут наследоваться:
 * Автобусы
 * Троллейбусы
 * Поезда
 * Паромы
 * Такси
 */
public abstract class Transport implements Serializable {   //Класс наследует интерфейс-маркер для сериализации
    /*Все переменные - несериализуемые, так как являются числовыми*/
    private transient double cost;    //Цена транспортного средства
    private transient int passCapacity;   //Пассажировместимость транспорта
    private transient double velocity;    //Скорость транспорта

    /**
     * Конструктор абстрактного класса транспортных средств
     */
    public Transport(double cost, int passCapacity, double velocity) {
        this.cost = cost;
        this.passCapacity = passCapacity;
        this.velocity = velocity;
    }

    /*Блок геттеров для параметров транспортов*/
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
