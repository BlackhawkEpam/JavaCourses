package com.epam.maksim_iashkov.java.lesson1.task1;

import java.lang.reflect.Array;

/*
 *Яшков Максим Петрович
 * Задание номер 1
 * Вариант номер 3
 */
public class ReplaceNegativeToZero {
    private int[] array;

    public ReplaceNegativeToZero() {
        this.array = createArray();
    }

    /**
     * клевый метод
     */
    private int[] createArray() {
        int[] mas1;
        mas1 = new int[20];

        for (int i = 0; i < mas1.length; i++) {
            mas1[i] = ((int) (Math.random() * 21) - 10);
            System.out.println(mas1[i]);    //Вывод в консоль
        }
        return mas1;
    }

    public void replaceInArray() {

        System.out.println("----------------------------------------"); //Разделитель для массивов

        /*
         *Цикл для проверки элементов массива:
         *если элемент с текущим индексом меньше 0, то присвоить ему значение 0

         */
        for (int j = 0; j < array.length; j++) {
            if (array[j] < 0) {
                array[j] = 0;
            }
            System.out.println(array[j]);    //Вывод в консоль искомого массива
        }
    }


    public void triplePositive() {

        System.out.println("----------------------------------------"); //Разделитель для массивов

        for (int j = 0; j < array.length - 1; j++) {
            if ((array[j] > 0) & (array[j + 1] < 0)) {
                array[j] = array[j] * 3;
            }
            System.out.println(array[j]);
        }
        System.out.println(array[array.length - 1]);
    }


    public void evenSum() {

        System.out.println("----------------------------------------"); //Разделитель для массивов
        int sum = 0;

        for (int j = 0; j < array.length; j++) {
            if (j % 2 == 0) {
                sum = sum + array[j];
            }

        }
        System.out.println(sum);
    }


    public void repeatOdd() {

        System.out.println("----------------------------------------"); //Разделитель для массивов

        for (int j = 0; j < array.length; j++) {
            int count = 0;
            for (int k = 0; k < array.length; k++) {
                if (array[j] == array[k]) {
                    count++;
                }
            }
                if ((count > 1)&(j % 2 != 0)){
                    System.out.println(array[j]);}

        }
    }

    public void swapArray() {

        System.out.println("----------------------------------------"); //Разделитель для массивов

        int PosMin = 0;
        int NegMax = 0;
        int PosMinIndex = 0;
        int NegMaxIndex = 0;

        for (int j = 0; j < array.length; j++) {
            if (array[j] < 0) {
                if (array[j] > array[NegMaxIndex]){
                    NegMaxIndex = j;}
                //if (array[NegMaxIndex] >= 0)
                    //NegMaxIndex = j;
            }
            else if (array[j] > 0) {
                if (array[j] < array[PosMinIndex]){
                    PosMinIndex = j;}
                //if (array[PosMinIndex] <= 0)
                   // PosMinIndex = j;
            }


        }

        int temp = array[NegMaxIndex];
        array[NegMaxIndex] = array[PosMinIndex];
        array[PosMinIndex] = temp;

        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }

    }

    public void deltaAvgMin() {

        System.out.println("----------------------------------------"); //Разделитель для массивов

        float sum = 0.00f;
        float avg = 0.00f;
        float res = 0.00f;
        int min = array[0];

        for (int j = 0; j < array.length; j++) {
            if (array[j] < min)
                min = array[j];
        }

        for (int j = 0; j < array.length; j++) {
            sum = sum + array[j];
        }
        avg = sum / (array.length);
        res = avg - min;

        System.out.println(res);

    }
}