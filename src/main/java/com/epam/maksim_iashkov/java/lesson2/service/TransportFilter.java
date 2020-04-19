package com.epam.maksim_iashkov.java.lesson2.service;

import com.epam.maksim_iashkov.java.lesson2.model.Transport;
import com.epam.maksim_iashkov.java.lesson2.util.FilterCheck;

/**
 * Класс реализации поисковых фильтров для объектов-транспортов
 */
public class TransportFilter {

    FilterCheck filterCheck = new FilterCheck();

    boolean isCost;  //Признак необходимости фильтрации парка ОТ по стоимости
    boolean isFuelFlow; //Признак необходимости фильтрации парка ОТ по расходу топлива
    boolean isPassCapacity; //Признак необходимости фильтрации парка ОТ по пассажировместимости
    boolean isVelocity;  //Признак необходимости фильтрации парка ОТ по скорости

    /*Инициализация верхних и нижних границ диапазонов*/
    double minCost = 0.00;   //Нижняя граница вводимой цены
    double maxCost = 0.00;   //Верхняя граница вводимой цены
    int minFuelFlow = 0;    //Нижняя граница вводимого расхода топлива
    int maxFuelFlow = 0;    //Верхняя граница вводимого расхода топлива
    int minPassCapacity = 0;    //Нижняя граница вводимой пассажировместимости
    int maxPassCapacity = 0;    //Верхняя граница вводимой пассажировместимости
    double minVelocity = 0.00;   //Нижняя граница вводимой скорости
    double maxVelocity = 0.00;   //Верхняя граница вводимой скорости

    /**
     * Метод фильтрации транспортных средств по диапазонам параметров
     */
    public void filter(Transport[] array) {
        int count = 0;
        System.out.println("Поиск транспорта по заданному диапазону параметров");

        System.out.println("Фильтровать парк ОТ по цене? yes/no");
        isCost = filterCheck.isFilterParamRequired();
        if (isCost) {
            System.out.println("Введите минимальное значение цены транспорта: ");
            minCost = filterCheck.checkDoubleMin();

            System.out.println("Введите максимальное значение цены транспорта: ");
            maxCost = filterCheck.checkDoubleMax(minCost);
        }

        System.out.println("Фильтровать парк ОТ по расходу топлива? yes/no");
        isFuelFlow = filterCheck.isFilterParamRequired();
        if (isFuelFlow) {
            System.out.println("Введите минимальное значение расхода топлива: ");
            minFuelFlow = filterCheck.checkIntMin();

            System.out.println("Введите максимальное значение расхода топлива: ");
            maxFuelFlow = filterCheck.checkIntMax(minFuelFlow);
        }

        System.out.println("Фильтровать парк ОТ по пассажировместимости? yes/no");
        isPassCapacity = filterCheck.isFilterParamRequired();
        if (isPassCapacity) {
            System.out.println("Введите минимальное значение пассажировместимости: ");
            minPassCapacity = filterCheck.checkIntMin();
            System.out.println("Введите максимальное значение пассажировместимости: ");
            maxPassCapacity = filterCheck.checkIntMax(minPassCapacity);
        }


        System.out.println("Фильтровать парк ОТ по скорости? yes/no");
        isVelocity = filterCheck.isFilterParamRequired();
        if (isVelocity) {
            System.out.println("Введите минимальное значение скорости: ");
            minVelocity = filterCheck.checkDoubleMin();

            System.out.println("Введите максимальное значение скорости: ");
            maxVelocity = filterCheck.checkDoubleMax(minVelocity);
        }

        /*Проверка каждого транспорта из массива на попадание в диапазоны параметров*/
        for (Transport transport : array) {
            if (((!isCost) || ((transport.getCost() >= minCost) && (transport.getCost() <= maxCost))) &&
                    ((!isFuelFlow) || ((transport.getFuelFlow() >= minFuelFlow) && (transport.getFuelFlow() <= maxFuelFlow))) &&
                    ((!isPassCapacity) || ((transport.getPassCapacity() >= minPassCapacity) && (transport.getPassCapacity() <= maxPassCapacity))) &&
                    ((!isVelocity) || ((transport.getVelocity() >= minVelocity) && (transport.getVelocity() <= maxVelocity)))) {
                System.out.println("Искомый транспорт: " + transport);
                count = count + 1;  //Счетчик количества подпадающих под фильтр транспортных средств
            }
        }
        if (count == 0) {   //Если объектов не нашлось - вывести информационное сообщение
            System.out.println("Транспортные средства, подходящие под условия, отсутствуют!");
        }
    }
}