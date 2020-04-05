package com.epam.maksim_iashkov.java.lesson2.model;

/**
 * Класс для описания поездов
 */
public class Train extends Transport {

    /**
     * Конструктор для класса поездов
     */
    public Train(double cost, int fuelFlow, int passCapacity, double velocity) {
        super(cost, fuelFlow, passCapacity, velocity);
    }

    /**
     * Метод для вывода экземпляров Поезда не в виде хэша
     */
    @Override
    public String toString() {
        return "Поезд. Параметры поезда: " +
                "Цена = " + getCost() + " руб" +
                ", Расход топлива = " + getFuelFlow() + " л/км" +
                ", Пассажировместимость = " + getPassCapacity() + " чел" +
                ", Скорость = " + getVelocity() + " км/ч";
    }
}