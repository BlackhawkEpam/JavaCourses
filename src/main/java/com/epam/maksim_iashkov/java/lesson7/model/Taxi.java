package com.epam.maksim_iashkov.java.lesson7.model;

import com.epam.maksim_iashkov.java.lesson7.annotation.AllEnglishChars;
import com.epam.maksim_iashkov.java.lesson7.annotation.IsTransport;
import com.epam.maksim_iashkov.java.lesson7.annotation.NotEmpty;
import com.epam.maksim_iashkov.java.lesson7.annotation.NotNull;

import java.io.Serializable;

@IsTransport
public class Taxi extends Transport implements Serializable {
    @NotNull
    @AllEnglishChars
    private String brand;       //Марка такси
    @NotEmpty
    private String company;     //Компания-владелец ТС

    /**
     * Конструктор для экземпляров такси
     */
    public Taxi(double cost, int passCapacity, double velocity, String brand, String company) {
        super(cost, passCapacity, velocity);
        this.brand = brand;
        this.company = company;
    }

    /*Блок геттеров для приватных переменных класса Такси*/
    public String getBrand() {
        return brand;
    }

    public String getCompany() {
        return company;
    }

    /**
     * Метод для вывода экземпляров Такси не в виде хэша
     */
    @Override
    public String toString() {
        return "Такси. Параметры такси: " +
                "Цена = " + getCost() + " руб" +
                ", Пассажировместимость = " + getPassCapacity() + " чел" +
                ", Скорость = " + getVelocity() + " км/ч" +
                ", Марка машины = " + getBrand() +
                ", Компания = " + getCompany();
    }
}