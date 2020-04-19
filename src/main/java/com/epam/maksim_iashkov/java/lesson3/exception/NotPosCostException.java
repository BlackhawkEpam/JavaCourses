package com.epam.maksim_iashkov.java.lesson3.exception;

/**
 * Пользовательский класс для валидации вводимой цены на отрицательные значения
 * Unchecked exception
 * Наследование от класса ошибок арифметических операций
 */
final public class NotPosCostException extends ArithmeticException {
    private double cost;    //Валидируемая цена

    //Геттер для валидируемой цены
    public double getCosts() {
        return cost;
    }

    public NotPosCostException(String message, double cost) {
        super(message);
        this.cost = cost;
    }
}
