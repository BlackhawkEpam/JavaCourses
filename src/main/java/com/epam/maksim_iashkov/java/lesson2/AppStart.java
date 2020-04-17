package com.epam.maksim_iashkov.java.lesson2;
import com.epam.maksim_iashkov.java.lesson2.model.Transport;
import com.epam.maksim_iashkov.java.lesson2.service.*;
import com.epam.maksim_iashkov.java.lesson2.util.FilterCheck;
import com.epam.maksim_iashkov.java.lesson2.util.FilterCheckException;

/**
 * Класс для реализации входной точки программы
 * @version 01.04.2020
 * @author Maksim_Iashkov
 */
public class AppStart {

    /**Метод main - входная точка программы*/
    public static void main(String[] args) {

        Transport[] transport = TransportPark.createPark();

        /*Выполнение методов для ДЗ2*/
        /*Создание экземпляров классов из пакета service*/
        GeneralPrice generalPrice = new GeneralPrice();
        TransportSort transportSort = new TransportSort();
        TransportFilter transportFilter = new TransportFilter(new FilterCheck());

        generalPrice.sumOfCost(transport);   //Подсчёт общей стоимости парка ОТ
        transportSort.fuelFlowSort(transport);   //Сортировка парка ОТ по расходу топлива
        transportFilter.filter(transport);   //Поиск транспорта по заданным диапазонам параметров

        System.out.println("---------------------------------------------------------------------");    //Разделитель между 2 и 3 ДЗ

        /*Выполнение методов для ДЗ3*/
        /*Создание экземпляров классов-дублёров, где были произведены изменения для генерации эксепшенов*/
        CreateTestSuiteException createTestSuiteException = new CreateTestSuiteException();

        //Генерация эксепшена о некорректно заданной цене транспорта
        createTestSuiteException.negativePriceCheck();
        //Генерация эксепшена на нулевую скорость + мультикэтч
        createTestSuiteException.zeroVelocityCheck();
        //Генерация эксепшена деления на нуль - метод подсчета и вывода приращения расхода топлива
        createTestSuiteException.divideByZeroCheck();
        //Генерация эксепшена об отсутствии файла с наименованием парома
        createTestSuiteException.noFileExistsCheck();

        //Генерация эксепшена на некорректно введенный ответ на вопрос в фильтре
        transportFilter.setFilterCheck(new FilterCheckException());
        transportFilter.filter(transport);

    }
}