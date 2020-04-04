package com.epam.maksim_iashkov.java.lesson2.service;
import com.epam.maksim_iashkov.java.lesson2.model.Transport;

/**
 * Класс подсчета общей цены транспортных средств
 */
public class GeneralPrice {

    /**
     * Метод для подсчета суммы цен всех транспортных цен
     */
    public void sumOfCost(Transport[] array) {
        double price = 0.00;

        for (Transport transport : array) {
            price = price + transport.getCost();
        }
        System.out.println("Общая стоимость парка общественного транспорта: " + Math.round(price*100)/100.0 );
    }
}