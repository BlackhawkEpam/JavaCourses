package com.epam.maksim_iashkov.java.lesson4;

import java.util.Arrays;

/**
 * Создание класса - динамического массива для 1 задачи
 */
public class DynamicArray<E> {
    int size;   //Задаваемый размер массива через конструктор
    int currentSize = 0;    //Текущий размер списка элементов

    /**
     * Конструктор массива, в который передается размер и сразу присваивается размеру массива
     */
    public DynamicArray(int size) {
        this.size = size;
        dynArray = new Object[size];
    }

    private Object[] dynArray;  //Объявление динамического массива

    /**
     * Метод добавления элемента в конец списка динамического массива
     */
    public void add(E e) {
        if (dynArray.length <= currentSize) {   //Если длина массива стала не больше размера списка - трансформировать массив
            Object[] tmp = dynArray;    //Создать временный массив для хранения элементов
            dynArray = new Object[currentSize * 2];     //Увеличить размер массива вдвое
            System.arraycopy(tmp, 0, dynArray, 0, tmp.length);  //Переписать в новый увеличенный массив элементы перезаписанного из временного массива
        }
        dynArray[currentSize] = e;  //Присвоить последнему элементу списка введенное значение
        currentSize++;  //Инкрементировать размер списка элементов
    }

    /**
     * Метод удаления элемента массива по индексу
     */
    public void remove(int i) {
        try {
            if ((i >= currentSize) || (i < 0))
                throw new IndexOutOfBoundsException("Элемент с данным индексом отсутствует в массиве!");
            System.arraycopy(dynArray, i + 1, dynArray, i, dynArray.length - 1 - i);    //Перезаписать всю последовательность массива с i+1 на места, начиная с i-того
            currentSize--;  //Декрементировать размер списка элементов
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());    //Отловить исключение - если введен отрицательный или несуществующий индекс
        }
    }

    /**
     * Метод получения элемента по индексу
     */
    @SuppressWarnings("unchecked")
    public E get(int i) {
        try {
            if ((i >= currentSize) || (i < 0))
                throw new IndexOutOfBoundsException("Элемент с данным индексом отсутствует в массиве! Возвращен последний элемент массива");
        } catch (IndexOutOfBoundsException exc) {
            System.out.println(exc.getMessage());   //Отловить исключение - если введенный индекс не существует или отрицательный
            i = currentSize - 1;    //В случае исключения - вывести последний элемент
        }
        return (E) dynArray[i]; //Вернуть элемент по индексу
    }

    /**
     * Метод печати внутреннего состояния массива в консоль
     */
    public void tostring() {
        System.out.println("Внутреннее состояние массива: " + Arrays.toString(dynArray));
    }
}