package com.epam.maksim_iashkov.java.lesson2.model;

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
        if ((distance/getVelocity())*TERM < getCost()) {
            setCost(getCost() - (distance/getVelocity())*TERM);
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
    public String toString(){
        return "Автобус. Параметры автобуса: " +
                "Цена = " + getCost() + " руб" +
                ", Расход топлива = " + getFuelFlow() + " л/км" +
                ", Пассажировместимость = " + getPassCapacity() + " чел" +
                ", Скорость = " + getVelocity() + " км/ч";
    }
}