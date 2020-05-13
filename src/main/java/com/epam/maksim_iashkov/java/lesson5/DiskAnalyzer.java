package com.epam.maksim_iashkov.java.lesson5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Класс, в котором реализованы методы утилиты DiskAnalyzer
 */
public class DiskAnalyzer {

    /**
     * Стартовый метод утилиты, который общается с пользователем через консоль
     */
    public void startAnalyze() {

        Scanner scanner = new Scanner(System.in);   //Создание сканнера
        int function;   //Номер вызываемой из консоли функции
        ArrayList<File> files;  //Список содержимого введенной в консоль директории для анализа
        ArrayList<String> listResult;   //Список с результатом отработки методов, которые мы запишем в итоговый файл

        System.out.println("Введите абсолютный путь к директории диска 'C' :");

        File dir = new File((scanner.nextLine()).trim());   //Считываем директорию для анализа с консоли
        if (checkInputDirException(dir)) {      //Проверяем директорию на эксепшены, и если они есть - выходим из метода
            return;
        }

        try {
            files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(dir.listFiles())));    //Проверяем возможность наполнить список содержимого введенной директории
            //Исключение выкидывает, если у Windows-user'а нет доступа к папке
        } catch (NullPointerException npe) {
            System.out.println("Не удалось получить доступ к содержимому директории!");
            return;
        }

        if (files.size() == 0) {        //Проверяем, есть ли что либо в папке, если нет - выводим инфо-месседж
            System.out.println("Введена пустая директория!");
            return;
        }

        System.out.println("Введите абсолютный путь к директории на диске 'C', в которую будет сохранен файл с результатом: ");

        File dirResult = new File((scanner.nextLine()).trim());     //Считываем директорию для сброса файла с результатом с консоли
        if (checkInputDirException(dirResult)) {        //Проверяем директорию на эксепшены
            return;
        }

        File result = new File(dirResult, "result.txt");    //Создаем итоговый файл для вывода результата

        System.out.println("Утилита выполняет следующие функции:");
        System.out.println("1) Поиск имени файла с максимальным количеством букв ‘s’ в имени, вывод пути к нему");
        System.out.println("2) Top-5 файлов с самым большим размером");
        System.out.println("3) Средний размер файла в указанной директории или любой ее поддиректории");
        System.out.println("4) Количество файлов и папок разбитое по первым буквам алфавита");
        System.out.println("Введите номер функции: ");

        try {
            function = scanner.nextInt();   //Считываем номер функции с консоли и сразу проверяем на эксепшены
        } catch (InputMismatchException exc) {
            System.out.println("Номер функции должен быть задан целым числом!");
            return;
        }

        /*Блок условной конструкции для вызова того метода, который был выбран по номеру в консоли*/
        switch (function) {
            case 1:
                listResult = letterSCount(files);   //Подсчет букв s/S
                break;
            case 2:
                listResult = sizeTOP5(files);   //ТОП-5 файлов по размеру
                break;
            case 3:
                listResult = averageSize(files);    //Средний размер всех файлов в папке и ее подпапках
                break;
            case 4:
                listResult = letterOrder(files);    //Группировка файлов и папок по буквам алфавитов
                break;
            default:
                System.out.println("Введено некорректное значение номера функции!");
                return;
        }

        try {
            FileWriter writeResult = new FileWriter(result);    //Создание новой записи в файл result (определенного выше)

            for (String line : listResult) {
                writeResult.write(line);        //Записать построчно в файл список listResult
                writeResult.write(System.getProperty("line.separator"));    //Разделение на строки
            }
            writeResult.flush();        //Не оставлять ничего в буфере в случае срыва чтения
            writeResult.close();        //Закрытие потока
        } catch (IOException except) {
            except.getMessage();
        } finally {
            if (result.exists()) {  //Проверка существования итогового файла
                System.out.println("Файл с результатом работы утилиты успешно создан!");  //Месседж если он есть
            } else {
                System.out.println("В ходе работы утилиты результирующий файл создан не был!"); //И если его нет
            }
        }
    }

    /**
     * Метод проверки на эксепшены введенной директории в консоль
     */
    public boolean checkInputDirException(File inputDir) {
        boolean problem;    //Флаг возникновения эксепшена
        try {
            char firstLetter = (inputDir.getAbsolutePath().charAt(0));  //Проверка первого символа директории - диска
            if ((firstLetter != 'C') & (firstLetter != 'c'))
                throw new FileNotFoundException("Утилита работает для диска 'C' рабочей машины!");  //Эксепшен, если введен не диск С
            if (!inputDir.exists())
                throw new FileNotFoundException("Директория не найдена!");  //Директории не существует
            if (!inputDir.isDirectory())
                throw new FileNotFoundException("Введён файл, а не директория!");  //Если введена не директория
            problem = false;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            problem = true;
        }
        return problem;
    }

    /**
     * Метод подсчета букв s/S в названии файлов
     */
    public ArrayList<String> letterSCount(ArrayList<File> file) {

        int maxS = 1;   //Переменная для хранения максимального количества букв s в названии файла

        ArrayList<String> listResult = new ArrayList<>();   //Список инфо-месседжей, который будет записан в итоговый файл
        ArrayList<String> fileShortName = new ArrayList<>();    //Список наименований файлов без расширений
        ArrayList<String> listMaxSName = new ArrayList<>();     //Список наименований файлов с максимумом букв s
        ArrayList<String> listMaxSPath = new ArrayList<>();     //Список путей файлов с максимумом букв s


        /*Наполнение списка fileShortName: поочередно берем имена файлов и обрезаем их расширение методом removeExtension*/
        for (File value : file) {
            if (!(value.isDirectory())) {
                fileShortName.add(removeExtension(value.getName()));
            }
        }

        /*Блок проверки наименований файлов*/
        for (String s : fileShortName) {
            int countS = 0; //Промежуточный счетчик букв s в названии файла
            for (char element : s.toCharArray()) {
                if ((element == 's') | (element == 'S')) {
                    countS++;
                }
            }
            if (countS == maxS) {   //Если кол-во s в названии файла одинаково с уже максимальным - добавить в список
                listMaxSName.add(s);
                maxS = countS;
            }
            if (countS > maxS) {    //Если у этого файла букв s больше - очистить список и добавить туда название этого файла
                listMaxSName.clear();
                listMaxSName.add(s);
                maxS = countS;
            }
        }

        if (listMaxSName.size() == 0) { //Если выяснилось, что нет файла хотя бы с одной буквой s
            listResult.add("Файлы с буквой s/S в наименовании отсутствуют!");
        } else {    //Иначе - собрать пути файлов с максимумом букв s
            for (String s : listMaxSName) {
                for (File value : file) {
                    if (s.equals(removeExtension(value.getName()))) {
                        listMaxSPath.add(value.getAbsolutePath());
                    }
                }
            }
            listResult.add("Максимальное количество букв s/S: " + maxS);    //Вывести максимум букв s
        }

        for (int i = 0; i < listMaxSName.size(); i++) { //Вывести названия этих файлов и их путь
            listResult.add("Имя файла с наибольшим количеством s/S: " + listMaxSName.get(i) + " и его путь: " + listMaxSPath.get(i));
        }
        return listResult;
    }

    /**
     * Метод удаления расширений в наименовании файлов
     */
    public static String removeExtension(String fileExtension) {
        int index1 = fileExtension.indexOf('.');
        if (index1 < 1) {
            index1 = fileExtension.length();
        }
        return fileExtension.substring(0, index1);
    }

    /**
     * Метод подсчета среднего размера в папке и ее подпапках
     */
    public ArrayList<String> averageSize(ArrayList<File> files) {

        ArrayList<Long> fileSizes = new ArrayList<>();      //Список размеров файлов, в который мы будем добавлять .length() файлов
        ArrayList<String> listResult = new ArrayList<>();   //Список инфо-месседжей, который будет записан в итоговый файл

        addSize(files, fileSizes);  //Вызов метода обхода файлов в папке, добавляющего размеры файлов

        double sizeAVG = fileSizes.stream().mapToDouble(Long::doubleValue).average().orElse(0); //Вычислить средний размер файла стримом
        listResult.add("Средний размер файлов в директории и всех ее поддиректориях = " + sizeAVG + " байт");   //Добавить инфо-месседж в выходной файл
        return listResult;
    }

    /**
     * Метод обхода файлов в папке и добавления их размеров в список
     */
    public void addSize(ArrayList<File> files, ArrayList<Long> listSize) {

        ArrayList<File> subFile;    //Список файлов в попдпапке, если она оказалась директорией

        for (File file : files) {
            if (!file.isDirectory()) {
                listSize.add(file.length());    //Если файл не директория - добавить его размер в список
            } else {
                try {
                    subFile = new ArrayList<>(Arrays.asList(Objects.requireNonNull(file.listFiles()))); //Если файл - директория, то вывести список ее внутренних файлов
                    addSize(subFile, listSize);     //И рекурсивно вызвать для нее этот же текущий метод
                } catch (NullPointerException npe) {
                    System.out.println("В процессе работы не удалось получить доступ к содержимому отдельных вложенных директорий");
                }
            }
        }
    }

    /**
     * Метод поиска ТОП-5 самых больших файлов в папке
     */
    public ArrayList<String> sizeTOP5(ArrayList<File> filesDirs) {

        int count = 0;  //Количество файлов, которое выводим в итоговый лист
        int TOP = 5;    //Очерчиваем количество файлов, которое мы выводим в ТОП

        ArrayList<Long> sizes = new ArrayList<>();              //Список размеров всех файлов
        ArrayList<File> files1 = new ArrayList<>();             //Список самих файлов без директорий
        ArrayList<File> listOfTOP5 = new ArrayList<>();         //Список файлов-сущностей, попавших в ТОП
        ArrayList<String> fileNamesTOP5 = new ArrayList<>();    //Список наименований файлов из ТОПа
        ArrayList<String> filePathsTOP5 = new ArrayList<>();    //Список путей файлов из ТОПа
        ArrayList<String> listResult = new ArrayList<>();       //Список инфо-месседжей, который будет записан в итоговый файл

        /*Отсеиваем папки из переданной в консоли директории*/
        for (File filesDir : filesDirs) {
            if (!filesDir.isDirectory()) {
                files1.add(filesDir);
            }
        }

        /*Собираем размеры файлов из списка*/
        for (File value : files1) {
            sizes.add(value.length());
        }

        sizes.sort(Collections.reverseOrder()); //Сортируем размеры по убыванию

        /*Наполняем список файлов, попавших в ТОП-5*/
        //Для каждого файла сверяем его размер с размерами из ТОП-5, и если он совпадаем - добавляем его в список
        //Список ограничиваем 5 на случай, если файлов с одинаковым размером будет больше
        try {
            for (int j = 0; j < TOP; j++) {
                for (File file : files1) {
                    if ((count < TOP) & (file.length() == sizes.get(j))) {
                        listOfTOP5.add(file);
                        count++;
                    }
                }
            }
        } catch (IndexOutOfBoundsException exc) {   //Ловим эксепшен, если файлов меньше 5
            System.out.println("В введенной директории меньше 5 файлов!");
            listResult.add("В введенной директории меньше 5 файлов!");
            return listResult;
        }

        /*Для файлов из ТОП собираем их наименования и пути*/
        for (File file : listOfTOP5) {
            fileNamesTOP5.add(removeExtension(file.getName()));
            filePathsTOP5.add(file.getAbsolutePath());
        }

        /*Вывод инфо-месседжа и имен+путей файла в итоговый лист*/
        listResult.add("ТОП-5 файлов по размеру: ");
        for (int i = 0; i < listOfTOP5.size(); i++) {
            listResult.add("Имя файла: " + fileNamesTOP5.get(i) + " и его путь: " + filePathsTOP5.get(i));
        }
        return listResult;
    }

    /**
     * Метод группировки файлов и папок по первым буквам наименования
     */
    public ArrayList<String> letterOrder(ArrayList<File> fileEntity) {

        int count = 0;  //Счетчик, показывающий, сколько раз папка/файл начинается на конкретную букву

        char[] letters = new char[59];  //Задание массива чаров - букв русского и английского алфавита
        ArrayList<String> files = new ArrayList<>();        //Список файлов в переданной директории
        ArrayList<String> dirs = new ArrayList<>();         //Список папок в переданной директории
        ArrayList<Integer> filesCount = new ArrayList<>();  //Список количества файлов, начинающихся на определенную букву
        ArrayList<Integer> dirsCount = new ArrayList<>();   //Список количества папок, начинающихся на определенную букву
        ArrayList<String> listResult = new ArrayList<>();   //Список инфо-месседжей, который будет записан в итоговый файл

        for (int i = 0; i < 26; i++) {
            letters[i] = (char) ('A' + i);            //Английский алфавит
        }
        for (int i = 26; i < 32; i++) {
            letters[i] = (char) ('А' + i - 26);            //Русский алфавит
        }
        letters[32] = 'Ё';                                  //Отдельно буква ё - её нет в стандартном ряду чаров

        for (int i = 33; i < letters.length; i++) {     //Продолжение для русского алфавита
            letters[i] = (char) ('А' + i - 27);
        }

        /*Сортировка папок и файлов по отдельным спискам*/
        for (File entity : fileEntity) {
            if (entity.isDirectory()) {
                dirs.add(entity.getName());
            } else {
                files.add(entity.getName());
            }
        }

        /*Подсчет количества файлов, которые начинаются на текущую букву - и запись этого числа в filesCount*/
        for (char c : letters) {    //Проверка поочередно для каждой буквы
            for (String file : files) {     //Для каждого файла
                if ((c == file.charAt(0)) || (Character.toLowerCase(c) == file.charAt(0))) {
                    count++;
                }
            }
            filesCount.add(count);
            count = 0;
        }

        /*Аналогично для папок*/
        for (char letter : letters) {
            for (String s : dirs) {
                if ((letter == s.charAt(0)) || (Character.toLowerCase(letter) == s.charAt(0))) {
                    count++;
                }
            }
            dirsCount.add(count);
            count = 0;
        }

        /*Записываем получившийся результат в выходной лист*/
        for (int i = 0; i < letters.length; i++) {
            listResult.add("На букву " + letters[i] + " начинается " + filesCount.get(i) + " файлов и " + dirsCount.get(i) + " папок");
        }
        return listResult;
    }
}