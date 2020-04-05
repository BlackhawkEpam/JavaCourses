package com.epam.maksim_iashkov.java.lesson2.model;

/**
 * Класс для описания автобусов
 */
public class Autobus extends Transport {

    /**
     * Конструктор для экземпляров автобусов
     */
    public Autobus(double cost, int fuelFlow, int passCapacity, double velocity) {
        super(cost, fuelFlow, passCapacity, velocity);
    }

    /**
     * Метод для вывода экземпляров Автобусов не в виде хэша
     */
    @Override
    public String toString(){
        return "Автобус. Параметры автобуса: " +
                "Цена = " + getCost() + " руб" +
                ", Расход топлива = " + getFuelFlow() + " л/км" +
                ", Пассажировместимость = " + getPassCapacity() + " чел" +
                ", Скорость = " + getVelocity() + " км/ч";
    }
}