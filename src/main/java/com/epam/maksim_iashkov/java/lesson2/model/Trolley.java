package com.epam.maksim_iashkov.java.lesson2.model;

/**
 * Класс, описывающий троллейбусы
 */
public class Trolley extends Transport {
    static final double VOLTAGE = 220.00;   //Напряжение линий движения
    static final double AMPER = 0.5;    //Сила тока линий движения
    private int powerengine;    //Мощность двигателя троллейбуса
    private double times;   //Время пробега троллейбуса

    /*Конструктор для троллейбусов*/
    public Trolley(double cost, int fuelFlow, int passCapacity, double velocity, int powerengine, double times) {
        super(cost, fuelFlow, passCapacity, velocity);
        this.powerengine = powerengine;
        this.times = times;
    }

    /**
     * Метод расчёта уценки троллейбуса в зависимости от типа двигателя и времени его работы
     */
    @Override
    public void mileage() {
        if (getCost() > VOLTAGE*AMPER*times) {
            if ((powerengine >= 0)&&(powerengine < 75)) {
                setCost(getCost() - VOLTAGE*AMPER*times);
            }
            else if ((powerengine < 120)&&(powerengine >= 75)){
                setCost(getCost() - VOLTAGE*AMPER*times*0.8);
            } else {
                setCost(getCost() - VOLTAGE*AMPER*times*0.6);
            }
        } else {
            setCost(0.00);
        }
    }

    /**
     * Метод пересчета скорости троллейбуса в зависимости от типа двигателя
     */
    @Override
    public void addVelocity() {
        if ((powerengine >= 0)&&(powerengine < 75)) {
            setVelocity(getVelocity()*1.00);
        }
        else if ((powerengine < 120)&&(powerengine >= 75)){
           setVelocity(getVelocity()*1.20);
        } else {
            setVelocity(getVelocity()*1.40);
        }
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