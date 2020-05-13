package com.epam.maksim_iashkov.java.lesson7.model;

import com.epam.maksim_iashkov.java.lesson7.annotation.NotEmpty;

/**
 * Класс для описания автобусов
 */
public class Autobus extends Transport {
    private String regNumber;       //Регистрационный номер автобуса
    @NotEmpty
    private String model;           //Модель производителя
    private boolean needRepair;     //Признак необходимости ремонта

    /**
     * Конструктор для экземпляров автобусов
     */
    public Autobus(double cost, int passCapacity, double velocity, String RegNumber, String Model, boolean NeedRepair) {
        super(cost, passCapacity, velocity);
        this.regNumber = RegNumber;
        this.model = Model;
        this.needRepair = NeedRepair;
    }

    /*Блок геттеров для приватных переменных класса Автобус*/
    public String getRegNumber() {
        return regNumber;
    }

    public String getModel() {
        return model;
    }

    public boolean isNeedRepair() {
        return needRepair;
    }

    /**
     * Метод для вывода экземпляров Автобусов не в виде хэша
     */
    @Override
    public String toString() {
        return "Автобус. Параметры автобуса: " +
                "Цена = " + getCost() + " руб" +
                ", Пассажировместимость = " + getPassCapacity() + " чел" +
                ", Скорость = " + getVelocity() + " км/ч" +
                ", Регистрационный номер = " + getRegNumber() +
                ", Марка = " + getModel() +
                ", Требуется ремонт = " + isNeedRepair();
    }
}