package com.epam.maksim_iashkov.java.lesson2.exception;

import java.io.FileNotFoundException;

/**
 * Пользовательский класс для валидации наличия файла, в котором содержится наименование паромов
 * Checked exception
 * Наследование от класса отсутствия исходого файла
 */
final public class NotFileForAtributeException extends FileNotFoundException {

    public NotFileForAtributeException(String message){
        super(message);
    }
}
