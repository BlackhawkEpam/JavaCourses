package com.epam.maksim_iashkov.java.lesson7.model;

import com.epam.maksim_iashkov.java.lesson7.annotation.IsTransport;

/**
 * Класс для описания вертолётов
 */
@IsTransport
public class Helicopter extends AirTransport {
    private String brand;           //Модель вертолёта
    private String regNumber;       //Регистрационный номер

    /**
     * Конструктор для экземпляров автобусов
     */
    public Helicopter(double cost, int passCapacity, double velocity, String brand, String regNumber) {
        super(cost, passCapacity, velocity);
        this.brand = brand;
        this.regNumber = regNumber;
    }

    /*Блок геттеров для приватных переменных класса Вертолёт*/
    public String getBrand() {
        return brand;
    }

    public String getRegNumber() {
        return regNumber;
    }

    /**
     * Метод для вывода экземпляров вертолетов не в виде хэша
     */
    @Override
    public String toString() {
        return "Вертолёт. Параметры вертолёта: " +
                "Цена = " + getCost() + " руб" +
                ", Пассажировместимость = " + getPassCapacity() + " чел" +
                ", Скорость = " + getVelocity() + " км/ч" +
                ", Марка вертолёта = " + getBrand() +
                ", Регистрационный номер = " + getRegNumber();
    }
}