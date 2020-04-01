package com.epam.maksim_iashkov.java.lesson2.model;

/**
 * Класс для описания такси
 */
public class Taxi extends Transport implements Incomeable {
    private double money;   //Плата за проезд на такси
    private double times;   //Время такси в пути
    private double acceleration;    //Развиваемое ускорение  автомобилем такси

    /**
     * Конструктор для экземпляров такси
     */
    public Taxi(double cost, int fuelFlow, int passCapacity, double velocity, double times, double acceleration) {
        super(cost, fuelFlow, passCapacity, velocity);
        this.times = times;
        this.acceleration = acceleration;
    }

    /**
     * Метод, реализующий движение такси. Считает скорость такси в начале и под конец маршрута в зависимости от заданного ускорения
     */
    @Override
    public void moving() {
        double v1;
        System.out.println("Такси перемещается по городу");
        System.out.println("Скорость такси в начале маршрута: "+getVelocity());
        v1 = getVelocity() + acceleration*times;
        setVelocity(v1);
        System.out.println("Максимальная скорость такси в конце маршрута: "+getVelocity());
    }

    /**
     * Неиспользуемый метод из родительского абстрактного класса
     */
    @Override
    public void declareStation() {
    }

    /**
     * Метод для описания платы за проезд на такси
     */
    @Override
    public double income() {
        final int RATE = 200;   //Такса - почасовая ставка за проезд
        return money = RATE*times;
    }

    /**
     * Метод для описания ремонта такси. Демонстрация умения работы с сеттерами =)
     */
    public void repairs() {
        System.out.println("В результате ремонта технические характеристики такси улучшились");
        setCost(getCost()*1.10);
        setFuelFlow(getFuelFlow()-1);
        setPassCapacity(getPassCapacity()+1);
        System.out.println("Новая оценочная стоимость автомобиля: "+getCost()+" рублей, Новое потребление топлива: "+getFuelFlow()+" л/ч, Новая пассажировместимость: "+getPassCapacity()+" человек");
    }

    /**
     * Метод для вывода экземпляров Такси не в виде хэша
     */
    @Override
    public String toString() {
        return "Taxi{" +
                "cost=" + getCost() +
                ", fuelFlow=" + getFuelFlow() +
                ", passCapacity=" + getPassCapacity() +
                ", velocity=" + getVelocity() +
                '}';
    }
}