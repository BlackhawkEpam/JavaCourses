package com.epam.maksim_iashkov.java.lesson2.util;

import java.util.Scanner;

/**
 * Класс для реализации ввода и проверок значений диапазонов поиска
 */
public class FilterCheck {

    private Scanner scanner;

    public FilterCheck() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Метод проверки минимального значения диапазона целочисленного параметра
     */
    public int checkIntMin() {
        int minValue = 0;
        if (scanner.hasNextInt()) { //Проверка, что в консоль введено именно целочисленное значение
            minValue = scanner.nextInt();
            if (minValue < 0) {  //Проверка, что нижняя граница диапазона не меньше нуля: стоимость, скорость и т.д. отрицательными быть не могут
                System.out.println("Значение параметра не может быть меньше нуля!");
                System.exit(0);
            }
        } else {
            System.out.println("Введено некорректное значение!");
            System.exit(0);
        }
        return minValue;
    }

    /**
     * Метод проверки максимального значения диапазона целочисленного параметра
     */
    public int checkIntMax(int minValue) {
        int maxValue = 0;
        if (scanner.hasNextInt()) {
            maxValue = scanner.nextInt();
        } else {
            System.out.println("Введено некорректное значение!");
            System.exit(0);
        }
        if (maxValue < minValue) {  //Проверка, что верхняя граница диапазона больше нижней. Обе границы могут быть равны друг другу
            System.out.println("Максимальное значение параметра не может быть меньше минимального!");
            System.exit(0);
        }
        return maxValue;
    }

    /**
     * Метод проверки минимального вещественного значения диапазона целочисленного параметра
     */
    public double checkDoubleMin() {
        double minValue = 0;
        if (scanner.hasNextDouble()) {
            minValue = scanner.nextDouble();
            if (minValue < 0) {
                System.out.println("Значение параметра не может быть меньше нуля!");
                System.exit(0);
            }
        } else {
            System.out.println("Введено некорректное значение!");
            System.exit(0);
        }
        return minValue;
    }

    /**
     * Метод проверки максимального вещественного значения диапазона целочисленного параметра
     */
    public double checkDoubleMax(double minValue) {
        double maxValue = 0;
        if (scanner.hasNextDouble()) {
            maxValue = scanner.nextDouble();
        } else {
            System.out.println("Введено некорректное значение!");
            System.exit(0);
        }
        if (maxValue < minValue) {  //Проверка, что верхняя граница диапазона больше нижней. Обе границы могут быть равны друг другу
            System.out.println("Максимальное значение параметра не может быть меньше минимального!");
            System.exit(0);
        }
        return maxValue;
    }

    /**
     * Метод для обработки ответа на запрос о том, будет ли пользователь фильтровать парк ТО по параметру
     */
    public boolean isFilterParamRequired() {
        boolean result = false;

        String answer; //Вводимый ответ в консоль
        answer = scanner.next();
        if (!answer.equals("yes") && !answer.equals("no")) {
            System.out.println("Операция не определена!");
            System.exit(0);
        }
        if (answer.equals("yes")) {
            result = true;
        }
        return result;
    }
}