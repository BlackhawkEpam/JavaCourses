package com.epam.maksim_iashkov.java.lesson2.model;

/**
 * Класс описания паромов
 */
public class Ferry extends Transport {

    /**
     * Конструктор для экземпляров паромов
     */
    public Ferry(double cost, int fuelFlow, int passCapacity, double velocity) {
        super(cost, fuelFlow, passCapacity, velocity);
    }

    /**
     * Метод для вывода экземпляров Паромов не в виде хэша
     */
    @Override
    public String toString() {
        return "Паром. Параметры парома: " +
                "Цена = " + getCost() + " руб" +
                ", Расход топлива = " + getFuelFlow() + " л/км" +
                ", Пассажировместимость = " + getPassCapacity() + " чел" +
                ", Скорость = " + getVelocity() + " км/ч";
    }
}