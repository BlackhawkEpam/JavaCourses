package com.epam.maksim_iashkov.java.lesson4;

import java.util.Arrays;

/**
 * Создание класса - динамического массива для 1 задачи
 */
@SuppressWarnings("unchecked")
public class DynamicArray<E> {

    //Текущий размер списка элементов
    private int currentSize = 0;
    //Объявление динамического массива
    private Object[] dynArray;

    /**
     * Конструктор массива, в который передается размер и сразу присваивается размеру массива
     */
    public DynamicArray(int size) {
        dynArray = new Object[size];
    }

    /**
     * Метод добавления элемента в конец списка динамического массива
     */
    public void add(E e) {
        //Если длина массива стала не больше размера списка - трансформировать массив
        if (dynArray.length <= currentSize) {
            //Создать временный массив для хранения элементов
            Object[] tmp = dynArray;
            //Увеличить размер массива вдвое
            dynArray = new Object[currentSize * 2];
            //Переписать в новый увеличенный массив элементы перезаписанного из временного массива
            System.arraycopy(tmp, 0, dynArray, 0, tmp.length);
        }
        //Присвоить последнему элементу списка введенное значение
        dynArray[currentSize] = e;
        //Инкрементировать размер списка элементов
        currentSize++;
    }

    /**
     * Метод удаления элемента массива по индексу
     */
    public void remove(int i) {
        try {
            if ((i >= currentSize) || (i < 0)) {
                throw new IndexOutOfBoundsException("Элемент с данным индексом отсутствует в массиве!");
            }
            // Перезаписать всю последовательность массива с i+1 на места, начиная с i-того
            System.arraycopy(dynArray, i + 1, dynArray, i, dynArray.length - 1 - i);
            //Декрементировать размер списка элементов
            currentSize--;
        } catch (IndexOutOfBoundsException ex) {
            //Отловить исключение - если введен отрицательный или несуществующий индекс
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Метод получения элемента по индексу
     */
    public E get(int i) {
        try {
            if ((i >= currentSize) || (i < 0)) {
                throw new IndexOutOfBoundsException("Элемент с данным индексом отсутствует в массиве! Возвращен последний элемент массива");
            }
        } catch (IndexOutOfBoundsException exc) {
            //Отловить исключение - если введенный индекс не существует или отрицательный
            System.out.println(exc.getMessage());
            //В случае исключения - вывести последний элемент
            i = currentSize - 1;
        }
        //Вернуть элемент по индексу
        return (E) dynArray[i];
    }

    /**
     * Метод печати внутреннего состояния массива в консоль
     */
    public String toString() {
        String result = Arrays.toString(dynArray);
        System.out.println("Внутреннее состояние массива: " + result);
        return result;
    }
}