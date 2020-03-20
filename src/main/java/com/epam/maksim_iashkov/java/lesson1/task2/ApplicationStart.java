package com.epam.maksim_iashkov.java.lesson1.task2;

/**
 * Класс, реализующий входную точку для запуска программы
 * @version 19.03.2020
 * @author Maksim_Iashkov
 */
public class ApplicationStart {

	/**Метод main - входная точка программы*/
    public static void main(String[] args) {
	new StringProcessing().shortestAndLongest();
	new StringProcessing().moreThanAvg();
	new StringProcessing().lessThanAvg();
    }
}
