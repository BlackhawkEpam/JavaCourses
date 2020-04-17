package com.epam.maksim_iashkov.java.lesson2.util;

/**
 * Класс-дублёр обычного Filter-check
 * В методе filterParam сразу задан неверный указанный ответ для генерации исключения, в оригинальном - считывается сканнером с консоли
 */
public class FilterCheckException extends FilterCheck {


    /**
     * Метод для обработки ответа на запрос о том, будет ли пользователь фильтровать парк ТО по параметру
     * В отличие от оригинального метода из FilterCheck - ответ сразу задан строкой-константой для генерации исключения
     */
    @Override
    public boolean isFilterParamRequired(){
        //FIXME: Update with base method logic

//        String implemparam; //Вводимый ответ в консоль
//        implemparam = "no 123"; //Присвоение переменной заранее не валидного ответа
//        System.out.println("Введенный ответ: "+implemparam);
//        if (implemparam.contains(" ")) throw new ProbelsInAnswerException("Вводимый ответ должен быть без пробелов!"); //Условие для генерации исключения
//        if (implemparam.equals("yes")) {
//            flags = false;
//        } else if (implemparam.equals("no")) {
//            flags = true;
//        } else {
//            System.out.println("Операция не определена!");
//            System.exit(0);
//        }
//        return flags;
        return true;
    }
}