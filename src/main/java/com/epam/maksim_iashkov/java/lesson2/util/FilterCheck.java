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
    public int checkIntMin(){
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
    public int checkIntMax(int minValue){
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
    public void checkDoubleMin(double q){
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
    }

    /**
     * Метод проверки максимального вещественного значения диапазона целочисленного параметра
     */
    public void checkDoubleMax(double q, double z){
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
    }

    /**
     * Метод для обработки ответа на запрос о том, будет ли пользователь фильтровать парк ТО по параметру
     */
    public boolean isFilterParamRequired(){
        boolean result = false;

        String answer; //Вводимый ответ в консоль
        answer = scanner.next();
        if(!answer.equals("yes") && !answer.equals("no")) {
            System.out.println("Операция не определена!");
            System.exit(0);
        }
        if (answer.equals("yes")) {
            result = true;
        }
        return result;
    }
}