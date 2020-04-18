package com.epam.maksim_iashkov.java.lesson3.service;

import com.epam.maksim_iashkov.java.lesson2.model.Transport;
import com.epam.maksim_iashkov.java.lesson3.exception.ProbelsInAnswerException;
import com.epam.maksim_iashkov.java.lesson3.util.FilterCheckException;

/**
 * Класс реализации поисковых фильтров для объектов-транспортов
 */
public class TransportFilterException {

    FilterCheckException filterCheckException = new FilterCheckException();

    boolean isCost;  //Признак необходимости фильтрации парка ОТ по стоимости

    /*Инициализация верхних и нижних границ диапазонов*/
    double minCost = 0.00;   //Нижняя граница вводимой цены
    double maxCost = 0.00;   //Верхняя граница вводимой цены

    /**
     * Метод фильтрации транспортных средств по диапазонам параметров
     */
    public void filterException(Transport[] array) {
        int count = 0;
        System.out.println("Поиск транспорта по заданному диапазону параметров");

        System.out.println("Фильтровать парк ОТ по цене? yes/no");
        try {
            isCost = filterCheckException.isFilterParamRequired();
        } catch (ProbelsInAnswerException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Конец обработки эксепшена 5 кейса");
        }

        if (isCost) {
            System.out.println("Введите минимальное значение цены транспорта: ");
            minCost = filterCheckException.checkDoubleMin();

            System.out.println("Введите максимальное значение цены транспорта: ");
            maxCost = filterCheckException.checkDoubleMax(minCost);
        }

        /*Проверка каждого транспорта из массива на попадание в диапазоны параметров*/
        for (Transport transport : array) {
            if (((!isCost) || ((transport.getCost() >= minCost) && (transport.getCost() <= maxCost)))) {
                System.out.println("Искомый транспорт: " + transport);
                count = count + 1;  //Счетчик количества подпадающих под фильтр транспортных средств
            }
        }
        if (count == 0) {   //Если объектов не нашлось - вывести информационное сообщение
            System.out.println("Транспортные средства, подходящие под условия, отсутствуют!");
        }
    }
}