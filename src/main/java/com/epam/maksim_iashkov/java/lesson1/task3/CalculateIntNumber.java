package com.epam.maksim_iashkov.java.lesson1.task3;
import java.util.Scanner;

/**
 * Класс, реализующий вычисление двух целых чисел
 * @version 19.03.2020
 * @author Maksim_Iashkov
 */
public class CalculateIntNumber {

    Scanner scanner = new Scanner(System.in); //Объявление переменной для сканера

    /**
     *Метод main - входная точка программы
     */
    public static void main(String[] args) {

        /*Инициализация глобальных переменных*/
        double num1 = 0.00;
        double num2 = 0.00;
        char operation = ' ';
        double res = 0.00;

        CalculateIntNumber calculateIntNumber = new CalculateIntNumber();

        System.out.println("Калькулятор для расчета действий над двумя целыми числами");
        num1 = calculateIntNumber.getNumber();
        num2 = calculateIntNumber.getNumber();
        operation = calculateIntNumber.getOperation();
        res = calculateIntNumber.generateCalculation(num1,num2,operation);
        System.out.println("Результат операции: "+res);
    }

    /**
     *Метод считывания числа из консоли
     */
    public double getNumber(){
        System.out.println("Введите целое число в диапазоне от -2147483648 до 2147483647:");
        double num = 0.0;

        if(scanner.hasNextInt()) {          //Проверка введенное числа на целочисленность
                num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа! Введите число заново");
            scanner.next();
            num = getNumber();          //Если допущена ошибка при вводе числа - заново позволить ввести число
        }
        return num;
    }

    /**
     *Метод считывания операции из консоли
     */
    public char getOperation(){
        System.out.println("Введите операцию (Одним символом: '+' для сложения, '-' для вычитания, '*' для умножения и '/' для деления):");
        char operation;

        scanner.hasNext();
            try {
                operation = scanner.next(".").charAt(0);        //Считывание операции, которая должна уложиться в 1 символ
            } catch(Exception ex) {
                System.out.println("Введенная операция должна вызываться одним символом! Введите операцию заново");
                scanner.next();
                operation = getOperation();     //В случае срабатывания исключения - заново позволить ввести операцию
            }
        return operation;
    }

    /**
     *Метод реализации вычисления операции над двумя числами
     */
    public double generateCalculation(double num1,double num2,char operation){
        double res;
        switch (operation) {
            case '+':
                res = num1+num2;
                break;
            case '-':
                res = num1-num2;
                break;
            case '*':
                res = num1*num2;
                break;
            case '/':
                if (num2 != 0){         //Проверка деления на нуль
                    res = num1/num2;
                } else {
                    System.out.println("На ноль делить нельзя! Введите делитель заново");
                    res = generateCalculation(num1, getNumber(), operation);    //Если второе число при делении нуль - позволить заново ввести делитель
                }
                break;
            default:
                System.out.println("Операция не распознана! Введите операцию заново");
                res = generateCalculation(num1, num2, getOperation());  //Если в блоке считывания операции был введен один неопознанный символ
        }
        return res;
    }
}
