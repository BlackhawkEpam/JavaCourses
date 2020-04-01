package com.epam.maksim_iashkov.java.lesson2.model;

/**
 * Класс для описания автобусов
 */
public class Autobus extends Transport {
    private double distance;    //Пройденная автобусом дистанция
    private int freePlace;  //Количество свободных мест в автобусе

    /**
     * Конструктор для экземпляров автобусов
     */
    public Autobus(double cost, int fuelFlow, int passCapacity, double velocity, double distance) {
        super(cost, fuelFlow, passCapacity, velocity);
        this.distance = distance;
    }

    /**
     * Метод, описывающий движение автобуса по городу - считает время автобуса в пути
     */
    @Override
    public void moving() {
        System.out.println("Автобус перемещается по городу");
        double times;
        times = distance/getVelocity();
        System.out.println("Время передвижения автобуса до следующей остановки: "+times+" ч");
    }

    /**
     * Метод для объявления автобусных остановок
     */
    @Override
    public void declareStation() {
        System.out.println("Осторожно, двери закрываются! Автобус следует до следующей станции");
    }

    /**
     * Метод для подсчета количества занятых и свободных мест - и вывода их на экран монитора в автобусе =)
     */
    public void freePlace(int passanger) {
        if (passanger >= getPassCapacity()) {   //Если количество пассажиров на остановке больше, чем вместимость автобуса
            freePlace = 0;
            System.out.println("Количество свободных мест: "+freePlace);
            System.out.println("Количество занятых мест: "+getPassCapacity());
        } else {    //Если все пассажиры с остановки могут влезть в автобус
            freePlace = getPassCapacity() - passanger;
            System.out.println("Количество свободных мест: "+freePlace);
            System.out.println("Количество занятых мест: "+passanger);
        }
    }

    /**
     * Метод для вывода экземпляров Автобусов не в виде хэша
     */
    @Override
    public String toString() {
        return "Autobus{" +
                "cost=" + getCost() +
                ", fuelFlow=" + getFuelFlow() +
                ", passCapacity=" + getPassCapacity() +
                ", velocity=" + getVelocity() +
                '}';
    }
}