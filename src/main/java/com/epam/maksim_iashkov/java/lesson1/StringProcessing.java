package com.epam.maksim_iashkov.java.lesson1;

import java.util.Scanner;

/**
 * Класс, реализующий обработку строк
 *
 * @author Maksim_Iashkov
 * @version 19.03.2020
 */
public class StringProcessing {
    public String[] strings;

    /*Конструктор для создания массива, хранящего строки*/
    public StringProcessing() {
        this.strings = inputStrings();
    }

    /**
     * Метод для считывания n строк с консоли
     */
    private String[] inputStrings() {
        Scanner scanner = new Scanner(System.in); //Объявление переменной сканера
        System.out.println("Введите количество строк: ");
        int n;

        if (scanner.hasNextInt()) {             //Проверка вводимого количества строк на целочисленность
            n = scanner.nextInt();          //Считываем количество строк и передаем в n
            if (n < 1) {
                System.out.print("Введены некорректные данные!\n"); //Если ввели целое число меньше единицы
                return null;
            }
            scanner.nextLine();
        } else {
            System.out.print("Введены некорректные данные!\n"); //Если ввели не целое число
            return null;
        }

        String[] strings = new String[n];   //Объявление массива, в котором будут храниться введенные строки

        /*Блок ввода строк в массив*/
        for (int i = 0; i < n; i++) {
            System.out.print("Введите строку номер " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }

        /*Блок, убирающий пробелы для всех введенных строк*/
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].replaceAll(" ", "");
        }
        return strings;
    }

    /**
     * Метод определения самых коротких и длинных строк.
     * Если таких несколько - выводится первая встречная самая короткая/длинная строка
     */
    public void shortestAndLongest() {

        if (strings == null) {      //Проверка, чтобы в string было передано хотя бы что-то
            return;
        }

        System.out.println("----------------------------------------"); //Разделитель между строками и результатом

        String shortest = strings[0];         //Инициализация переменной для хранения самой короткой строки
        String longest = strings[0];          //Инициализация переменной для хранения самой длинной строки

        /*Цикл поиска минимальной строки*/
        for (String string : strings) {
            if (string.length() < shortest.length()) {
                shortest = string;
            }
        }

        /*Цикл поиска максимальной строки*/
        for (String string : strings) {
            if (string.length() > longest.length()) {
                longest = string;
            }
        }

        System.out.print("Самая короткая строка: " + shortest + "\n");
        System.out.print("Длина самой короткой строки: " + shortest.length() + "\n");
        System.out.print("Самая длинная строка: " + longest + "\n");
        System.out.print("Длина самой длинной строки: " + longest.length() + "\n");
    }

    /**
     * Метод поиска строк, больших, чем средняя арифметическая длина
     */
    public void moreThanAvg() {

        if (strings == null) {      //Проверка, чтобы в string было передано хотя бы что-то
            return;
        }

        System.out.println("----------------------------------------"); //Разделитель между строками и результатом

        double sum = 0.00;      //Сумма длин всех строк
        double avg;             //Средняя длина строк

        /*Цикл поиска суммарной длины всех строк*/
        for (String string : strings) {
            sum = sum + string.length();
        }
        avg = sum / strings.length; //Средняя арифметическая длина строк

        if (strings.length == 1) {      //Если строка одна - то она не может быть больше средней длины
            System.out.println("Длина строки = средняя длина: " + sum);
            System.out.println("Желаемые строки отсутствуют");
        } else {
            System.out.println("Сумма длинн всех строк: " + sum);
            System.out.println("Средняя длинна: " + avg);
            for (String string : strings) {         //Цикл поиска строк больших, чем средняя длина
                if (string.length() > avg) {
                    System.out.print("Строка с длинною больше среднего: " + string + " Ее длинна: " + string.length() + "\n");
                }
            }
        }
    }

    /**
     * Метод поиска строк, меньших, чем средняя арифметическая длина
     */
    public void lessThanAvg() {

        if (strings == null) {      //Проверка, чтобы в string было передано хотя бы что-то
            return;
        }

        System.out.println("----------------------------------------"); //Разделитель между строками и результатом

        double sum = 0.00;      //Сумма длин всех строк
        double avg;             //Средняя длина строк

        /*Цикл поиска суммарной длины всех строк*/
        for (String string : strings) {
            sum = sum + string.length();
        }
        avg = sum / strings.length; //Средняя арифметическая длина строк

        if (strings.length == 1) {              //Если строка одна - то она не может быть меньше средней длины
            System.out.println("Длина строки = средняя длина: " + sum);
            System.out.println("Желаемые строки отсутствуют");
        } else {
            System.out.println("Сумма длинн всех строк: " + sum);
            System.out.println("Средняя длинна: " + avg);
            for (String string : strings) {     //Цикл поиска строк больших, чем средняя длина
                if (string.length() < avg) {
                    System.out.print("Строка с длинною меньше среднего: " + string + " Ее длинна: " + string.length() + "\n");
                }
            }
        }
    }
}