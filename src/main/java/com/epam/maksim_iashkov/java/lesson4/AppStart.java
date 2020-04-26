package com.epam.maksim_iashkov.java.lesson4;

import java.util.ArrayList;

public class AppStart {

    public static void main(String[] args){
        CollectionsInt collectionsInt = new CollectionsInt();   //Создание экземпляра CollectionsInt

        ArrayList<Integer> list = collectionsInt.createCollections();   //Создание миллиона последовательных целых чисел
        ArrayList<Integer> list1;   //Коллекция для хранения нового списка только четных чисел

        collectionsInt.shuffleCollections(list);    //Перемешать последовательность чисел и показать это
        collectionsInt.checkUnic(list);             //Показать уникальность всех элементов последовательности
        collectionsInt.findMin(list);               //Найти минимальный элемент последовательности
        list1 = collectionsInt.onlyEven(list);      //Удаление всех нечетных элементов и сохранение в другую коллекцию
        collectionsInt.findPrelast(list1);          //Найти предпоследний по величине элемент
    }
}
