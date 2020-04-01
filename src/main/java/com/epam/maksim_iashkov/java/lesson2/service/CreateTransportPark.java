package com.epam.maksim_iashkov.java.lesson2.service;
import com.epam.maksim_iashkov.java.lesson2.model.*;

/**
 * Класс для создания парка общественного транспорта
 */
public class CreateTransportPark {

    /**
     * Метод создания массива транспортных средств
     */
    public Transport[] createPark(){

        /*Создание экземпляров классов из пакета модели*/
        Autobus autobus1 = new Autobus(1000, 3, 80, 50, 100);
        Autobus autobus2 = new Autobus(1500, 3, 90, 60, 180);
        Train train1 = new Train(10000, 0, 400, 100, 3);
        Ferry ferry1 = new Ferry(5000, 2, 100, 40, 4, 1);
        Trolley trolley1 = new Trolley(1200, 0, 70, 50, 5, 200);
        Trolley trolley2 = new Trolley(1300, 0, 60, 50, 4, 250);
        Trolley trolley3 = new Trolley(1350, 0, 50, 50, 2, 175);
        Taxi taxi1 = new Taxi(2000, 3, 3, 60, 5, 0.5);
        Taxi taxi2 = new Taxi(2100, 4, 3, 70, 4, 1);
        Taxi taxi3 = new Taxi(2200, 1, 3, 60, 3, 2);

        /*Сохранение экземпляров классов транспортных средств в массив*/
        Transport park[] = new Transport[10];
        park[0] = autobus1;
        park[1] = autobus2;
        park[2] = train1;
        park[3] = ferry1;
        park[4] = trolley1;
        park[5] = trolley2;
        park[6] = trolley3;
        park[7] = taxi1;
        park[8] = taxi2;
        park[9] = taxi3;

        return park;
    }
}