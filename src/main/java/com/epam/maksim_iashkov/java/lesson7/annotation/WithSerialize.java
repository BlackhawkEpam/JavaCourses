package com.epam.maksim_iashkov.java.lesson7.annotation;

import java.lang.annotation.*;

/**
 * Аннотация для классов: класс должен быть сериализуемым
 */
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface WithSerialize {
}