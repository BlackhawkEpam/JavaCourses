package com.epam.maksim_iashkov.java.lesson7;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Класс обработчика аннотаций на ReflectionAPI
 */
public class AnnotationParser {

    /**
     * Метод обработки аннотации объекта и выдачи warning'ов через ReflectionAPI
     */
    public void reflectionAPI(Object transport) {

        System.out.println("Объект: " + transport);   //Показать переданный объект
        Class<?> objClass = transport.getClass();   //Получить непосредственный класс объекта
        ArrayList<Annotation> listAnn = new ArrayList<>(Arrays.asList(objClass.getAnnotations()));  //Для класса получить список аннотаций

        /*Обработчик аннотаций класса*/
        for (Annotation annotation : listAnn) {
            if (annotation.annotationType().getSimpleName().equals("IsTransport")) {
                isTransport(transport);     //Если в классе присутствует аннотация @IsTransport - вызвать метод isTransport()
            } else if (annotation.annotationType().getSimpleName().equals("WithSerialize")) {
                withSerialize(transport);   //Если в классе присутствует аннотация @WithSerialize - вызвать метод withSerialize()
            }
        }

        /*Обработка аннотаций полей*/
        for (Class<?> c = objClass; c != null; c = c.getSuperclass()) {
            Field[] fields = c.getDeclaredFields();     //Получить поля текущего класса и унаследованные от абстрактного класса
            for (Field classField : fields)             //Для каждого поля
            {
                Class<?> currentClass = classField.getDeclaringClass();     //Получить его класс для передачи в методы
                Annotation[] fa = classField.getAnnotations();              //Получить аннотации этого поля
                for (Annotation fas : fa) {                                 //Проверить каждую аннотацию (если есть)
                    /*Блок сравнений аннотаций с нашими 4 кастомными аннотациями
                     * если название аннотации совпадает с заданными нами - вызываем
                     * соответствующий метод обработки*/
                    if (fas.annotationType().getSimpleName().equals("NotNull")) {
                        notNull(transport, classField, currentClass);
                    }
                    if (fas.annotationType().getSimpleName().equals("NotEmpty")) {
                        notEmpty(transport, classField, currentClass);
                    }
                    if (fas.annotationType().getSimpleName().equals("OverZero")) {
                        overZero(transport, classField, currentClass);
                    }
                    if (fas.annotationType().getSimpleName().equals("AllEnglishChars")) {
                        allEnglishChars(transport, classField, currentClass);
                    }
                }
            }
        }
    }

    /**
     * Метод обработки аннотации @IsTransport
     */
    public void isTransport(Object transport) {
        if (!(transport.getClass().getSuperclass().getSimpleName().equals("Transport"))) {
            //Если родительский класс не равен "Transport" - выводим ворнинг
            System.out.println("WARN: Абстрактный класс экземпляра должен быть = Transport!");
        }
    }

    /**
     * Метод обработки аннотации @WithSerialize
     */
    public void withSerialize(Object transport) {
        Class<?>[] classInterfaces = transport.getClass().getInterfaces();  //Получаем интерфейсы класса
        ArrayList<String> listIntfs = new ArrayList<>();    //Создаем список для интерфейсов
        for (Class<?> ifs : classInterfaces) {
            listIntfs.add(ifs.getSimpleName()); //Запись интерфейсов в список
        }
        if (!(listIntfs.contains("Serializable"))) {    //Если в списке отсутствует интерфейс Serializable - выводим ворнинг
            System.out.println("WARN: Класс экземпляра должен быть доступен для сериализации!");
        }
    }

