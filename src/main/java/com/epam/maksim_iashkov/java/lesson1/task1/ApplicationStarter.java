package com.epam.maksim_iashkov.java.lesson1.task1;

/**
 * Класс, реализующий входную точку для запуска программы
 * @version 19.03.2020
 * @author Maksim_Iashkov
 */
public class ApplicationStarter {

    /**Метод main - входная точка программы*/
    public static void main(String[] args) {
        ArrayProcessing arrayProcessing = new ArrayProcessing();
        arrayProcessing.repeatOdd();
        arrayProcessing.evenSum();
        arrayProcessing.swapArray();
        arrayProcessing.deltaAvgMin();
        arrayProcessing.triplePositive();
        arrayProcessing.negativeToZero();
    }
}
