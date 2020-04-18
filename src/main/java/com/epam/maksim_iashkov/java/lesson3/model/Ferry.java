package com.epam.maksim_iashkov.java.lesson3.model;

import com.epam.maksim_iashkov.java.lesson2.model.Transport;

/**
 * Класс описания паромов
 */
public class Ferry extends Transport {
    private double times;   //Время пробега парома
    private boolean onstream;   //Признак того, что паром плывет по течению
    private String names;   //Наименование парома

    /**
     * Конструктор для экземпляров паромов
     */
    public Ferry(double cost, int fuelFlow, int passCapacity, double velocity, double times, boolean onstream, String names) {
        super(cost, fuelFlow, passCapacity, velocity);
        this.times = times;
        this.onstream = onstream;
        this.names = names;
    }

    /**
     * Метод расчёта ученки стоимости парома - в зависимости от его дальности плавания
     */
    @Override
    public void mileage() {
        if ((getVelocity() * times >= 0) && (getVelocity() * times < 1000)) {
            setCost(getCost() * 0.7);
        } else if ((getVelocity() * times >= 1000) && (getVelocity() * times < 4000)) {
            setCost(getCost() * 0.4);
        } else {
            setCost(0.00);
        }
    }

    /**
     * Метод корректировки скорости парома в зависимости от направления течения
     */
    @Override
    public void addVelocity() {
        if (onstream) {
            setVelocity(getVelocity() + 10.00);
        } else {
            setVelocity(getVelocity() - 10.00);
        }
    }

    public void setNames(String names) {
        this.names = names;
    }   //Сеттер для переменной имени парома

    public double getTimes() {
        return times;
    }   //Геттер для переменной имени парома

    /**
     * Метод для вывода экземпляров Паромов не в виде хэша
     */
    @Override
    public String toString() {
        return "Паром. Параметры парома: " +
                "Цена = " + getCost() + " руб" +
                ", Расход топлива = " + getFuelFlow() + " л/км" +
                ", Пассажировместимость = " + getPassCapacity() + " чел" +
                ", Скорость = " + getVelocity() + " км/ч" +
                ", Название парома = " + names;
    }
}