    /**
     * Метод обработки аннотации @NotEmpty
     */
    public void notEmpty(Object transport, Field classField, Class<?> currentClass) {
        Field nameField = null;
        try {
            nameField = currentClass.getDeclaredField(classField.getName());    //Получаем поле, на которое навешена аннотация
            nameField.setAccessible(true);                                      //Получаем к ней доступ
        } catch (NoSuchFieldException exc) {
            System.out.println("Не найдено поле, к которому должна была быть применена аннотация @NotEmpty!");
        }
        try {
            if (Objects.requireNonNull(nameField).get(transport) != null) {     //Если в поле не null - проверяем
                if (Objects.requireNonNull(nameField).get(transport).toString().trim().equals("")) {
                    //Если содержимое поле не содержит каких-либо char - выводим варнинг
                    System.out.println("WARN: Поле " + nameField.getName() + " не должно быть пустым!");
                }
            }
        } catch (IllegalAccessException ex) {
            System.out.println("Не удалось получить доступ к полю с аннотацией @NotEmpty!");
        }
    }

    /**
     * Метод обработки аннотации @NotNull
     * Общая логика - аналогична методу notEmpty(), поэтому отступы в различиях
     */
    public void notNull(Object transport, Field classField, Class<?> currentClass) {
        Field nameField = null;
        try {
            nameField = currentClass.getDeclaredField(classField.getName());
            nameField.setAccessible(true);
        } catch (NoSuchFieldException exc) {
            System.out.println("Не найдено поле, к которому должна была быть применена аннотация @NotNull!");
        }
        try {
            if (Objects.requireNonNull(nameField).get(transport) == null) {
                //Проверяем содержимое поля nameField для переданного объекта transport на нулл, если проверка проходит - выводим ворнинг
                System.out.println("WARN: Поле " + nameField.getName() + " не должно быть = null!");
            }
        } catch (IllegalAccessException ex) {
            System.out.println("Не удалось получить доступ к полю с аннотацией @NotNull!");
        }
    }

    /**
     * Метод обработки аннотации @OverZero
     * Общая логика - аналогична методу notEmpty(), поэтому отступы в различиях
     */
    public void overZero(Object transport, Field classField, Class<?> currentClass) {
        Field nameField = null;
        try {
            nameField = currentClass.getDeclaredField(classField.getName());
            nameField.setAccessible(true);
        } catch (NoSuchFieldException exc) {
            System.out.println("Не найдено поле, к которому должна была быть применена аннотация @OverZero!");
        }
        try {
            if (Objects.requireNonNull(nameField).getDouble(transport) <= 0) {
                //Проверяем численное значение валидируемого поля nameField объекта transport на меньше или равно нулю
                //Если проверка выполняется - выводим ворнинг
                System.out.println("WARN: Поле " + nameField.getName() + " должно быть больше нуля!");
            }
        } catch (IllegalAccessException ex) {
            System.out.println("Не удалось получить доступ к полю с аннотацией @OverZero!");
        }
    }

    /**
     * Метод обработки аннотации @AllEnglishChars
     * Общая логика - аналогична методу notEmpty(), поэтому отступы в различиях
     */
    public void allEnglishChars(Object transport, Field classField, Class<?> currentClass) {
        Field nameField = null;
        try {
            nameField = currentClass.getDeclaredField(classField.getName());
            nameField.setAccessible(true);
        } catch (NoSuchFieldException exc) {
            System.out.println("Не найдено поле, к которому должна была быть применена аннотация @AllEnglishChars!");
        }
        try {
            if (Objects.requireNonNull(nameField).get(transport) != null) {         //Если в значении валидируемого поля не null - проверяем
                String s = nameField.get(transport).toString();     //Передаем содержимое поля в строку
                /*Заводим переменную-флаг наличия кириллических символов*/
                boolean cyrillic = s.chars()    //Разбиваем переданную строку в поток символов char
                        .mapToObj(Character.UnicodeBlock::of)   //Мапим объекты в символы юникод
                        .anyMatch(b -> b.equals(Character.UnicodeBlock.CYRILLIC));  //Проверяем наличие хотя бы одного киррилического символа юникода
                if (cyrillic) { //Если флаг принял значение true - выводим ворнинг
                    System.out.println("WARN: Поле " + nameField.getName() + " не должно содержать русских символов!");
                }
            }
        } catch (IllegalAccessException ex) {
            System.out.println("Не удалось получить доступ к полю с аннотацией @AllEnglishChars!");
        }
    }
}