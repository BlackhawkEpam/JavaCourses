package com.epam.maksim_iashkov.java.lesson2.model;

/**
 * Класс, описывающий троллейбусы
 */
public class Trolley extends Transport {

    /*Конструктор для троллейбусов*/
    public Trolley(double cost, int fuelFlow, int passCapacity, double velocity) {
        super(cost, fuelFlow, passCapacity, velocity);
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