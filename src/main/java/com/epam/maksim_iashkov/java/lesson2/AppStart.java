package com.epam.maksim_iashkov.java.lesson2;
import com.epam.maksim_iashkov.java.lesson2.service.*;

/**
 * Класс для реализации входной точки программы
 * @version 01.04.2020
 * @author Maksim_Iashkov
 */
public class AppStart {

    /**Метод main - входная точка программы*/
    public static void main(String[] args) {

        /*Выполнение методов для ДЗ2*/
        /*Создание экземпляров классов из пакета service*/
        CreateTransportPark createTransportPark = new CreateTransportPark();
        GeneralPrice generalPrice = new GeneralPrice();
        TransportSort transportSort = new TransportSort();
        TransportFilter transportFilter = new TransportFilter();

        generalPrice.sumOfCost(createTransportPark.createPark());   //Подсчёт общей стоимости парка ОТ
        transportSort.fuelFlowSort(createTransportPark.createPark());   //Сортировка парка ОТ по расходу топлива
        transportFilter.filter(createTransportPark.createPark());   //Поиск транспорта по заданным диапазонам параметров

        System.out.println("---------------------------------------------------------------------");    //Разделитель между 2 и 3 ДЗ

        /*Выполнение методов для ДЗ3*/
        /*Создание экземпляров классов-дублёров, где были произведены изменения для генерации эксепшенов*/
        CreateTestSuiteException createTestSuiteException = new CreateTestSuiteException();
        TransportFilterException transportFilterException = new TransportFilterException();

        transportSort.fuelFlowSort(createTestSuiteException.testCase1());   //Генерация эксепшена о некорректно заданной цене транспорта
        System.out.println("---------------------------------------------------------------------");    //Разделитель между тест кейсами
        transportSort.fuelFlowSort(createTestSuiteException.testCase2());   //Генерация эксепшена на нулевую скорость + мультикэтч
        System.out.println("---------------------------------------------------------------------");    //Разделитель между тест кейсами
        createTestSuiteException.testCase3();   //Генерация эксепшена деления на нуль - метод подсчета и вывода приращения расхода топлива
        System.out.println("---------------------------------------------------------------------");    //Разделитель между тест кейсами
        transportSort.fuelFlowSort(CreateTestSuiteException.testCase4());   //Генерация эксепшена об отсутствии файла с наименованием парома
        System.out.println("---------------------------------------------------------------------");    //Разделитель между тест кейсами
        transportFilterException.filter(createTransportPark.createPark());  //Генерация эксепшена на некорректно введенный ответ на вопрос в фильтре

    }
}