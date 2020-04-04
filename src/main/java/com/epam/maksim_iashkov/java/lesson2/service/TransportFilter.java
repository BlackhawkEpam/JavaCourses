package com.epam.maksim_iashkov.java.lesson2.service;
import com.epam.maksim_iashkov.java.lesson2.model.Transport;
import com.epam.maksim_iashkov.java.lesson2.util.FilterCheck;

/**
 * Класс реализации поисковых фильтров для объектов-транспортов
 */
public class TransportFilter {
    private int count=0;    //Инициализация счетчика
    boolean c, ff, pc, v; //Флаги, по которым будет понятно, фильтруется ли параметр
    /*Инициализация верхних и нижних границ диапазонов*/
    double c1 = 0.00;
    double c2 = 0.00;
    int ff1 = 0;
    int ff2 = 0;
    int pc1 = 0;
    int pc2 = 0;
    double v1 = 0.00;
    double v2 = 0.00;

    FilterCheck filterCheck = new FilterCheck();    //Создание экземпляра класса для ввода-проверок границ диапазонов

    /**
     * Метод фильтрации транспортных средств по диапазонам параметров
     */
    public void filter(Transport[] array){
        System.out.println("Поиск транспорта по заданному диапазону параметров");

        System.out.println("Фильтровать парк ОТ по цене? yes/no");
        c = filterCheck.filterParam(c);
        if (!c) {
            System.out.println("Введите минимальное значение цены транспорта: ");
            c1 = filterCheck.checkDoubleMin(c1);

            System.out.println("Введите максимальное значение цены транспорта: ");
            c2 = filterCheck.checkDoubleMax(c2, c1);
        }

        System.out.println("Фильтровать парк ОТ по расходу топлива? yes/no");
        ff = filterCheck.filterParam(ff);
        if (!ff) {
            System.out.println("Введите минимальное значение расхода топлива: ");
            ff1 = filterCheck.checkIntMin(ff1);

            System.out.println("Введите максимальное значение расхода топлива: ");
            ff2 = filterCheck.checkIntMax(ff2, ff1);
        }

        System.out.println("Фильтровать парк ОТ по пассажировместимости? yes/no");
        pc = filterCheck.filterParam(pc);
        if (!pc) {
            System.out.println("Введите минимальное значение пассажировместимости: ");
            pc1 = filterCheck.checkIntMin(pc1);

            System.out.println("Введите максимальное значение пассажировместимости: ");
            pc2 = filterCheck.checkIntMax(pc2, pc1);
        }


        System.out.println("Фильтровать парк ОТ по скорости? yes/no");
        v = filterCheck.filterParam(v);
        if (!v) {
            System.out.println("Введите минимальное значение скорости: ");
            v1 = filterCheck.checkDoubleMin(v1);

            System.out.println("Введите максимальное значение скорости: ");
            v2 = filterCheck.checkDoubleMax(v2, v1);
        }

        /*Проверка каждого транспорта из массива на попадание в диапазоны параметров*/
        for (Transport transport : array) {
            if (((c) || ((transport.getCost() >= c1) && (transport.getCost() <= c2))) &&
                    ((ff) || ((transport.getFuelFlow() >= ff1) && (transport.getFuelFlow() <= ff2))) &&
                    ((pc) || ((transport.getPassCapacity() >= pc1) && (transport.getPassCapacity() <= pc2))) &&
                    ((v) || ((transport.getVelocity() >= v1) && (transport.getVelocity() <= v2)))) {
                System.out.println("Искомый транспорт: " + transport);
                count = count + 1;  //Счетчик количества подпадающих под фильтр транспортных средств
            }
        }
        if (count == 0) {   //Если объектов не нашлось - вывести информационное сообщение
            System.out.println("Транспортные средства, подходящие под условия, отсутствуют!");
        }
    }
}