package com.epam.maksim_iashkov.java.lesson1;

import java.util.Arrays;

/**
 * Класс, реализующий обработку массивов
 *
 * @author Maksim_Iashkov
 * @version 19.03.2020
 */
public class ArrayProcessing {
    private int[] array;        //Инициализация массива

    /*Конструктор для создания массива*/
    public ArrayProcessing() {
        this.array = createArray();
    }

    /**
     * Метод создания массива с рандомными 20 элементами от -10 до 10
     */
    private int[] createArray() {
        int[] mas1 = new int[20];   //Объявление массива с 20 элементами

        System.out.println("Исходный массив:");

        /*Цикл заполнения массива 20 рандомными целыми числами*/
        for (int i = 0; i < mas1.length; i++) {
            mas1[i] = ((int) (Math.random() * 21) - 10);
        }
        System.out.println(Arrays.toString(mas1));      //Показать исходный массив в консоли
        return mas1;
    }

    /**
     * Метод замены отрицательных элементов массива на нуль
     */
    public void negativeToZero() {

        System.out.println("----------------------------------------"); //Разделитель для массивов
        System.out.println("Замена отрицательных элементов нулями:");

        for (int j = 0; j < array.length; j++) {
            if (array[j] < 0) {
                array[j] = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Метод утраивания положительных элементов массива, стоящих перед отрицательными
     */
    public void triplePositive() {

        System.out.println("----------------------------------------"); //Разделитель для массивов
        System.out.println("Утраивание положительных элементов, стоящих перед отрицательными:");

        for (int j = 0; j < array.length - 1; j++) {
            if ((array[j] > 0) & (array[j + 1] < 0)) {
                array[j] = array[j] * 3;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Метод подсчета суммы элементов массива с четными индексами
     */
    public void evenSum() {

        System.out.println("----------------------------------------"); //Разделитель между массивом и суммой

        int sum = 0;    //Инициация и обнуление счетчика суммы
        for (int j = 0; j < array.length; j++) {
            if (j % 2 == 0) {
                sum = sum + array[j];
            }

        }
        System.out.println("Сумма элементов, стоящих на четных позициях: " + sum);
    }

    /**
     * Метод вывода всех повторяющихся элементов с нечетными индексами
     */
    public void repeatOdd() {

        System.out.println("----------------------------------------"); //Разделитель для массива и искомых элементов
        System.out.println("Повторяющиеся элементы с нечетными индексами:");

        for (int j = 0; j < array.length; j++) {
            int count = 0;  //Инициация и обнуление счетчика того, сколько раз элемент встречается в массиве
            for (int i : array) {
                if (array[j] == i) {
                    count++;    //Увеличение счетчика на 1, если элемент встретился в массиве
                }
            }
            /*Если элемент встретился в массиве больше 1 раза (не только повторился сам с собой),
             * и имеет нечетный индекс - вывести его в консоль
             */
            if ((count > 1) & (j % 2 != 0)) {
                System.out.println(array[j]);
            }
        }
    }

    /**
     * Метод замены первых встречных максимального отрицательного и минимального положительного элементов
     */
    public void swapArray() {

        System.out.println("----------------------------------------"); //Разделитель для массивов
        System.out.println("Замена позиций максимального отрицательного и минимального положительного:");

        int PosMinIndex = 0;        //Индекс минимального положительного
        int NegMaxIndex = 0;        //Индекс максимального отрицательного

        for (int j = 0; j < array.length; j++) {
            if (array[j] < 0) {     //Отбор максимального отрицательного элемента
                if (array[j] > array[NegMaxIndex]) {
                    NegMaxIndex = j;
                }
                if (array[NegMaxIndex] >= 0) {   //Если элемент с начальным индексом не отрицательный - присвоить индекс искомого следующему элементу
                    NegMaxIndex = j;
                }
            } else if (array[j] > 0) {        //Отбор минимального положительного элемента
                if (array[j] < array[PosMinIndex]) {
                    PosMinIndex = j;
                }
                if (array[PosMinIndex] <= 0) {   //Если элемент с начальным индексом не положительный - присвоить индекс искомого следующему элементу
                    PosMinIndex = j;
                }
            }
        }

        /*Блок замены искомых элементов*/
        int temp = array[NegMaxIndex];
        array[NegMaxIndex] = array[PosMinIndex];
        array[PosMinIndex] = temp;
        System.out.println(Arrays.toString(array));
    }

    /**
     * Метод поиска разницы между минимальным элементом и средним арифметическим элементов массива
     */
    public void deltaAvgMin() {

        System.out.println("----------------------------------------"); //Разделитель между массивом и разницей

        float sum = 0.00f;      //Сумма всех элементов
        float avg;              //Среднее арифметическое
        float res;              //Искомый результат
        int min = array[0];     //Инициализация минимального элемента

        /*Поиск суммы всех элементов массива и минимального элемента*/
        for (int i : array) {
            if (i < min) {
                min = i;     //Поиск минимального элемента
            }
            sum = sum + i;   //В этом же цикле считаем сумму элементов
        }

        avg = sum / (array.length);     //Среднее арифметическое
        res = avg - min;                //Искомая разница

        System.out.println("Сумма всех элементов равна: " + sum);
        System.out.println("Среднее значение элементов массива: " + avg);
        System.out.println("Разница между средним арифметическим и минимальным элементом: " + res);
    }
}