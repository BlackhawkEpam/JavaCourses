package com.epam.maksim_iashkov.java.lesson2.model;

/**
 * Класс описания паромов
 */
public class Ferry extends Transport {
    private double times;   //Время парома в пути
    private double acceleration;    //Ускорение движения парома

    /**
     * Конструктор для экземпляров паромов
     */
    public Ferry(double cost, int fuelFlow, int passCapacity, double velocity, double times, double acceleration) {
        super(cost, fuelFlow, passCapacity, velocity);
        this.times = times;
        this.acceleration = acceleration;
    }

    /**
     * Метод описания движения парома - считает количество съеденного топлива
     */
    @Override
    public void moving() {
        System.out.println("Паром перемещается по рекам");
        double distance;    //Пройденное паромом расстояние
        double flow;    //Количество съеденного топлива
        distance = times * getVelocity() +acceleration * Math.pow(2, times) * 0.5;
        flow = distance * getFuelFlow();
        System.out.println("Израсходованное паромом количество топлива: "+flow+" литров");
    }

    /**
     * Метод объявления остановок парома
     */
    @Override
    public void declareStation() {
        System.out.println("Посадка окончена, паром следует до следующей остановки");
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