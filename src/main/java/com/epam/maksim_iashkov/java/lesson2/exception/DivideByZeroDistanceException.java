package com.epam.maksim_iashkov.java.lesson2.exception;

/**
 * Пользовательский класс валидации деления на нулевое расстояние при расчетах параметров
 * Unchecked exception
 * Наследование от класса ошибок арифметических операций
 */
final public class DivideByZeroDistanceException extends  ArithmeticException{

    public DivideByZeroDistanceException(String message){
        super(message);
    }
}
