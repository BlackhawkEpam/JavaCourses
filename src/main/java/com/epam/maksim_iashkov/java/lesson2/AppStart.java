package com.epam.maksim_iashkov.java.lesson2;

import com.epam.maksim_iashkov.java.lesson2.model.Transport;
import com.epam.maksim_iashkov.java.lesson2.service.*;

/**
 * Класс для реализации входной точки программы
 *
 * @author Maksim_Iashkov
 * @version 01.04.2020
 */
public class AppStart {

    /**
     * Метод main - входная точка программы
     */
    public static void main(String[] args) {

        Transport[] transport = TransportPark.createPark();

        /*Выполнение методов для ДЗ2*/
        /*Создание экземпляров классов из пакета service*/
        GeneralPrice generalPrice = new GeneralPrice();
        TransportSort transportSort = new TransportSort();
        TransportFilter transportFilter = new TransportFilter();

        generalPrice.sumOfCost(transport);   //Подсчёт общей стоимости парка ОТ
        transportSort.fuelFlowSort(transport);   //Сортировка парка ОТ по расходу топлива
        transportFilter.filter(transport);   //Поиск транспорта по заданным диапазонам параметров

    }
}