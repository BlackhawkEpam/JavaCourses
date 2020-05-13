package com.epam.maksim_iashkov.java.lesson7.model;

import com.epam.maksim_iashkov.java.lesson7.annotation.OverZero;

import java.io.Serializable;

/**
 * Класс, описывающий троллейбусы
 */
public class Trolley extends Transport implements Serializable {
    private String design;                 //Компания-производитель троллейбуса
    private boolean needRepair;            //Признак необходимости замены электродвигателя
    @OverZero
    private transient int powerEngine;    //Мощность двигателя троллейбуса - несериализуемый параметр (т.к. числовой)

    /*Конструктор для троллейбусов*/
    public Trolley(double cost, int passCapacity, double velocity, String design, boolean needRepair, int powerEngine) {
        super(cost, passCapacity, velocity);
        this.design = design;
        this.needRepair = needRepair;
        this.powerEngine = powerEngine;
    }

    /*Блок геттеров для приватных переменных класса Троллейбус*/
    public String getDesign() {
        return design;
    }

    public boolean isNeedRepair() {
        return needRepair;
    }

    public int getPowerEngine() {
        return powerEngine;
    }

    /**
     * Метод для вывода экземпляров Троллейбусов не в виде хэша
     */
    @Override
    public String toString() {
        return "Троллейбус. Параметры троллейбус: " +
                "Цена = " + getCost() + " руб" +
                ", Пассажировместимость = " + getPassCapacity() + " чел" +
                ", Скорость = " + getVelocity() + " км/ч" +
                ", Производитель = " + getDesign() +
                ", Требуется ремонт = " + isNeedRepair() +
                ", Мощность двигателя = " + getPowerEngine() + " кВТ";
    }
}