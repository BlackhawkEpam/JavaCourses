package com.epam.maksim_iashkov.java.lesson3.util;

import com.epam.maksim_iashkov.java.lesson3.exception.ProbelsInAnswerException;

import java.util.Scanner;

/**
 * Класс для реализации ввода и проверок значений диапазонов поиска
 */
public class FilterCheckException {

    private Scanner scanner;

    public FilterCheckException() {
        this.scanner = new Scanner(System.in);
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

        String answer = "no 123";
        System.out.println("Введенный ответ: " + answer);
        if (answer.contains(" ")) throw new ProbelsInAnswerException("Вводимый ответ должен быть без пробелов!");

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