package com.epam.maksim_iashkov.java.lesson3;

import com.epam.maksim_iashkov.java.lesson3.service.CreateTestSuiteException;
import com.epam.maksim_iashkov.java.lesson3.service.TransportFilterException;

public class AppStartException {

    public static void main(String[] args) {

        /*Создание экземпляров класса-генератора тестовых случаев с исключениями*/
        CreateTestSuiteException createTestSuiteException = new CreateTestSuiteException();
        TransportFilterException transportFilterException = new TransportFilterException();

        //Генерация эксепшена о некорректно заданной цене транспорта
        createTestSuiteException.negativePriceCheck();
        //Генерация эксепшена на нулевую скорость + мультикэтч
        createTestSuiteException.zeroVelocityCheck();
        //Генерация эксепшена деления на нуль - метод подсчета и вывода приращения расхода топлива
        createTestSuiteException.divideByZeroCheck();
        //Генерация эксепшена об отсутствии файла с наименованием парома
        createTestSuiteException.noFileExistsCheck();

        //Генерация эксепшена на некорректно введенный ответ на вопрос в фильтре
        transportFilterException.filterException(createTestSuiteException.forFilter());
    }
}
