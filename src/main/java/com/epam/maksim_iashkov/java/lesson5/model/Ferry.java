package com.epam.maksim_iashkov.java.lesson5.model;

/**
 * Класс описания паромов
 */
public class Ferry extends Transport {
    private boolean onStream;   //Признак того, что паром плывет по течению
    private String names;   //Наименование парома

    /**
     * Конструктор для экземпляров паромов
     */
    public Ferry(double cost, int passCapacity, double velocity, boolean onStream, String names) {
        super(cost, passCapacity, velocity);
        this.onStream = onStream;
        this.names = names;
    }

    /*Блок геттеров для приватных переменных класса Паром*/
    public boolean isOnStream() {
        return onStream;
    }

    public String getNames() {
        return names;
    }

    /**
     * Метод для вывода экземпляров Паромов не в виде хэша
     */
    @Override
    public String toString() {
        return "Паром. Параметры парома: " +
                "Цена = " + getCost() + " руб" +
                ", Пассажировместимость = " + getPassCapacity() + " чел" +
                ", Скорость = " + getVelocity() + " км/ч" +
                ", Название парома = " + getNames() +
                ", Ход по течению = " + isOnStream();
    }
}