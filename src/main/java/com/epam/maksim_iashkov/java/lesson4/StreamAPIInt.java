package com.epam.maksim_iashkov.java.lesson4;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс для решения 2 задачи на стримах
 * Поскольку стримы нельзя переиспользовать - принято решение на выход давать списки
 */
public class StreamAPIInt {

    /**
     * Метод создания 1000000 целых последовательных чисел стримом - и сохранение их в лист
     */
    public List<Integer> createStream() {
        return Stream.iterate(0, n -> n + 1).limit(1000000).collect(Collectors.toList());
    }

    /**
     * Метод рандомизации позиций элементов и доказательство этого факта
     */
    public List<Integer> shuffleStream(List<Integer> startList) {
        Stream<Integer> stream = startList.stream();    //Создание стрима из входного списка
        List<Integer> shuffleList = stream.collect(toShuffledList());   //Перемешивание чисел кастомным методом toShuffledList()
        List<Integer> sublist;  //Объявление под-списка для дальнейшего доказательства

        try {
            sublist = shuffleList.subList(0, 10);   //Выбрать в под-список первые 10 элементов перемешанной последовательности
        } catch (IndexOutOfBoundsException ex) {  //Отлов исключения, если количество элементов последовательности меньше 10 чисел
            System.out.println("Количество элементов недостаточно для анализа упорядоченности!");
            sublist = new ArrayList<>(Collections.emptyList());
        }
        Stream<Integer> streamSort = sublist.stream();  //Создание нового стрима из ранее объявленного под-списка
        List<Integer> sortList = streamSort.sorted().collect(Collectors.toList());  //Отсортировать под-список в порядке возрастания
        if ((sortList.equals(sublist)) & (sublist.size() >= 10)) {    //Если исходный под-список перемешанной последовательности = отсортированному подсписку - принимаем, что такие числа последовательны
            System.out.println("Список элементов является последовательным!");
        } else if (!(sortList.equals(sublist)) & (sublist.size() >= 10)) {    //Если не равны - порядок произвольный
            System.out.println("Список элементов является произвольным!");
        }

        return shuffleList;
    }

    /**
     * Метод проверки последовательности на уникальность элементов
     */
    public void uniqueStream(List<Integer> shuffleList) {
        Stream<Integer> stream = shuffleList.stream();  //Создание стрима из выходного списка
        List<Integer> uniqueList = stream.distinct().collect(Collectors.toList());  //Удалить дубли в стриме и создать из него новый список только с уникальными элементами
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
            Stream<Integer> stream = shuffleList.stream();  //Создание стрима из входного списка
            Integer minNumber = stream.min(Comparator.comparing(Integer::valueOf)).orElse(null);    //Найти минимальный элемент - сразу без промежуточных операторов
            System.out.println("Минимальный элемент последовательности равен = " + minNumber);  //Вывод найденного минимума в консоль
        } catch (NoSuchElementException exc) {    //Отлов исключения, если на вход придет пустой список
            System.out.println(exc.getMessage());
        }
    }

    /**
     * Метод удаления нечетных элементов
     */
    public List<Integer> onlyEvenStream(List<Integer> shuffleList) {
        Stream<Integer> stream = shuffleList.stream();  //Создание стрима из входного списка
        return stream.filter(i -> i % 2 == 0).collect(Collectors.toList());   //Фильтровать стрим: если элемент четный - выводить его в лист
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
            Stream<Integer> stream = evenList.stream();     //Создание стрима из входного списка
            Integer preLast = stream.sorted().skip((evenList.size() - 2)).findFirst().orElse(null); //Отсортировать стрим по возрастанию, пропустить все элементы до предпоследнего и "найти" его
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