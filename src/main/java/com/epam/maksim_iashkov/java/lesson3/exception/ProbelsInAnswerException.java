package com.epam.maksim_iashkov.java.lesson3.exception;

/**
 * Кастомный класс исключений для выявления пробелов вводимых ответов в консоль для фильтра
 * Unchecked exception
 * Наследование от класса ошибок передачи некорректных аргументов в метод
 */
final public class ProbelsInAnswerException extends IllegalArgumentException {

    public ProbelsInAnswerException(String message) {
        super(message);
    }
}
