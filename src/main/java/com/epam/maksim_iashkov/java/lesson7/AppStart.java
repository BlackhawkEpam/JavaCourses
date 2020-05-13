package com.epam.maksim_iashkov.java.lesson7;

import com.epam.maksim_iashkov.java.lesson7.model.*;

/**
 * Класс - стартер нашего приложения для ДЗ7
 */
public class AppStart {

    /**
     * Метод main - входная точка программы
     */
    public static void main(String[] args) {

        AnnotationParser ap = new AnnotationParser();   //Создаем экземпляр класса AnnotationParser

        /*Создание и парсинг экземпляра вертолёта с чужим абстрактным классом - проверка @IsTransport*/
        Helicopter helicopter = new Helicopter(5000, 10, 60, "МИ-8", "123-ASD");
        ap.reflectionAPI(helicopter);

        /*Нарушение аннотации @OverZero сразу в двух полях*/
        Trolley trolley = new Trolley(1500, 60, -5, "Trolza", false, 0);
        ap.reflectionAPI(trolley);

        /*Создание экземпляра класса без интерфейсов - нарушение @WithSerialize*/
        Train train = new Train(10000, 400, 80, "Э", '7');
        ap.reflectionAPI(train);

        /*Создание парома с русским наименованием - нарушение @AllEnglishChars*/
        Ferry ferry = new Ferry(4000, 60, 40, true, "Снегирь");
        ap.reflectionAPI(ferry);

        /*Нарушение сразу двух аннотаций - @WithSerialize и @NotEmpty*/
        Autobus autobus = new Autobus(2000, 50, 50, "о374мп", "   ", false);
        ap.reflectionAPI(autobus);

        /*Экземпляр такси, нарушающий сразу две аннотации текстовых полей: @NotEmpty и @NotNull*/
        Taxi yandexTaxi = new Taxi(1000, 10, 75, null, "");
        ap.reflectionAPI(yandexTaxi);

        /*Экземпляр такси без нарушений аннотаций*/
        Taxi citimobile = new Taxi(1000, 10, 75, "Volvo", "Ситимобил");
        ap.reflectionAPI(citimobile);
    }
}
