package com.epam.maksim_iashkov.java.lesson5.model;

/**
 * Класс для описания поездов
 */
public class Train extends Transport {
    private String trainCode;   //Цифровой номер поезда, обозначающий его функциональность
    private char railway;       //Буквенный код ж/д узла, с которого стартует поезд

    /**
     * Конструктор для класса поездов
     */
    public Train(double cost, int passCapacity, double velocity, String trainCode, char railway) {
        super(cost, passCapacity, velocity);
        this.trainCode = trainCode;
        this.railway = railway;
    }

    /*Блок геттеров для приватных переменных класса Поезд*/
    public String getTrainCode() {
        return trainCode;
    }

    public char getRailway() {
        return railway;
    }

    /**
     * Метод для вывода экземпляров Поезда не в виде хэша
     */
    @Override
    public String toString() {
        return "Поезд. Параметры поезда: " +
                "Цена = " + getCost() + " руб" +
                ", Пассажировместимость = " + getPassCapacity() + " чел" +
                ", Скорость = " + getVelocity() + " км/ч" +
                ", Код поезда = " + getTrainCode() +
                ", Ж/Д отправления = " + getRailway();
    }
}