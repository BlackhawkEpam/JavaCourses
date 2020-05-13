package com.epam.maksim_iashkov.java.lesson5;

import com.epam.maksim_iashkov.java.lesson5.model.Transport;

import java.util.ArrayList;

/**
 * Класс AppStart - Входная точка программы
 */
public class AppStart {

    /**
     * Метод main
     */
    public static void main(String[] args) {

        DiskAnalyzer analyzer = new DiskAnalyzer();                         //Создание экземпляра класса утилиты DiskAnalyzer
        ModelSerialization serialization = new ModelSerialization();        //Создание экземпляра класса ModelSerialization

        ArrayList<Transport> park = serialization.createPark();             //Создание экземпляров классов ТС и упаковка их в ArrayList
        String filename = serialization.serializePark(park);                //Сериализация АррэйЛиста, созданного ранее
        serialization.deserializePark(filename);                            //Десериализация списка ТС из файла, созданного ранее

        analyzer.startAnalyze();                                            //Обращение к методу вызова утилиты DiskAnalyzer

    }
}