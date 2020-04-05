package com.epam.maksim_iashkov.java.lesson2.service;
import com.epam.maksim_iashkov.java.lesson2.model.Transport;
import com.epam.maksim_iashkov.java.lesson2.util.ArrReverse;
import java.util.Arrays;

/**
 * Класс для реализации сортировок массива объектов-транспортов
 */
public class TransportSort {

    /**
     * Метод сортировки массива транспортных средств по расходу топлива
     */
    public void fuelFlowSort(Transport[] array) {
        System.out.println("Сортировка транспортных средств по расходу топлива (по убыванию):");
        Arrays.sort(array); //Сортировка по расходу топлива по возрастанию
        ArrReverse.reverseArray(array); //Инвертирование элементов массива
        for (int j = 0; j < array.length; j++) {
            System.out.println("Транспортное средство №" + (j + 1) + ": " + array[j]); //Вывод транспортных средств в консоль
        }
    }
}