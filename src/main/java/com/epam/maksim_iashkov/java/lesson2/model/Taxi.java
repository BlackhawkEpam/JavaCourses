package com.epam.maksim_iashkov.java.lesson2.model;

import com.epam.maksim_iashkov.java.lesson2.exception.NotPosCostException;
import com.epam.maksim_iashkov.java.lesson2.exception.NotPosVelocityException;

/**
 * Класс для описания такси
 */
public class Taxi extends Transport implements Repairable{
    static final double MILE = 0.4; //Коэффициент износа такси
    private double times;   //Время пробега такси
    private double acceleration;    //Ускорение такси

    /**
     * Конструктор для экземпляров такси
     */
    public Taxi(double cost, int fuelFlow, int passCapacity, double velocity, double times, double acceleration) {
        super(cost, fuelFlow, passCapacity, velocity);
        this.times = times;
        this.acceleration = acceleration;
    }

    /**
     * Метод подсчета ученки стоимости такси в зависимости от пробега
     */
    @Override
    public void mileage() {
        if (getCost() < 0) throw new NotPosCostException("Цена не может быть меньше 0!", getCost());    //Генерация эксепшена - при отрицательной стоимости
        if (getVelocity() <= 0) throw new NotPosVelocityException("Скорость не может быть меньше или равна нулю!", getVelocity());  //Генерация эксепшена - при неположительной скорости
        if ((getVelocity()*times*MILE + 0.5*acceleration*times*times*MILE) < getCost()) {
            setCost(getCost() - (getVelocity()*times*MILE + 0.5*acceleration*times*times*MILE));
        } else {
            setCost(0.00);
        }
    }

    /**
     * Метод подсчёта разгона такси с ускорением
     */
    @Override
    public void addVelocity() {
        setVelocity(getVelocity() + times*acceleration);
    }

    /**
     * Имплементация метода ремонта из интерфейса
     */
    @Override
    public void repair() {
        setPassCapacity(getPassCapacity()+1);
        setFuelFlow(getFuelFlow()-1);
        setVelocity(getVelocity()+20.00);
        setCost(getCost()*1.1);
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