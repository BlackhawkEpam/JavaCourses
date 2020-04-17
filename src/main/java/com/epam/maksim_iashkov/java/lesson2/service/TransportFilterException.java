//package com.epam.maksim_iashkov.java.lesson2.service;
//import com.epam.maksim_iashkov.java.lesson2.exception.ProbelsInAnswerException;
//import com.epam.maksim_iashkov.java.lesson2.model.Transport;
//import com.epam.maksim_iashkov.java.lesson2.util.FilterCheckException;
//
///**
// * Класс реализации поисковых фильтров для объектов-транспортов
// * Дублёр оригинального класса TransportFilter
// * В метод filter приходит заранее невалидный ответ из FilterCheckException
// */
//public class TransportFilterException {
//    private int count=0;    //Инициализация счетчика отфильтрованных транспортных средств
//    boolean costFilterRequired;  //Признак необходимости фильтрации парка ОТ по стоимости
//    boolean ff; //Признак необходимости фильтрации парка ОТ по расходу топлива
//    boolean pc; //Признак необходимости фильтрации парка ОТ по пассажировместимости
//    boolean v;  //Признак необходимости фильтрации парка ОТ по скорости
//
//    /*Инициализация верхних и нижних границ диапазонов*/
//    double c1 = 0.00;   //Нижняя граница вводимой цены
//    double c2 = 0.00;   //Верхняя граница вводимой цены
//    int ff1 = 0;    //Нижняя граница вводимого расхода топлива
//    int ff2 = 0;    //Верхняя граница вводимого расхода топлива
//    int pc1 = 0;    //Нижняя граница вводимой пассажировместимости
//    int pc2 = 0;    //Верхняя граница вводимой пассажировместимости
//    double v1 = 0.00;   //Нижняя граница вводимой скорости
//    double v2 = 0.00;   //Верхняя граница вводимой скорости
//
//    FilterCheckException filterCheck = new FilterCheckException();    //Создание экземпляра класса для ввода-проверок границ диапазонов
//
//    /**
//     * Метод фильтрации транспортных средств по диапазонам параметров
//     * Проверка требования фильтрации цены обернута в try-catch и ждёт исключения для ProbelsInAnswerException
//     */
//    public void filter(Transport[] array){
//        System.out.println("Поиск транспорта по заданному диапазону параметров");
//
//        System.out.println("Фильтровать парк ОТ по цене? yes/no");
//        try {
//            c = filterCheck.filterParam(c);
//        } catch (ProbelsInAnswerException ex){
//            System.out.println(ex.getMessage());
//        } finally {
//            System.out.println("Конец обработки эксепшена 5 кейса");
//            System.exit(0); //Если распознан невалидный ответ - завершить работу, по аналогии с оригинальным методом фильтрации
//        }
//        if (!c) {
//            System.out.println("Введите минимальное значение цены транспорта: ");
//            c1 = filterCheck.checkDoubleMin(c1);
//
//            System.out.println("Введите максимальное значение цены транспорта: ");
//            c2 = filterCheck.checkDoubleMax(c2, c1);
//        }
//
//        System.out.println("Фильтровать парк ОТ по расходу топлива? yes/no");
//        ff = filterCheck.filterParam(ff);
//        if (!ff) {
//            System.out.println("Введите минимальное значение расхода топлива: ");
//            ff1 = filterCheck.checkIntMin(ff1);
//
//            System.out.println("Введите максимальное значение расхода топлива: ");
//            ff2 = filterCheck.checkIntMax(ff2, ff1);
//        }
//
//        System.out.println("Фильтровать парк ОТ по пассажировместимости? yes/no");
//        pc = filterCheck.filterParam(pc);
//        if (!pc) {
//            System.out.println("Введите минимальное значение пассажировместимости: ");
//            pc1 = filterCheck.checkIntMin(pc1);
//
//            System.out.println("Введите максимальное значение пассажировместимости: ");
//            pc2 = filterCheck.checkIntMax(pc2, pc1);
//        }
//
//
//        System.out.println("Фильтровать парк ОТ по скорости? yes/no");
//        v = filterCheck.filterParam(v);
//        if (!v) {
//            System.out.println("Введите минимальное значение скорости: ");
//            v1 = filterCheck.checkDoubleMin(v1);
//
//            System.out.println("Введите максимальное значение скорости: ");
//            v2 = filterCheck.checkDoubleMax(v2, v1);
//        }
//
//        /*Проверка каждого транспорта из массива на попадание в диапазоны параметров*/
//        for (Transport transport : array) {
//            if (((c) || ((transport.getCost() >= c1) && (transport.getCost() <= c2))) &&
//                    ((ff) || ((transport.getFuelFlow() >= ff1) && (transport.getFuelFlow() <= ff2))) &&
//                    ((pc) || ((transport.getPassCapacity() >= pc1) && (transport.getPassCapacity() <= pc2))) &&
//                    ((v) || ((transport.getVelocity() >= v1) && (transport.getVelocity() <= v2)))) {
//                System.out.println("Искомый транспорт: " + transport);
//                count = count + 1;  //Счетчик количества подпадающих под фильтр транспортных средств
//            }
//        }
//        if (count == 0) {   //Если объектов не нашлось - вывести информационное сообщение
//            System.out.println("Транспортные средства, подходящие под условия, отсутствуют!");
//        }
//    }
//}