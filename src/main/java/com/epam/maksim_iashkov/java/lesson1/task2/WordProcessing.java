package com.epam.maksim_iashkov.java.lesson1.task2;
import java.util.Scanner;

public class WordProcessing {

    Scanner scanner = new Scanner(System.in);

    String[] words;
    public WordProcessing() {this.words = inputWords();}

    private String[] inputWords(){
        System.out.println("Программа работы со словами. Слова - последовательности символов, разделенные между собой пробелами или Enter. При вводе количества слов больше, чем n - последующие слова за n обрезаются");
        System.out.println("Введите n - количество слов");
        int n = Integer.valueOf(scanner.nextLine());

        String[] words = new String[n];

        System.out.println("Введите слова (через пробел или Enter)");

        for(int i = 0; i < n; i++) {
            //System.out.print("Введите слово номер " + (i + 1) + ": ");
            words[i] = scanner.next();
        }
        System.out.println("Введенные слова:");
        for (int i = 0; i < words.length ; i++){
            System.out.println(words[i]);}

        System.out.println("Следующие слова не будут учитываться при обработке:");
        for (int i = 0; i < words.length ; i++){
            if (words[i].length() < 3) {
                System.out.println(words[i]);
                words[i] = null ;
            }
        }

        return words;
    }

    public void differentSymbols(){
        System.out.println("Проектируемый метод");
        System.out.println("Проверка того, что слова меньше 3 символов убраны:");
        for (int i = 0; i < words.length ; i++) {
            if (words[i] != null) {
                System.out.println(words[i]);
            }
        }
    }

}
