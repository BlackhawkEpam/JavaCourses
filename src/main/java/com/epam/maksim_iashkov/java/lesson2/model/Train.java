package com.epam.maksim_iashkov.java.lesson2.model;

/**
 * Класс для описания поездов
 */
public class Train extends Transport implements Chargeable, Incomeable {
    private double times;   //Время поезда в пути
    private double chargeHeat;  //Энергия, выделяющаяся при работе электрического тока в токоприемниках
    private double money;   //Плата за билет на поезд

    /**
     * Конструктор для класса поездов
     */
    public Train(double cost, int fuelFlow, int passCapacity, double velocity, double times) {
        super(cost, fuelFlow, passCapacity, velocity);
        this.times = times;
    }

    /**
     * Метод движения поезда - считает пройденную дистанцию
     */
    @Override
    public void moving() {
        System.out.println("Поезд двигается по путям");
        double distance;
        distance = times * getVelocity();
        System.out.println("Пройденная дистанция = "+distance);
    }

    /**
     * Метод для объявления на остановках
     */
    @Override
    public void declareStation() {
        System.out.println("Осторожно, двери закрываются! Поезд следует до следующей станции");
    }

    /**
     * Метод подсчета энергии, выделяющийся при движении в токоприемнике
     */
    @Override
    public double charge() {
        final int VOLTAGE = 220;
        final int AMPER = 5;
        return chargeHeat = VOLTAGE*AMPER*times;
    }

    /**
     * Метод, считающий, сколько требуется заплатить за билет в зависимости от дальности следования
     */
    @Override
    public double income() {
        if ((times*getVelocity() >= 0)&(times*getVelocity() < 1000)) {
            return money = 100.00;
        }
        else if ((times*getVelocity() >= 1000)&(times*getVelocity() < 3000)) {
            return money = 300.00;
        } else {
            return money = 500.00;
        }
    }

    /**
     * Метод для вывода экземпляров Поезда не в виде хэша
     */
    @Override
    public String toString() {
        return "Train{" +
                "cost=" + getCost() +
                ", fuelFlow=" + getFuelFlow() +
                ", passCapacity=" + getPassCapacity() +
                ", velocity=" + getVelocity() +
                '}';
    }
}