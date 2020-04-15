package com.epam.maksim_iashkov.java.lesson2.exception;

/**
 * Пользовательский класс для валидации вводимой скорости на неположительные значения
 * Unchecked exception
 * Наследование от класса ошибок арифметических операций
 */
final public class NotPosVelocityException extends ArithmeticException{
    private double velocity;    //Валидируемая скорость
    public double getVelocity(){return velocity;}   //Геттер для параметра скорости

    public NotPosVelocityException(String message, double velocity){
        super(message);
        this.velocity=velocity;
    }
}
