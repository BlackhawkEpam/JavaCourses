package com.epam.maksim_iashkov.java.lesson2.service;
import com.epam.maksim_iashkov.java.lesson2.exception.DivideByZeroDistanceException;
import com.epam.maksim_iashkov.java.lesson2.exception.NotFileForAtributeException;
import com.epam.maksim_iashkov.java.lesson2.exception.NotPosCostException;
import com.epam.maksim_iashkov.java.lesson2.exception.NotPosVelocityException;
import com.epam.maksim_iashkov.java.lesson2.model.*;

import java.io.*;

/**
 * Вспомогательный класс для генерации исключительных ситуаций
 */
public class CreateTestSuiteException {

    /**
     * Для первого тест-кейса - генерация автобуса с отрицательной ценой
     */
    public Transport[] testCase1(){

            /*Создание экземпляров классов из пакета модели*/
            Autobus autobus1 = new Autobus(-100, 3, 80, 50, 1000);
            Autobus autobus2 = new Autobus(1500, 4, 90, 0, 1200);

            /*Сохранение экземпляров классов транспортных средств в массив*/
            Transport[] park = new Transport[2];
            park[0] = autobus1;
            park[1] = autobus2;

        /*Блок try с несколькими идущими друг за другом catch*/
        try {
                /*Вызов родительских методов для транспортных средств*/
                for (Transport transport : park) {
                    transport.mileage();
                }

        } catch (NotPosCostException ex){   //Отлов некорректной цены
            System.out.println(ex.getMessage());
            System.out.println("Введенная некорректная цена = "+ex.getCosts());
        } catch (NotPosVelocityException ex) {  //Отлов некорректной скорости
            System.out.println(ex.getMessage());
            System.out.println("Введенная некорректная скорость = "+ex.getVelocity());
        } finally {
            System.out.println("Конец обработки эксепшена 1 кейса");
        }
            return park;
    }

    /**
     * Для четвертого тест кейса - Попытка заменить имя парома на имя из отсутствующего текстового файла
     */
    public static Transport[] testCase4() {

        Ferry ferry2 = new Ferry(5000, 2, 100, 40, 5, true, "Буревестник");
        Transport[] park = new Transport[1];
        park[0] = ferry2;

        try {
            File ferryname = new File("file45875897548.txt");
            if (!ferryname.exists()) throw new NotFileForAtributeException("Файл с наименованием парома отсутствует!"); //Генерация исключения для отсутствующего файла

            FileReader fr = new FileReader("file45875897548.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            ferry2.setNames(line);
            br.close();
        } catch (NotFileForAtributeException exc) { //Отлов отсутствия файла моим кастомным классом - заменой стандартного FileNotFoundException
            System.out.println(exc.getMessage());
        } catch (IOException ex) {  //Отлов других checked-исключений ввода-вывода, которые компилятор так же требует по умолчанию
            System.out.println("Произошла ошибка обработки файла!");
        } finally {
            System.out.println("Конец обработки эксепшена 4 кейса");
        }
        return park;
    }

    /**
     * Для третьего тест-кейса - метод, в котором отлавливается деление на нуль
     */
    public void testCase3() {

        Ferry ferry3 = new Ferry(5000, 2, 100, 0, 5, true, "Буревестник");  //Заданный паром со скоростью = 0
        double ffadd;   //Увеличение расхода топлива

        try {
            ffadd = ferry3.getFuelFlow() / (ferry3.getVelocity()*ferry3.getTimes());    //Подсчет приращения расхода топлива
            if (ferry3.getVelocity()*ferry3.getTimes() == 0) throw new DivideByZeroDistanceException("Произошло деление на нулевое расстояние!");   //Выбросить исключение, если делитель = 0
            System.out.println("Приращение расхода топлива = "+ffadd); //Если нет эксепшена - вывести приращение
        } catch (ArithmeticException ex) {  //Блок catch, в котором родительский класс по отношению к DivideByZeroDistanceException ловит исключение
            System.out.println(ex.getMessage());    //Вывести сообщение из DivideByZeroDistanceException
        } finally {
            System.out.println("Конец обработки эксепшена 3 кейса");
        }
    }

    /**
     * Для второго тестового кейса - мультикэтч и введение нулевой скорости
     */
    public Transport[] testCase2() {

        Taxi taxi1 = new Taxi(1500, 2, 3, 0, 4, 1);
        Taxi taxi2 = new Taxi(0, 3, 3, 75, 5, 1);

        Transport[] park = new Transport[2];
        park[0] = taxi1;
        park[1] = taxi2;

        /*Блок try и один multi-catch*/
        try {
            for (Transport transport : park) {
                transport.mileage();
            }
        } catch (NotPosCostException | NotPosVelocityException ex){ //Перехват ошибок на отрицательную цену и неположительную скорость
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Конец обработки эксепшена 2 кейса");
        }
        return park;
    }
}