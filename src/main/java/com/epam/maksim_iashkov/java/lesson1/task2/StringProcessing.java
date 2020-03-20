package com.epam.maksim_iashkov.java.lesson1.task2;
import java.util.Scanner;

/**
 * Класс, реализующий обработку строк
 * @version 19.03.2020
 * @author Maksim_Iashkov
 */
public class StringProcessing {
    public String[] strings;

    /*Конструктор для создания массива, хранящего строки*/
    public StringProcessing() {this.strings = inputStrings();}

    /**Метод для считывания n строк с консоли*/
    private String[] inputStrings() {
        Scanner scanner = new Scanner(System.in); //Объявление переменной сканера
        System.out.println("Введите количество строк: ");
        int n = 0;

        if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n<1) {
                    System.out.print("Введены некорректные данные!"); //Если ввели целое число меньше единицы
                    System.exit(0);
                }
                scanner.nextLine();
        } else {
            System.out.print("Введены некорректные данные!"); //Если ввели не целое число
            System.exit(0);
        }

        String[] strings = new String[n];

        /*Блок ввода строк в массив*/
        for (int i = 0; i < n; i++) {
            System.out.print("Введите строку номер " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }

        /*Блок, убирающий пробелы для всех введенных строк*/
        for (int i=0; i< strings.length; i++) {
            strings[i] = strings[i].replaceAll(" ", "");
        }
        return strings;
    }

    /**Метод определения самых коротких и длинных строк.
    *Если таких несколько - выводится первая встречная самая короткая/длинная строка
    */
    public void shortestAndLongest(){

        System.out.println("----------------------------------------"); //Разделитель между строками и результатом

        String shortest=strings[0];
        String longest=strings[0];

        /*Цикл поиска минимальной строки*/
        for (int i=0; i< strings.length; i++){
            if (strings[i].length() < shortest.length()){
                shortest = strings[i];
            }

        }

        /*Цикл поиска максимальной строки*/
        for (int i=0; i< strings.length; i++){
            if (strings[i].length() > longest.length()){
                longest = strings[i];
            }
        }

        System.out.print("Самая короткая строка: "+shortest+"\n");
        System.out.print("Длина самой короткой строки: "+shortest.length()+"\n");
        System.out.print("Самая длинная строка: "+longest+"\n");
        System.out.print("Длина самой длинной строки: "+longest.length()+"\n");
    }

    /**Метод поиска строк, больших, чем средняя арифметическая длина*/
    public void moreThanAvg() {

        System.out.println("----------------------------------------"); //Разделитель между строками и результатом

        double sum = 0.00;
        double avg = 0.00;

        /*Цикл поиска суммарной длины всех строк*/
        for (int i = 0; i < strings.length; i++) {
            sum = sum + strings[i].length();
        }
        avg = sum / strings.length; //Средняя арифметическая длина строк

        /*Если строка одна - то она не может быть больше средней длины*/
        if (strings.length == 1) {
            System.out.println("Длина строки = средняя длина: "+sum);
            System.out.println("Желаемые строки отсутствуют");
        } else {

            System.out.println("Сумма длинн всех строк: "+sum);
            System.out.println("Средняя длинна: "+avg);

            /*Цикл поиска строк больших, чем средняя длина*/
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].length() > avg) {
                    System.out.print("Строка с длинною больше среднего: " + strings[i] + " Ее длинна: " + strings[i].length() + "\n");
                }
            }
        }
    }

    /**Метод поиска строк, меньших, чем средняя арифметическая длина*/
    public void lessThanAvg() {

        System.out.println("----------------------------------------"); //Разделитель между строками и результатом

        double sum = 0.00;
        double avg = 0.00;

        /*Цикл поиска суммарной длины всех строк*/
        for (int i = 0; i < strings.length; i++) {
            sum = sum + strings[i].length();
        }
        avg = sum / strings.length; //Средняя арифметическая длина строк

        /*Если строка одна - то она не может быть меньше средней длины*/
        if (strings.length == 1) {
            System.out.println("Длина строки = средняя длина: "+sum);
            System.out.println("Желаемые строки отсутствуют");
        } else {

            System.out.println("Сумма длинн всех строк: "+sum);
            System.out.println("Средняя длинна: "+avg);

            /*Цикл поиска строк больших, чем средняя длина*/
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].length() < avg) {
                    System.out.print("Строка с длинною меньше среднего: " + strings[i] + " Ее длинна: " + strings[i].length() + "\n");
                }
            }
        }
    }
}
