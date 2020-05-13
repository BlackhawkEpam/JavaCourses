package com.epam.maksim_iashkov.java.lesson5;

import com.epam.maksim_iashkov.java.lesson5.model.*;

import java.io.*;
import java.util.ArrayList;

/**
 * Класс, реализующий сериализацию/десериализацию парка ТС
 */
public class ModelSerialization {

    /**
     * Метод создания экземпляров классов парка ТС
     */
    public ArrayList<Transport> createPark() {

        ArrayList<Transport> transportPark = new ArrayList<>();     //Список ТС на сериализацию

        /*Добавляем в список по 2 экземпляра каждого класса*/
        transportPark.add(new Autobus(1500, 60, 60, "м753кт-77rus", "ГАЗ", false));
        transportPark.add(new Autobus(1400, 70, 50, "к678тм-77rus", "Икарус", false));
        transportPark.add(new Ferry(3000, 50, 35, true, "Буревестник"));
        transportPark.add(new Ferry(4000, 50, 40, false, "Снегирь"));
        transportPark.add(new Taxi(2500, 3, 80, "Вольво", "Яндекс Такси"));
        transportPark.add(new Taxi(2700, 3, 80, "Шкода", "Ситимобил"));
        transportPark.add(new Train(5000, 400, 80, "315", 'Э'));
        transportPark.add(new Train(6000, 450, 100, "742", 'М'));
        transportPark.add(new Trolley(1500, 60, 65, "БТЗ", false, 140));
        transportPark.add(new Trolley(1750, 75, 70, "Trolza", true, 150));

        /*Выведем созданный парк ТС в консоль для наглядной демонстрации*/
        System.out.println("Созданный парк ОТ до сериализации:");
        for (Transport transport : transportPark) {
            System.out.println(transport);
        }
        return transportPark;
    }

    /**
     * Метод сериализации списка с транспортными средствами
     */
    public String serializePark(ArrayList<Transport> transportPark) {

        String filename = "transport.dat";  //Название файла, в который будем сохранять сериализованный поток

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);     //Открываем файл для ввода потока
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);   //Открываем новый поток записи

            objectOutputStream.writeObject(transportPark);  //Записать потоком список ТС в файл, указанный в fileOutputStream
            objectOutputStream.flush();     //Очистка скоплений в буфере, при наличии там чего-либо
            objectOutputStream.close();     //Закрываем поток
        } catch (IOException exc) {
            System.out.println("Произошла ошибка при записи данных!");
            return filename;
        }
        System.out.println("Запись списка транспортного парка прошла успешно!");
        return filename;
    }

    /**
     * Метод десериализации списка ТС из файла в новый список для вывода на консоль
     */
    @SuppressWarnings("unchecked")
    public void deserializePark(String filename) {

        ArrayList<Transport> deserializePark;       //Новый список, в который произведется десериализация

        try {
            FileInputStream fileInputStream = new FileInputStream(filename);    //Задаем файл, из которого будет осуществляться поток чтения
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);   //Создаем поток чтения

            deserializePark = ((ArrayList<Transport>) objectInputStream.readObject());  //Считать объекты из файла в ArrayList типа Transport
            objectInputStream.close();  //Закрываем поток
        } catch (IOException ex) {
            System.out.println("Произошла ошибка при чтении данных!");
            return;
        } catch (ClassNotFoundException exception) {
            System.out.println("При чтении данных обнаружены отсутствующие в иерархии классы!");
            return;
        }

        /*Выводим десериализованный список в консоль для наглядного сравнения с исходным списком*/
        System.out.println("Парк ОТ после десериализации:");
        for (Transport transport : deserializePark) {
            System.out.println(transport);
        }
    }
}