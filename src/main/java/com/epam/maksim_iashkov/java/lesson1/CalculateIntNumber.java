package com.epam.maksim_iashkov.java.lesson1;

import java.util.Scanner;

/**
 * Класс, реализующий вычисление двух целых чисел
 *
 * @author Maksim_Iashkov
 * @version 19.03.2020
 */
public class CalculateIntNumber {

    Scanner scanner = new Scanner(System.in); //Объявление переменной для сканера

    /**
     * Класс для считывания двух чисел, операции и выдачи итогового результата
     */
    public void startCalculation() {

        Double num1;            //Вводимое 1 число
        Double num2;            //Вводимое 2 число
        Character operation;    //Вводимая операция
        Double res;             //Результат

        System.out.println("Калькулятор для расчета действий над двумя целыми числами");
        num1 = getNumber();     //Считываем с консоли 1 число
        if (num1 == null) {
            return;
        }
        num2 = getNumber();     //Считываем с консоли 2 число
        if (num2 == null) {
            return;
        }
        operation = getOperation();     //Считываем с консоли операцию
        if (operation == null) {
            return;
        }
        res = generateCalculation(num1, num2, operation);     //Считаем результат и кладём его в res
        if (res == null) {
            return;
        }
        System.out.println("Результат операции: " + res);     //Выводим результат в консоль
    }

    /**
     * Метод считывания числа из консоли
     */
    public Double getNumber() {
        System.out.println("Введите целое число в диапазоне от -2147483648 до 2147483647:");
        double num;

        if (scanner.hasNextInt()) {          //Проверка введенное числа на целочисленность
            num = scanner.nextInt();    //Считывание числа с консоли и передача ее в num
        } else {
            System.out.println("Вы допустили ошибку при вводе числа!");
            return null;
        }
        return num;
    }

    /**
     * Метод считывания операции из консоли
     */
    public Character getOperation() {
        System.out.println("Введите операцию (Одним символом: '+' для сложения, '-' для вычитания, '*' для умножения и '/' для деления):");
        char operation;

        try {
            operation = scanner.next(".").charAt(0);        //Считывание операции, которая должна уложиться в 1 символ
        } catch (Exception ex) {
            System.out.println("Введенная операция должна вызываться одним символом!");
            return null;
        }
        return operation;
    }

    /**
     * Метод реализации вычисления операции над двумя числами
     */
    public Double generateCalculation(double num1, double num2, char operation) {
        double res;
        switch (operation) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {         //Проверка деления на нуль
                    res = num1 / num2;
                } else {
                    System.out.println("На ноль делить нельзя!");
                    return null;
                }
                break;
            default:
                System.out.println("Операция не распознана!");
                return null;
        }
        return res;
    }
}