package com.epam.maksim_iashkov.java.lesson7.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация для классов: класс должен быть сериализуемым
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface WithSerialize {
}