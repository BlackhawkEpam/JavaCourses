package com.epam.maksim_iashkov.java.lesson2.service;
import com.epam.maksim_iashkov.java.lesson2.model.Transport;
import com.epam.maksim_iashkov.java.lesson2.util.FilterCheck;

/**
 * Класс реализации поисковых фильтров для объектов-транспортов
 */
public class TransportFilter {
    private int count=0;    //Инициализация счетчика

    FilterCheck filterCheck = new FilterCheck();    //Создание экземпляра класса для ввода-проверок границ диапазонов

    /**
     * Метод фильтрации транспортных средств по диапазонам параметров
     */
    public void filter(Transport[] array){
        System.out.println("Поиск транспорта по заданному диапазону параметров");
        System.out.println("Введите минимальное значение цены транспорта: ");
        double c1 = 0.00;
        c1 = filterCheck.checkDoubleMin(c1);

        System.out.println("Введите максимальное значение цены транспорта: ");
        double c2 = 0.00;
        c2 = filterCheck.checkDoubleMax(c2,c1);

        System.out.println("Введите минимальное значение расхода топлива: ");
        int ff1 = 0;
        ff1 = filterCheck.checkIntMin(ff1);

        System.out.println("Введите максимальное значение расхода топлива: ");
        int ff2 = 0;
        ff2 = filterCheck.checkIntMax(ff2,ff1);

        System.out.println("Введите минимальное значение пассажировместимости: ");
        int pc1 = 0;
        pc1 = filterCheck.checkIntMin(pc1);

        System.out.println("Введите максимальное значение пассажировместимости: ");
        int pc2 = 0;
        pc2 = filterCheck.checkIntMax(pc2,pc1);

        System.out.println("Введите минимальное значение скорости: ");
        double v1 = 0.00;
        v1 = filterCheck.checkDoubleMin(v1);

        System.out.println("Введите максимальное значение скорости: ");
        double v2 = 0.00;
        v2 = filterCheck.checkDoubleMax(v2,v1);

        /*Проверка каждого транспорта из массива на попадание в диапазоны параметров*/
        for (int i=0; i<array.length; i++){
            if ((array[i].getCost() >= c1)&(array[i].getCost() <= c2)&(array[i].getFuelFlow() >= ff1)&(array[i].getFuelFlow() <= ff2)&(array[i].getPassCapacity() >= pc1)&(array[i].getPassCapacity() <= pc2)&(array[i].getVelocity() >= v1)&(array[i].getVelocity() <= v2)) {
                System.out.println("Искомый транспорт: " + array[i]);
                count = count + 1;  //Счетчик количества подпадающих под фильтр транспортных средств
            }
        }
        if (count == 0) {   //Если объектов не нашлось - вывести информационное сообщение
            System.out.println("Транспортные средства, подходящие под условия, отсутствуют!");
        }
    }
}