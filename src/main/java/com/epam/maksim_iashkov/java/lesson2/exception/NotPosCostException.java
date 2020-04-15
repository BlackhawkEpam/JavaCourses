package com.epam.maksim_iashkov.java.lesson2.exception;

/**
 * Пользовательский класс для валидации вводимой цены на отрицательные значения
 * Unchecked exception
 * Наследование от класса ошибок арифметических операций
 */
final public class NotPosCostException extends ArithmeticException {
    private double cost;    //Валидируемая цена
    public double getCosts(){return cost;}  //Геттер для валидируемой цены

    public NotPosCostException(String message, double cost){
        super(message);
        this.cost=cost;
    }
}
