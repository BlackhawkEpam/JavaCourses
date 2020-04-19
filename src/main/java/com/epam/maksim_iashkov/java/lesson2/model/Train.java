package com.epam.maksim_iashkov.java.lesson2.model;

/**
 * Класс для описания поездов
 */
public class Train extends Transport implements Repairable{
    static final double MILE = 0.5; //Коэффициент износа поезда
    private double times;   //Время пробега поезда
    private double acceleration;    //Ускорение поезда

    /**
     * Конструктор для класса поездов
     */
    public Train(double cost, int fuelFlow, int passCapacity, double velocity, double times, double acceleration) {
        super(cost, fuelFlow, passCapacity, velocity);
        this.times = times;
        this.acceleration = acceleration;
    }

    /**
     * Метод подсчёта уценки поезда в зависимости от пробега
     */
    @Override
    public void mileage() {
        if ((getVelocity()*times*MILE) < getCost()) {
            setCost(getCost() - getVelocity()*times*MILE);
        } else {
            setCost(0.00);
        }
    }

    /**
     * Метод подсчёта новой скорости, до которой может разогнаться поезд с ускорением
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
        setPassCapacity(getPassCapacity()+50);
        setVelocity(getVelocity()+20.00);
        setCost(getCost()*1.1);
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