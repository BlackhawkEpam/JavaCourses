package com.epam.maksim_iashkov.java.lesson2.util;
import com.epam.maksim_iashkov.java.lesson2.model.Transport;

/**
 * Вспомогательный класс для реализации инвертирования массива
 */
public class ArrReverse {

    /**
     *Метод для инвертирования элементов массива
     */
    public static void reverseArray(Transport[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            Transport temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
}