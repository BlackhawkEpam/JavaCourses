package com.epam.maksim_iashkov.java.lesson3.model;

import com.epam.maksim_iashkov.java.lesson3.exception.NotPosCostException;
import com.epam.maksim_iashkov.java.lesson3.exception.NotPosVelocityException;
import com.epam.maksim_iashkov.java.lesson2.model.Transport;

/**
 * Класс для описания автобусов
 */
public class Autobus extends Transport {
    private double distance;    //Пробег автобуса
    static final double TERM = 8.5; //Коэффициент износа в зависимости от срока службы автобуса

    /**
     * Конструктор для экземпляров автобусов
     */
    public Autobus(double cost, int fuelFlow, int passCapacity, double velocity, double distance) {
        super(cost, fuelFlow, passCapacity, velocity);
        this.distance = distance;
    }

    /**
     * Метод уценивания стоимости автобуса в зависимости от срока службы
     */
    @Override
    public void mileage() {
        if (getCost() < 0)
            throw new NotPosCostException("Цена не может быть меньше 0!", getCost());    //Генерация эксепшена - при отрицательной стоимости
        if (getVelocity() <= 0)
            throw new NotPosVelocityException("Скорость не может быть меньше или равна нулю!", getVelocity());  //Генерация эксепшена - при неположительной скорости
        if ((distance / getVelocity()) * TERM < getCost()) {
            setCost(getCost() - (distance / getVelocity()) * TERM);
        } else {
            setCost(0.00);
        }
    }

    /**
     * Пустой неиспользуемый родительский метод - автобус у нас будет двигаться прямолинейно равномерно =)
     */
    @Override
    public void addVelocity() {
    }

    /**
     * Метод для вывода экземпляров Автобусов не в виде хэша
     */
    @Override
    public String toString() {
        return "Автобус. Параметры автобуса: " +
                "Цена = " + getCost() + " руб" +
                ", Расход топлива = " + getFuelFlow() + " л/км" +
                ", Пассажировместимость = " + getPassCapacity() + " чел" +
                ", Скорость = " + getVelocity() + " км/ч";
    }
}