package com.epam.maksim_iashkov.java.lesson1.task3;
import java.util.Scanner;

public class CalculateIntNumber {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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
        //System.out.println(num1);
        //System.out.println(num2);
        //System.out.println(operation);
    }

    public double getNumber(){
        System.out.println("Введите целое число в диапазоне от -2147483648 до 2147483647:");
        double num;
        if(scanner.hasNextInt()) {
                num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа! Введите число заново");
            scanner.next();
            num = getNumber();
        }
        return num;
    }

    public char getOperation(){
        System.out.println("Введите операцию (Одним символом: '+' для сложения, '-' для вычитания, '*' для умножения и '/' для деления):");
        char operation;
        scanner.hasNext();
            try {
                operation = scanner.next(".").charAt(0);
            } catch(Exception ex) {
                System.out.println("Введенная операция должна вызываться одним символом! Введите операцию заново");
                scanner.next();
                operation = getOperation();
            }
        return operation;
    }

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
                if (num2 != 0){
                    res = num1/num2;
                } else {
                    System.out.println("На ноль делить нельзя! Введите делитель заново");
                    res = generateCalculation(num1, getNumber(), operation);
                }
                break;
            default:
                System.out.println("Операция не распознана! Введите операцию заново");
                res = generateCalculation(num1, num2, getOperation());
        }
        return res;
    }
}
