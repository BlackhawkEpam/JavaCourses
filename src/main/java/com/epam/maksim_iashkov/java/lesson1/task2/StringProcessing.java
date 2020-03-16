package com.epam.maksim_iashkov.java.lesson1.task2;
import java.util.Scanner;

public class StringProcessing {

    Scanner scanner = new Scanner(System.in);

    String[] strings;
    int n = 0;
    public StringProcessing() {this.strings = inputStrings();}

    private String[] inputStrings() {

        System.out.println("Введите количество строк: ");
        int n = 0;

        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.print("Введены некорректные данные!");
            System.exit(0);
        }
        //String[] strings = new String[n];
/*
        for (int i = 0; i < n; i++) {
            System.out.print("Введите строку номер " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }
        return strings ;
*/
        //System.out.println("Введите n - количество строк");

            //n = Integer.valueOf(scanner.nextLine());

        String[] strings = new String[n];
        //System.out.println("Введите строки");

        for (int i = 0; i < n; i++) {
            System.out.print("Введите строку номер " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }
        return strings;
    }

    public void shortestAndLongest(){
        System.out.print("\n");

        String[] withoutprobels = new String[strings.length];
        String shortest=strings[0];
        String longest=strings[0];

        for (int i=0; i< strings.length; i++){
            withoutprobels[i] = strings[i].replaceAll(" ", "");
            if (withoutprobels[i].length() < shortest.length()){
                shortest = withoutprobels[i];
            }

        }

        for (int i=0; i< strings.length; i++){
            withoutprobels[i] = strings[i].replaceAll(" ", "");
            if (withoutprobels[i].length() > longest.length()){
                longest = withoutprobels[i];
            }
        }
        System.out.print("Самая короткая строка: "+shortest+"\n");
        System.out.print("Длина самой короткой строки: "+shortest.length()+"\n");
        System.out.print("Самая длинная строка: "+longest+"\n");
        System.out.print("Длина самой длинной строки: "+longest.length());
    }

    public void moreThanAvg() {

        System.out.print("\n");

        String[] withoutprobels = new String[strings.length];
        double sum = 0.00;
        double avg = 0.00;

        for (int i = 0; i < strings.length; i++) {
            withoutprobels[i] = strings[i].replaceAll(" ", "");
            sum = sum + withoutprobels[i].length();
        }
        avg = sum / strings.length;

        System.out.println("Сумма длинн всех строк: "+sum);
        System.out.println("Средняя длинна: "+avg);

        for (int i = 0; i < strings.length; i++) {
            if (withoutprobels[i].length() > avg) {
                System.out.print("Строка с длинною больше среднего: "+withoutprobels[i]+" Ее длинна: "+withoutprobels[i].length()+"\n");
            }
        }
    }

    public void lessThanAvg() {

        System.out.print("\n");

        String[] withoutprobels = new String[strings.length];
        double sum = 0.00;
        double avg = 0.00;

        for (int i = 0; i < strings.length; i++) {
            withoutprobels[i] = strings[i].replaceAll(" ", "");
            sum = sum + withoutprobels[i].length();
        }
        avg = sum / strings.length;

        System.out.println("Сумма длинн всех строк: "+sum);
        System.out.println("Средняя длинна: "+avg);

        for (int i = 0; i < strings.length; i++) {
            if (withoutprobels[i].length() < avg) {
                System.out.print("Строка с длинною меньше среднего: "+withoutprobels[i]+" Ее длинна: "+withoutprobels[i].length()+"\n");
            }
        }
    }

}
