package com.epam.maksim_iashkov.java.lesson3.exception;

/**
 * Пользовательский класс для валидации вводимой скорости на неположительные значения
 * Unchecked exception
 * Наследование от класса ошибок арифметических операций
 */
final public class NotPosVelocityException extends ArithmeticException {
    private double velocity;    //Валидируемая скорость

    //Геттер для параметра скорости
    public double getVelocity() {
        return velocity;
    }

    public NotPosVelocityException(String message, double velocity) {
        super(message);
        this.velocity = velocity;
    }
}
