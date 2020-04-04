package com.epam.maksim_iashkov.java.lesson2;
import com.epam.maksim_iashkov.java.lesson2.service.CreateTransportPark;
import com.epam.maksim_iashkov.java.lesson2.service.GeneralPrice;
import com.epam.maksim_iashkov.java.lesson2.service.TransportFilter;
import com.epam.maksim_iashkov.java.lesson2.service.TransportSort;

/**
 * Класс для реализации входной точки программы
 * @version 01.04.2020
 * @author Maksim_Iashkov
 */
public class AppStart {

    /**Метод main - входная точка программы*/
    public static void main(String[] args){

        /*Создание экземпляров классов из пакета service*/
        CreateTransportPark createTransportPark = new CreateTransportPark();
        GeneralPrice generalPrice = new GeneralPrice();
        TransportSort transportSort = new TransportSort();
        TransportFilter transportFilter = new TransportFilter();

        generalPrice.sumOfCost(createTransportPark.createPark());   //Подсчёт общей стоимости парка ОТ
        transportSort.fuelFlowSort(createTransportPark.createPark());   //Сортировка парка ОТ по расходу топлива
        transportFilter.filter(createTransportPark.createPark());   //Поиск транспорта по заданным диапазонам параметров
    }
}