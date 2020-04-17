package com.epam.maksim_iashkov.java.lesson2.service;
import com.epam.maksim_iashkov.java.lesson2.model.Transport;
import com.epam.maksim_iashkov.java.lesson2.util.FilterCheck;

/**
 * Класс реализации поисковых фильтров для объектов-транспортов
 */
public class TransportFilter {

    private FilterCheck filterCheck;

    boolean c;  //Признак необходимости фильтрации парка ОТ по стоимости
    boolean ff; //Признак необходимости фильтрации парка ОТ по расходу топлива
    boolean pc; //Признак необходимости фильтрации парка ОТ по пассажировместимости
    boolean v;  //Признак необходимости фильтрации парка ОТ по скорости

    /*Инициализация верхних и нижних границ диапазонов*/
    double c1 = 0.00;   //Нижняя граница вводимой цены
    double c2 = 0.00;   //Верхняя граница вводимой цены
    int ff1 = 0;    //Нижняя граница вводимого расхода топлива
    int ff2 = 0;    //Верхняя граница вводимого расхода топлива
    int pc1 = 0;    //Нижняя граница вводимой пассажировместимости
    int pc2 = 0;    //Верхняя граница вводимой пассажировместимости
    double v1 = 0.00;   //Нижняя граница вводимой скорости
    double v2 = 0.00;   //Верхняя граница вводимой скорости

    public TransportFilter(FilterCheck filterCheck) {
        this.filterCheck = filterCheck;
    }

    private void reInit(){
        c1 = 0.00;   //Нижняя граница вводимой цены
        c2 = 0.00;   //Верхняя граница вводимой цены
        ff1 = 0;    //Нижняя граница вводимого расхода топлива
        ff2 = 0;    //Верхняя граница вводимого расхода топлива
        pc1 = 0;    //
        pc2 = 0;    //Верхняя граница вводимой пассажировместимости
        v1 = 0.00;   //Нижняя граница вводимой скорости
        v2 = 0.00;   //Верхняя

        c = false;  //Признак необходимости фильтрации парка ОТ по стоимости
        ff = false; //Признак необходимости фильтрации парка ОТ по расходу топлива
        pc = false; //Признак необходимости фильтрации парка ОТ по пассажировместимости
        v = false;
    }

    /**
     * BLA vla bla
     * @param transport
     * @return
     */
    private boolean isCapacityValid(Transport transport){
        // Нижняя и верхняя границы вводимой пассажировместимости
        int pcMin, pcMax;
        System.out.println("Фильтровать парк ОТ по пассажировместимости? yes/no");
        if(filterCheck.isFilterParamRequired()){
            System.out.println("Введите минимальное значение пассажировместимости: ");
            pcMin = filterCheck.checkIntMin();
            System.out.println("Введите максимальное значение пассажировместимости: ");
            pcMax = filterCheck.checkIntMax(pcMin);
            return (transport.getPassCapacity() >= pcMin) && (transport.getPassCapacity() <= pcMax);
        }
        return true;
    }

    /**
     * Метод фильтрации транспортных средств по диапазонам параметров
     */
    public void filter(Transport[] array){
        int count = 0;
        System.out.println("Поиск транспорта по заданному диапазону параметров");

        System.out.println("Фильтровать парк ОТ по цене? yes/no");
        c = filterCheck.isFilterParamRequired();
        if (c) {
            System.out.println("Введите минимальное значение цены транспорта: ");
            filterCheck.checkDoubleMin(c1);

            System.out.println("Введите максимальное значение цены транспорта: ");
            filterCheck.checkDoubleMax(c2, c1);
        }

        System.out.println("Фильтровать парк ОТ по расходу топлива? yes/no");
        ff = filterCheck.isFilterParamRequired();
        if (ff) {
            System.out.println("Введите минимальное значение расхода топлива: ");
            ff1 = filterCheck.checkIntMin();

            System.out.println("Введите максимальное значение расхода топлива: ");
            ff2 = filterCheck.checkIntMax(ff1);
        }




        System.out.println("Фильтровать парк ОТ по скорости? yes/no");
        v = filterCheck.isFilterParamRequired();
        if (v) {
            System.out.println("Введите минимальное значение скорости: ");
            filterCheck.checkDoubleMin(v1);

            System.out.println("Введите максимальное значение скорости: ");
            filterCheck.checkDoubleMax(v2, v1);
        }

        /*Проверка каждого транспорта из массива на попадание в диапазоны параметров*/
        for (Transport transport : array) {
            if (((c) || ((transport.getCost() >= c1) && (transport.getCost() <= c2))) &&
                    ((ff) || ((transport.getFuelFlow() >= ff1) && (transport.getFuelFlow() <= ff2))) &&
                    isCapacityValid(transport) &&
                    ((v) || ((transport.getVelocity() >= v1) && (transport.getVelocity() <= v2)))) {
                System.out.println("Искомый транспорт: " + transport);
                count = count + 1;  //Счетчик количества подпадающих под фильтр транспортных средств
            }
        }
        if (count == 0) {   //Если объектов не нашлось - вывести информационное сообщение
            System.out.println("Транспортные средства, подходящие под условия, отсутствуют!");
        }
    }

    public void setFilterCheck(FilterCheck filterCheck) {
        this.filterCheck = filterCheck;
        reInit();
    }
}