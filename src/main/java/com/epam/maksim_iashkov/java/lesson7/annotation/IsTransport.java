package com.epam.maksim_iashkov.java.lesson7.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация для классов: класс должен наследоваться от асбтрактного класса Transport
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface IsTransport {
}