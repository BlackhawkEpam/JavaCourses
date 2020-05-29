package com.epam.maksim_iashkov.java.lesson1;

/**
 * Класс - стартер приложения
 *
 * @author Maksim_Iashkov
 * @version 19.03.2020
 */
public class AppStart {

    /**
     * Метод мэйн - входная точка программы
     */
    public static void main(String[] args) {

        /*Блок задания 1 - массивы*/
        ArrayProcessing arrayProcessing = new ArrayProcessing();    //Создание экземпляра класса ArrayProcessing
        arrayProcessing.repeatOdd();            //Вывести элементы на нечетных позициях, которые встречаются более 1 раза
        arrayProcessing.evenSum();              //Вывод суммы элементов на четных позициях
        arrayProcessing.swapArray();            //Поменять местами максимальный отрицательный и минимальный положительный элементы
        arrayProcessing.deltaAvgMin();          //Разница между средним арифметическим и минимальным элементом
        arrayProcessing.triplePositive();       //Утраивание положительных элементов
        arrayProcessing.negativeToZero();       //Замена отрицательных элементов на нуль

        /*Блок задания 2 - строки и символы*/
        new StringProcessing().shortestAndLongest();    //Поиск самых длинных и коротких строк
        new StringProcessing().moreThanAvg();           //Вывод строк, которые имеют длину больше среднего
        new StringProcessing().lessThanAvg();           //Вывод строк, которые имеют длину меньше среднего
        new WordProcessing().differentSymbols();        //Вывод слова, которое содержит только уникальные символы (первое, если их несколько)
        new WordProcessing().onlyNumbers();             //Вывод слова, которое состоит только из цифр (второе, если их несколько)
        new WordProcessing().minUnique();               //Вывод слова с наименьшим количеством уникальных символов (первое, если их несколько)

        /*Блок задание 3 - калькулятор*/
        CalculateIntNumber calculator = new CalculateIntNumber();
        calculator.startCalculation();      //Вызов метода startCalculation() - которые запускает процесс считывания чисел, операции и вывод результата

    }
}