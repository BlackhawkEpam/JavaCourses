package com.epam.maksim_iashkov.java.lesson2.util;
import java.util.Scanner;

/**
 * Класс для реализации ввода и проверок значений диапазонов поиска
 */
public class FilterCheck {
    Scanner scanner = new Scanner(System.in); //Инициализация сканнера

    /**
     * Метод проверки минимального значения диапазона целочисленного параметра
     */
    public int checkIntMin(int i){
        if (scanner.hasNextInt()) { //Проверка, что в консоль введено именно целочисленное значение
            i = scanner.nextInt();
            if (i<0) {  //Проверка, что нижняя граница диапазона не меньше нуля: стоимость, скорость и т.д. отрицательными быть не могут
                System.out.println("Значение параметра не может быть меньше нуля!");
                System.exit(0);
            }
        } else {
            System.out.println("Введено некорректное значение!");
            System.exit(0);
        }
        return i;
    }

    /**
     * Метод проверки максимального значения диапазона целочисленного параметра
     */
    public int checkIntMax(int i, int j){
        if (scanner.hasNextInt()) {
            i = scanner.nextInt();
        } else {
            System.out.println("Введено некорректное значение!");
            System.exit(0);
        }
        if (i<j) {  //Проверка, что верхняя граница диапазона больше нижней. Обе границы могут быть равны друг другу
            System.out.println("Максимальное значение параметра не может быть меньше минимального!");
            System.exit(0);
        }
        return i;
    }

    /**
     * Метод проверки минимального вещественного значения диапазона целочисленного параметра
     */
    public double checkDoubleMin(double q){
        if (scanner.hasNextDouble()) {
            q = scanner.nextDouble();
            if (q<0) {
                System.out.println("Значение параметра не может быть меньше нуля!");
                System.exit(0);
            }
        } else {
            System.out.println("Введено некорректное значение!");
            System.exit(0);
        }
        return q;
    }

    /**
     * Метод проверки максимального вещественного значения диапазона целочисленного параметра
     */
    public double checkDoubleMax(double q, double z){
        /*Пробовал реализовать разрыв цикла при вводе некорректного значения - не помогло*/
        //outerLoop:
        if (scanner.hasNextDouble()) {
            q = scanner.nextDouble();
        } else {
            System.out.println("Введено некорректное значение!");
            System.exit(0);
            //break outerLoop;
        }
        if (q<z) {
            System.out.println("Максимальное значение параметра не может быть меньше минимального!");
            System.exit(0);
        }
        return q;
    }

    /**
     * Метод для обработки ответа на запрос о том, будет ли пользователь фильтровать парк ТО по параметру
     */
    public boolean filterParam(boolean flags){
        String implemparam; //Вводимый ответ в консоль
        implemparam = scanner.next();
        if (implemparam.equals("yes")) {
            flags = false;
        } else if (implemparam.equals("no")) {
            flags = true;
        } else {
            System.out.println("Операция не определена!");
            System.exit(0);
        }
        return flags;
    }
}