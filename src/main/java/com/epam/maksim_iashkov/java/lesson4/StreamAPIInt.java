package com.epam.maksim_iashkov.java.lesson4;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Класс для решения 2 задачи на стримах
 * Поскольку стримы нельзя переиспользовать - принято решение на выход давать списки
 */
public class StreamAPIInt {

    /**
     * Метод создания 1000000 целых последовательных чисел стримом - и сохранение их в лист
     */
    public List<Integer> createStream() {
        return IntStream
                .range(0,1000000)                   //Создание числового стрима от 0 до 1000000 не включительно
                .boxed()                            //Упаковка потока в целые числа
                .collect(Collectors.toList());      //Сохранение числовой последовательности в список
    }

    /**
     * Метод рандомизации позиций элементов и доказательство этого факта
     */
    public List<Integer> shuffleStream(List<Integer> startList) {

        List<Integer> shuffleList = startList.stream()
                .collect(toShuffledList());                 //Перемешивание последовательности

        List<Integer> sublist;  //Объявление под-списка для дальнейшего доказательства

        try {
            sublist = shuffleList.subList(0, 10);   //Выбрать в под-список первые 10 элементов перемешанной последовательности
        } catch (IndexOutOfBoundsException ex) {  //Отлов исключения, если количество элементов последовательности меньше 10 чисел
            System.out.println("Количество элементов недостаточно для анализа упорядоченности!");
            sublist = new ArrayList<>(Collections.emptyList());
        }

        List<Integer> sortList = sublist.stream()       //Создание потока для под-списка
                .sorted()                               //Сортировать поток
                .collect(Collectors.toList());

        if ((sortList.equals(sublist)) & (sublist.size() >= 10)) {    //Если исходный под-список перемешанной последовательности = отсортированному подсписку - принимаем, что такие числа последовательны
            System.out.println("Список элементов является последовательным!");
        } else if (!(sortList.equals(sublist)) & (sublist.size() >= 10)) {    //Если не равны - порядок произвольный
            System.out.println("Список элементов является произвольным!");
        }
        return shuffleList;     //Возврат перемешанного списка
    }

    /**
     * Метод проверки последовательности на уникальность элементов
     */
    public void uniqueStream(List<Integer> shuffleList) {
        List<Integer> uniqueList = shuffleList.stream()
                .distinct()                         //Удаление дублей в стриме
                .collect(Collectors.toList());
        if (shuffleList.size() == uniqueList.size()) {    //Если исходный список и список без дублей равны - то исходная последовательность содержит только уникальные элементы
            System.out.println("Все элементы последовательности уникальны!");
        } else {
            System.out.println("Последовательность содержит повторяющиеся элементы!");
        }
    }

    /**
     * Метод поиска минимального элемента
     */
    public void findMin(List<Integer> shuffleList) {
        try {
            if (shuffleList.size() == 0) throw new NoSuchElementException("Переданный список элементов пуст!");
            Integer minNumber = shuffleList.stream()
                    .min(Comparator.comparing(Integer::valueOf))
                    .orElse(null);    //Найти минимальный элемент - сразу без промежуточных операторов
            System.out.println("Минимальный элемент последовательности равен = " + minNumber);  //Вывод найденного минимума в консоль
        } catch (NoSuchElementException exc) {    //Отлов исключения, если на вход придет пустой список
            System.out.println(exc.getMessage());
        }
    }

    /**
     * Метод удаления нечетных элементов
     */
    public List<Integer> onlyEvenStream(List<Integer> shuffleList) {
        return shuffleList.stream()
                .filter(i -> i % 2 == 0)            //Фильтрация стрима только на четные элементы
                .collect(Collectors.toList());
    }

    /**
     * Метод поиска предпоследнего элемента
     */
    public void findPreLast(List<Integer> evenList) {
        try {
            if (evenList.size() == 0)
                throw new IllegalArgumentException("Переданный список элементов не содержит значений!");
            if (evenList.size() == 1)
                throw new IllegalArgumentException("Переданный список элементов содержит только одно значение!");
            Integer preLast = evenList.stream()
                    .sorted()                           //Сортировать элементы стрима
                    .skip((evenList.size() - 2))        //Пропустить всех позиции до предпоследней
                    .findFirst()                        //Найти первый элемент, начиная с позиции, на которую мы "отмотали" прошлым оператором
                    .orElse(null);                //Значение по умолчанию
            System.out.println("Предпоследний элемент последовательности равен = " + preLast);  //Вывод предпоследнего элемента в консоль
        } catch (IllegalArgumentException except) {   //Ловить исключение, если в списке 0 или 1 элемент
            System.out.println(except.getMessage());
        }
    }

    /**
     * Заимствованный коллектор SHUFFLER - для терминального оператора стримов
     * Переводить стрим в коллекцию и применяет метод shuffle
     * Все остальные найденные или придуманные методы - нарушали API контракт и вызывали исключение
     */
    private static final Collector<?, ?, ?> SHUFFLER = Collectors.collectingAndThen(
            Collectors.toCollection(ArrayList::new),
            list -> {
                Collections.shuffle(list);
                return list;
            }
    );

    /**
     * Заимствованный статик toShuffledList() для терминального оператора стрима из метода рандомизации элементов
     * Применяет к стриму элементов коллектор SHUFFLER, описанный выше
     */
    @SuppressWarnings("unchecked")
    public static <T> Collector<T, ?, List<T>> toShuffledList() {
        return (Collector<T, ?, List<T>>) SHUFFLER;
    }
}