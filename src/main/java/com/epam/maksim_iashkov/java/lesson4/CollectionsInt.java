package com.epam.maksim_iashkov.java.lesson4;

import java.util.*;

/**
 * Класс для решения 2 задачи коллекциями
 */
public class CollectionsInt {

    /**
     * Метод создания миллиона последовательных интов и добавления их в ArrayList
     */
    public ArrayList<Integer> createCollections() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * Метод рандомизации позиций элементов
     */
    public void shuffleCollections(ArrayList<Integer> list) {
        boolean isNotSequent = false;   //Признак произвольности списка
        List<Integer> sublist;          //Объявление под-списка для дальнейшего доказательства
        Collections.shuffle(list);      //Перемешивание всех позиций элементов списка
        try {
            sublist = list.subList(0, 10);    //Создаем под-список из 10 элементов
        } catch (IndexOutOfBoundsException exc) {       //Отлавливаем исключение, если количество элементов меньше 10 и создать под-список нельзя
            System.out.println("Количество элементов недостаточно для анализа упорядоченности!");
            sublist = new ArrayList<>(Collections.emptyList());
        }
        for (int i = 0; i < sublist.size() - 1; i++) {
            if (((isNotSequent = !(sublist.get(i) == sublist.get(i + 1) - 1))) && (sublist.size() >= 10)) { //Для каждого элемента подсписка проверяем его последовательность
                System.out.println("Список элементов является произвольным!");  //Если найдена непоследовательная пара - выводим месседж
                break;  //Т.к. достаточно одного несовпадения - выходим из цикла
            }
        }
        if ((!isNotSequent) && (sublist.size() >= 10)) {
            System.out.println("Список элементов является последовательным!");  //Если все числа последовательны - выводим противоположный месседж
        }
    }

    /**
     * Метод проверки уникальности всех элементов списка
     */
    public void checkUnique(ArrayList<Integer> list) {
        Set<Integer> set = new HashSet<>(list);     //Создаем новый список из входного ArrayList'а. Set будет содержать только уникальные элементы последовательности
        if (list.size() == set.size()) {    //Если размер входного списка и hash-set'а, содержащего только юники равны - все элементы ArrayList'а уникальны
            System.out.println("Все элементы последовательности уникальны!");
        } else {
            System.out.println("Последовательность содержит повторяющиеся элементы!");
        }
    }

    /**
     * Метод поиска минимального элемента последовательности
     */
    public void findMin(ArrayList<Integer> list) {
        try {
            if (list.size() == 0) throw new NoSuchElementException("Переданный список элементов пуст!");
            System.out.println("Минимальный элемент коллекции равен = " + Collections.min(list));   //Сразу вывести в консоль min элемент с помощью библиотечного метода
        } catch (NoSuchElementException ex) {   //Отлов эксепшена, если будет пустой список
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Метод удаления всех нечетных элементов
     */
    public ArrayList<Integer> onlyEven(ArrayList<Integer> list) {
        ArrayList<Integer> evenList = new ArrayList<>();
        for (Integer integer : list) {
            if (integer % 2 == 0) {     //Проверка условия четности
                evenList.add(integer);  //Если элемент четный - добавляем его в новый ArrayList
            }
        }
        return evenList;    //Возвращаем новый ArrayList только с четными элементами
    }

    /**
     * Метод поиска предпоследнего элемента последовательности
     */
    public void findPreLast(ArrayList<Integer> list) {
        Collections.sort(list);     //Сортируем входную последовательность
        try {
            if (list.size() == 0)
                throw new IndexOutOfBoundsException("Переданный список элементов не содержит значений!");
            if (list.size() == 1)
                throw new IndexOutOfBoundsException("Переданный список элементов содержит только одно значение!");
            System.out.println("Предпоследний по величине элемент равен = " + list.get(list.size() - 2));   //Сразу выводим в консоль элемент с предпоследней позиции списка
        } catch (IndexOutOfBoundsException exc) {   //Ловим эксепшены, если в списке 0 или 1 элемент
            System.out.println(exc.getMessage());
        }
    }
}