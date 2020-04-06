package com.epam.maksim_iashkov.java.lesson2.model;

/**
 * Класс описания паромов
 */
public class Ferry extends Transport {
    private double times;   //Время пробега парома
    private boolean onstream;   //Признак того, что паром плывет по течению

    /**
     * Конструктор для экземпляров паромов
     */
    public Ferry(double cost, int fuelFlow, int passCapacity, double velocity, double times, boolean onstream) {
        super(cost, fuelFlow, passCapacity, velocity);
        this.times = times;
        this.onstream = onstream;
    }

    /**
     * Метод расчёта ученки стоимости парома - в зависимости от его дальности плавания
     */
    @Override
    public void mileage() {
        if ((getVelocity()*times >= 0)&&(getVelocity()*times < 1000)){
            setCost(getCost()*0.7);
        }
        else if ((getVelocity()*times >= 1000)&&(getVelocity()*times < 4000)){
            setCost(getCost()*0.4);
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