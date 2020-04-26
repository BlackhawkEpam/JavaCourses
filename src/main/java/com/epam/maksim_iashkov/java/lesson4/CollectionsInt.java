package com.epam.maksim_iashkov.java.lesson4;

import java.util.*;

public class CollectionsInt {

    public ArrayList<Integer> createCollections() {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        return list;
    }

    public void shuffleCollections(ArrayList<Integer> list) {
        int orderliness = 0;
        Collections.shuffle(list);
        List<Integer> sublist = list.subList(1,11);
        for (int i=0; i<sublist.size()-1; i++) {
            if (sublist.get(i) == sublist.get(i+1) - 1) {
                orderliness = orderliness + 1;
            }
        }
        if (orderliness == (sublist.size()-1)) {
            System.out.println("Список элементов является последовательным!");
        } else {
            System.out.println("Список элементов является произвольным!");
        }
    }

    public void checkUnic(ArrayList<Integer> list) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        if (list.size() == map.size()) {
            System.out.println("Все элементы последовательности уникальны!");
        } else {
            System.out.println("Последовательность содержит повторяющиеся элементы!");
        }
    }

    public void findMin(ArrayList<Integer> list) {
        try {
            if (list.size() == 0) throw new NoSuchElementException("Переданный список элементов пуст!");
            System.out.println("Минимальный элемент коллекции равен = " + Collections.min(list));
        }
        catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Integer> onlyEven(ArrayList<Integer> list) {
        int count = 0;
        ArrayList<Integer> evenlist = new ArrayList<>();
        for (Integer integer : list) {
            if (integer % 2 == 0) {
                count = count + 1;
                evenlist.add(integer);
            }
        }
        if (count == list.size()) {
            System.out.println("Нечётные элементы отсутствуют в последовательности!");
        }
        return evenlist;
    }

    public void findPrelast(ArrayList<Integer> list) {

        Collections.sort(list);

        try {
            if (list.size() == 0) throw new IndexOutOfBoundsException("Переданный список элементов не содержит значений!");
            if (list.size() == 1) throw new IndexOutOfBoundsException("Переданный список элементов содержит только одно значение!");
            System.out.println("Предпоследний по величине элемент равен = " + list.get(list.size() - 2));
        }
        catch (IndexOutOfBoundsException exc) {
            System.out.println(exc.getMessage());
        }
    }

}
