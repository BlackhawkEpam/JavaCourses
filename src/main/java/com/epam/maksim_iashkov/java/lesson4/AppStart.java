package com.epam.maksim_iashkov.java.lesson4;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс AppStart - Входная точка программы
 */
public class AppStart {

    public static void main(String[] args) {

        /*Задача 2 - выполненная на ArrayList*/
        CollectionsInt collectionsInt = new CollectionsInt();   //Создание экземпляра CollectionsInt

        ArrayList<Integer> aList = collectionsInt.createCollections();   //Создание миллиона последовательных целых чисел
        ArrayList<Integer> aList1;   //Коллекция для хранения нового списка только четных чисел

        collectionsInt.shuffleCollections(aList);    //Перемешать последовательность чисел и показать это
        collectionsInt.checkUnic(aList);             //Показать уникальность всех элементов последовательности
        collectionsInt.findMin(aList);               //Найти минимальный элемент последовательности
        aList1 = collectionsInt.onlyEven(aList);     //Удаление всех нечетных элементов и сохранение в другую коллекцию
        collectionsInt.findPrelast(aList1);          //Найти предпоследний по величине элемент

        /*Задача 2 - выполненная на Stream API*/
        StreamAPIInt streamAPIInt = new StreamAPIInt(); //Создание экземпляра StreamAPIInt

        List<Integer> list1 = streamAPIInt.createStream();  //Создание миллиона последовательных целых чисел
        List<Integer> list2;    //Коллекция для хранения списка перемешанных чисел
        List<Integer> list3;    //Коллекция для хранения списка четных чисел

        list2 = streamAPIInt.shuffleStream(list1);      //Рандомизация списка и доказательство этого факта
        streamAPIInt.uniqueStream(list2);               //Доказательство уникальности всех элементов последовательности
        streamAPIInt.findMin(list2);                    //Найти минимальный элемент последовательности
        list3 = streamAPIInt.onlyEvenStream(list2);     //Удаление всех нечетных элементов
        streamAPIInt.findPreLast(list3);                //Найти предпоследний по величине элемент

        /*Задача 1 - создание динамического массива*/
        DynamicArray<Integer> array = new DynamicArray<>(4);    //Создание массива целых чисел с размером = 4

        array.add(5);           //Добавление трех элементов поочередно в конец списка
        array.add(8);
        array.add(9);

        array.remove(1);    //Удаление элемента с индексом = 1

        System.out.println("Элемент массива с индексом i = 1: " + array.get(1));  //Демонстрация метода get()

        array.tostring();       //Вывести в консоль внутреннее состояние массива с 2 элементами

        array.add(9);           //Добавить еще 3 элемента - демонстрация пересоздания массива
        array.add(17);
        array.add(22);

        array.tostring();       //И вывод пересозданного массива в консоль

        array.remove(-1);    //Обработать исключения - попытка удаления и получения элемента с несуществующим индексом
        array.get(17);
    }
}