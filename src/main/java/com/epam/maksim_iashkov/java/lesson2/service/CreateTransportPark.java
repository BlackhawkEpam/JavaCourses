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
        Autobus autobus1 = new Autobus(1000, 3, 80, 50, 1000);
        Autobus autobus2 = new Autobus(1500, 4, 90, 60, 1200);
        Train train1 = new Train(10000, 0, 400, 100, 6, 1);
        Ferry ferry1 = new Ferry(5000, 2, 100, 40, 5, true);
        Trolley trolley1 = new Trolley(1200, 0, 70, 50, 110, 5);
        Trolley trolley2 = new Trolley(1300, 0, 60, 50, 70, 4);
        Trolley trolley3 = new Trolley(1350, 0, 50, 50, 130, 6);
        Taxi taxi1 = new Taxi(2000, 3, 3, 60, 5, 1);
        Taxi taxi2 = new Taxi(2100, 4, 3, 70, 4, 1.5);
        Taxi taxi3 = new Taxi(2200, 2, 3, 60, 3, 1.75);

        /*Применение методов интерфейса Repairable*/
        taxi1.repair();
        taxi2.repair();
        taxi3.repair();
        train1.repair();

        /*Сохранение экземпляров классов транспортных средств в массив*/
        Transport[] park = new Transport[10];
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

        /*Вызов родительских методов для транспортных средств*/
        for (Transport transport : park) {
            transport.addVelocity();
            transport.mileage();
        }

        return park;
    }
}