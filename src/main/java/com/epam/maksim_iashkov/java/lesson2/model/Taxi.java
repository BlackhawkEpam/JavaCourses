package com.epam.maksim_iashkov.java.lesson2.model;

/**
 * Класс для описания такси
 */
public class Taxi extends Transport {

    /**
     * Конструктор для экземпляров такси
     */
    public Taxi(double cost, int fuelFlow, int passCapacity, double velocity) {
        super(cost, fuelFlow, passCapacity, velocity);
    }

    /**
     * Метод для вывода экземпляров Такси не в виде хэша
     */
    @Override
    public String toString() {
        return "Такси. Параметры такси: " +
                "Цена = " + getCost() + " руб" +
                ", Расход топлива = " + getFuelFlow() + " л/км" +
                ", Пассажировместимость = " + getPassCapacity() + " чел" +
                ", Скорость = " + getVelocity() + " км/ч";
    }
}