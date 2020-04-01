package com.epam.maksim_iashkov.java.lesson2.service;
import com.epam.maksim_iashkov.java.lesson2.model.Transport;
import com.epam.maksim_iashkov.java.lesson2.util.ArrReverse;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Класс для реализации сортировок массива объектов-транспортов
 */
public class TransportSort {
    Scanner scanner = new Scanner(System.in); //Инициализация сканнера

    /**
     * Метод сортировки массива транспортных средств по расходу топлива
     */
    public void fuelFlowSort(Transport[] array) {
        System.out.println("Сортировка транспортных средств по расходу топлива");
        System.out.println("Введите направление сортировки: 1 - по возрастанию или 2 - по убыванию: ");
        int n;
        if (scanner.hasNextInt()) { //Проверка, что вводится целое цисло
            n = scanner.nextInt();
            if (n == 1) {   //Сортировка по возрастанию
                Arrays.sort(array);
                for (int j=0; j<array.length; j++) {
                    System.out.println("Транспортное средство №"+(j+1)+" : " + array[j]);
                }
            } else if (n == 2) {    //Сортировка по убыванию
                Arrays.sort(array);
                ArrReverse.reverseArray(array); //Инвертирование элементов массива
                for (int j=0; j<array.length; j++) {
                    System.out.println("Транспортное средство №"+(j+1)+" : " + array[j]);
                }
            } else {    //Если введено целое число, не равное 1 или 2
                System.out.println("Направление определено неверно!");
            }
        } else {    //Если введено не целое число
            System.out.println("Направление определено неверно!");
        }
    }
}