package com.epam.maksim_iashkov.java.lesson6;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Класс для создания БД, таблиц и генерации рандомных данных
 */
public class DataCreator {

    public static final String URL = "jdbc:postgresql://127.0.0.1:5432/";              //URL для соединения с сервером
    public static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/vepamke";    //URL соединения к созданной БД
    public static final String USER_NAME = "postgres";                                 //Логин пользователя
    public static final String PASSWORD = "root";                                      //Пароль пользователя
    private static final String getUserId = "SELECT u.Id FROM Users u;";                //SELECT для метода поиска PK
    private Random random = new Random();                                               //Инициализация рандома
    private Scanner scanner = new Scanner(System.in);                                   //Инициализация сканера
    private Connection conn;                                                            //Инициализация коннекта к БД/серверу
    private Statement st;                                                               //Инициализация на указатель сессии
    private PreparedStatement preparedStatement;                                        //Инициализация стейтмента для инсертов
    private int minDay;                                                                 //Минимальный день рандомных дат
    private int maxDay;                                                                 //Максимальный день рандомных дат

    /**
     * Метод, задающий последовательность шагов и проверок при генерации данных
     */
    public void starterSQL() {

        System.out.println("Создание и заполнение таблиц БД VEpamke случайными данными");

        try {
            /*Подключение коннекта к серверу*/
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            st = conn.createStatement();
            System.out.println("Установлено соединение с сервером СУБД");

            /*Проверка наличия БД vepamke на сервере, и очистка БД, если она есть*/
            ResultSet drop_DB = st.executeQuery("SELECT datname FROM pg_database;");    //Получить список всех БД на сервере
            while (drop_DB.next()) {
                if (drop_DB.getString(1).equals("vepamke")) {   //Если среди БД есть vepamke - удалить ее
                    st.executeUpdate("DROP DATABASE vepamke");
                    System.out.println("Была обнаружена и очищена БД VEpamke");
                    break;
                }
            }

            String SQL_CreateDB = "CREATE DATABASE vepamke";    //Создание БД vepamke
            st.executeUpdate(SQL_CreateDB);
            closeSession(conn, st);
            System.out.println("Успешно создана БД VEpamke");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            closeSession(conn, st);
            return;
        }

        System.out.println("Введите что-либо для создания и заполнения таблицы Users");
        scanner.nextLine();         //Для оговоренной возможности просмотра промежуточных шагов заполнения

        createUsers();      //Создание и заполнение таблицы пользователей

        System.out.println("Введите что-либо для создания и заполнения таблицы Friendships");
        scanner.nextLine();

        createFriendships();    //Создание и заполнение таблицы заявок в друзья

        System.out.println("Введите что-либо для создания и заполнения таблицы Posts");
        scanner.nextLine();

        createPosts();      //Создание и заполнение таблицы постов

        System.out.println("Введите что-либо для создания и заполнения таблицы Likes");
        scanner.nextLine();

        createLikes();      //Создание и заполнение таблицы лайков

        System.out.println("Создание и заполнение таблиц БД VEpamke закончено!");
    }

    /**
     * Метод создания и заполнения таблицы пользователей
     */
    public void createUsers() {

        ArrayList<String> femaleName = new ArrayList<>();       //Список женских имен
        ArrayList<String> femaleSurname = new ArrayList<>();    //Список женских фамилий
        ArrayList<String> maleName = new ArrayList<>();         //Список мужских имен
        ArrayList<String> maleSurname = new ArrayList<>();      //Список мужских фамилий
        int sex;    //Пол рандомного человека, для которого будет сгенерено ФИО

        try {
            /*Коннект уже к БД*/
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            st = conn.createStatement();

            String SQL_CreateUsers = "CREATE TABLE Users (" +
                    "Id SERIAL PRIMARY KEY," +
                    "Name CHARACTER VARYING(30)," +
                    "Surname CHARACTER VARYING(30)," +
                    "Birthday timestamp" +
                    ")";

            st.executeUpdate(SQL_CreateUsers);      //Запрос на создание таблицы пользователей

            /*Задание диапазона для генерации рандомных дат*/
            minDay = (int) LocalDate.of(1980, 1, 1).toEpochDay();
            maxDay = (int) LocalDate.of(2000, 1, 1).toEpochDay();

            addNameDirs(femaleName, femaleSurname, maleName, maleSurname);  //Заполнение списков ФИ

            String SQL_InsertUsers = "INSERT INTO Users (Name, Surname, Birthday) Values (?, ?, ?)";    //Инсерт-запрос с препейр-стэйтментом
            preparedStatement = conn.prepareStatement(SQL_InsertUsers);

            for (int i = 0; i < 1100; i++) {    //Генерация 1100 пользователей

                long randomDay = minDay + random.nextInt(maxDay - minDay);  //Генерация рандомного дня и упаковка его в лонг-число
                LocalDate Birthday = LocalDate.ofEpochDay(randomDay);   //Перевод лонг числа в LocalDate
                Timestamp timestamp = Timestamp.valueOf(Birthday.atStartOfDay());   //Приведение типов из LocalDate в Timestamp

                sex = random.nextInt(2);    //Генерация рандомного пола

                preparedStatement.setTimestamp(3, timestamp);   //Заполнить дату
                if (sex == 1) {     //Если переменная пола = 1 - заполнить ФИ женскими значениями из списка
                    preparedStatement.setString(1, femaleName.get(random.nextInt(femaleName.size())));
                    preparedStatement.setString(2, femaleSurname.get(random.nextInt(femaleSurname.size())));
                } else {    //Иначе - мужскими
                    preparedStatement.setString(1, maleName.get(random.nextInt(maleName.size())));
                    preparedStatement.setString(2, maleSurname.get(random.nextInt(maleSurname.size())));
                }
                preparedStatement.addBatch();   //Добавляем i-ый инсерт в батч-пакет
            }
            preparedStatement.executeBatch();   //Отправляем собранный батч-пакет в БД одной транзакцией на исполнение
            preparedStatement.close();          //Закрываем preparedStatement
            closeSession(conn, st);
            System.out.println("Таблица Users успешно создана и заполнена данными");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            closeSession(conn, st);
        }
    }

    /**
     * Создание и заполнении таблицы заявок в друзья
     * Логика аналогична вышеописанному методу, отступы в отличающихся местах
     */
    public void createFriendships() {

        ArrayList<Integer> fsId1 = new ArrayList<>();   //Список айдишников 1 столбца
        ArrayList<Integer> fsId2 = new ArrayList<>();   //Список айдишников 2 столбца
        ArrayList<Integer> user_id = new ArrayList<>(); //Список имеющихся PK в таблице пользаков

        try {
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            st = conn.createStatement();

            getPrimaryKey(user_id, getUserId);  //Сделать селект к таблице Users и получить список ключей оттуда

            /*Если PK в таблице пользаков нет - то и некому дружить =) */
            if (user_id.size() == 0) {
                System.out.println("Список первичных ключей таблицы Users пуст!");
                return;
            }

            String SQL_CreateFriendships = "CREATE TABLE Friendships (" +
                    "Userid1 INTEGER," +
                    "Userid2 INTEGER," +
                    "Timestamp timestamp," +
                    "FOREIGN KEY (Userid1) REFERENCES Users (id)," +
                    "FOREIGN KEY (Userid2) REFERENCES Users (id)" +
                    ")";

            st.executeUpdate(SQL_CreateFriendships);

            minDay = (int) LocalDate.of(2010, 1, 1).toEpochDay();
            maxDay = (int) LocalDate.of(2015, 4, 15).toEpochDay();

            String SQL_InsertFriendships = "INSERT INTO Friendships (userid1, userid2, Timestamp) Values (?, ?, ?)";
            preparedStatement = conn.prepareStatement(SQL_InsertFriendships);

            for (int i = 0; i < 85000; i++) {   //Создание 85000 заявок в друзья

                addFsId(user_id, fsId1, fsId2, i);          //Генерация 85000 пар айдишников друзей

                long randomDay = minDay + random.nextInt(maxDay - minDay);
                LocalDate Birthday = LocalDate.ofEpochDay(randomDay);
                Timestamp timestamp = Timestamp.valueOf(Birthday.atStartOfDay());

                preparedStatement.setTimestamp(3, timestamp);
                preparedStatement.setInt(1, fsId1.get(i));
                preparedStatement.setInt(2, fsId2.get(i));
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
            closeSession(conn, st);
            System.out.println("Таблица Friendships успешно создана и заполнена данными");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            closeSession(conn, st);
        }
    }

    /**
     * Метод создания и заполнения таблицы постов
     */
    public void createPosts() {
        ArrayList<String> textPost = new ArrayList<>();     //Список фраз для постов, которые будут рандомно генериться в таблицу
        ArrayList<Integer> user_id = new ArrayList<>();     //Список PK из таблицы пользователей

        try {
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            st = conn.createStatement();

            /*Логика метода и проверки - полностью аналогична вышеописанному методу*/
            getPrimaryKey(user_id, getUserId);
            if (user_id.size() == 0) {
                System.out.println("Список первичных ключей таблицы Users пуст!");
                return;
            }

            addTextDirs(textPost);  //Заполнения списка тестов для постов

            String SQL_CreatePosts = "CREATE TABLE Posts (" +
                    "Id SERIAL PRIMARY KEY," +
                    "Userid INTEGER," +
                    "Text CHARACTER VARYING(30)," +
                    "Timestamp timestamp," +
                    "FOREIGN KEY (Userid) REFERENCES Users (Id)" +
                    ")";

            st.executeUpdate(SQL_CreatePosts);

            minDay = (int) LocalDate.of(2013, 1, 1).toEpochDay();
            maxDay = (int) LocalDate.of(2014, 1, 1).toEpochDay();

            String SQL_InsertPosts = "INSERT INTO Posts (Userid, Text, Timestamp) Values (?, ?, ?)";
            preparedStatement = conn.prepareStatement(SQL_InsertPosts);

            for (int i = 0; i < 91000; i++) {       //Генерация 91000 постов

                long randomDay = minDay + random.nextInt(maxDay - minDay);
                LocalDate Birthday = LocalDate.ofEpochDay(randomDay);
                Timestamp timestamp = Timestamp.valueOf(Birthday.atStartOfDay());

                preparedStatement.setInt(1, (user_id.get(random.nextInt(user_id.size()))));
                preparedStatement.setString(2, textPost.get(random.nextInt(textPost.size())));
                preparedStatement.setTimestamp(3, timestamp);
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
            closeSession(conn, st);
            System.out.println("Таблица Posts успешно создана и заполнена данными");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            closeSession(conn, st);
        }
    }

    /**
     * Создание и заполнение таблицы лайков к постам
     */
    public void createLikes() {
        ArrayList<Integer> post_id = new ArrayList<>();     //Список PK из таблицы постов
        ArrayList<Integer> user_id = new ArrayList<>();     //Список PK из таблицы юзеров

        try {
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            st = conn.createStatement();

            /*Логика - аналогична описанному в методе createFriendships*/
            getPrimaryKey(user_id, getUserId);
            if (user_id.size() == 0) {
                System.out.println("Список первичных ключей таблицы Users пуст!");
                return;
            }

            /*Получение айди-праймари кеев из таблицы постов и проверка, что их не 0 - иначе нечему ставить лайки*/
            String getPostId = "SELECT p.Id FROM Posts p;";
            getPrimaryKey(post_id, getPostId);
            if (post_id.size() == 0) {
                System.out.println("Список первичных ключей таблицы Posts пуст!");
                return;
            }

            String SQL_CreateLikes = "CREATE TABLE Likes (" +
                    "Postid INTEGER," +
                    "Userid INTEGER," +
                    "Timestamp timestamp," +
                    "FOREIGN KEY (Postid) REFERENCES Posts (Id)," +
                    "FOREIGN KEY (Userid) REFERENCES Users (Id)" +
                    ")";

            st.executeUpdate(SQL_CreateLikes);

            minDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
            maxDay = (int) LocalDate.of(2015, 12, 31).toEpochDay();

            String SQL_InsertLikes = "INSERT INTO Likes (Postid, Userid, Timestamp) Values (?, ?, ?)";
            preparedStatement = conn.prepareStatement(SQL_InsertLikes);

            for (int i = 0; i < 310000; i++) {      //Генерация 310000 лайков

                long randomDay = minDay + random.nextInt(maxDay - minDay);
                LocalDate Birthday = LocalDate.ofEpochDay(randomDay);
                Timestamp timestamp = Timestamp.valueOf(Birthday.atStartOfDay());

                preparedStatement.setInt(1, (post_id.get(random.nextInt(post_id.size()))));
                preparedStatement.setInt(2, (user_id.get(random.nextInt(user_id.size()))));
                preparedStatement.setTimestamp(3, timestamp);
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
            closeSession(conn, st);
            System.out.println("Таблица Likes успешно создана и заполнена данными");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            closeSession(conn, st);
        }
    }

    /**
     * Метод заполнения списков мужских и женских ФИ
     */
    public void addNameDirs(ArrayList<String> femaleName, ArrayList<String> femaleSurname, ArrayList<String> maleName, ArrayList<String> maleSurname) {

        maleName.add("Александр");
        maleName.add("Василий");
        maleName.add("Владимир");
        maleName.add("Максим");
        maleName.add("Святослав");
        maleName.add("Николай");
        maleName.add("Виктор");
        maleName.add("Андрей");
        maleName.add("Никита");
        maleName.add("Дмитрий");

        maleSurname.add("Кобзев");
        maleSurname.add("Акопашвили");
        maleSurname.add("Яшков");
        maleSurname.add("Фирсанов");
        maleSurname.add("Борисов");
        maleSurname.add("Иванов");
        maleSurname.add("Жуков");
        maleSurname.add("Баранов");
        maleSurname.add("Глызин");
        maleSurname.add("Кузнецов");

        femaleName.add("Анастасия");
        femaleName.add("Анна");
        femaleName.add("Ольга");
        femaleName.add("Екатерина");
        femaleName.add("Светлана");
        femaleName.add("Варвара");
        femaleName.add("Пелагея");
        femaleName.add("Полина");
        femaleName.add("Любовь");
        femaleName.add("Вероника");

        femaleSurname.add("Иванова");
        femaleSurname.add("Петрова");
        femaleSurname.add("Стрельцова");
        femaleSurname.add("Прохорова");
        femaleSurname.add("Телегина");
        femaleSurname.add("Чернышова");
        femaleSurname.add("Савельева");
        femaleSurname.add("Никитина");
        femaleSurname.add("Зверева");
        femaleSurname.add("Кузнецова");
    }

    /**
     * Метод заполнения списка текстов к постам
     */
    public void addTextDirs(ArrayList<String> textPost) {

        textPost.add("Всем привет!");
        textPost.add("Урааааа! Сдал экзамен");
        textPost.add("Скучно...");
        textPost.add("Уехали на отдых");
        textPost.add("Доколе?");
        textPost.add("Поздравляю с днем рождения!");
        textPost.add("Верю в себя");
        textPost.add("Барселона - вперед!");
        textPost.add("В центре идет очумелый дождь");
        textPost.add("Камеди Клаб - отстой!");
    }

    /**
     * Метод заполнения пары id друзей в списки
     */
    public void addFsId(ArrayList<Integer> User_id, ArrayList<Integer> FsId1, ArrayList<Integer> FsId2, int i) {
        FsId1.add(User_id.get(random.nextInt(User_id.size())));
        FsId2.add(User_id.get(random.nextInt(User_id.size())));
        if (FsId1.get(i).equals(FsId2.get(i))) {    //Проверяем, что не сгерились два одинаковых числа - человек сам с собой дружить не может
            FsId1.remove(i);        //Если сгенерилось - удаляем тут же заполненную пару
            FsId2.remove(i);
            addFsId(User_id, FsId1, FsId2, i);      //И повторяем генерацию для этого i
        }
    }

    /**
     * Метод для закрытия переменных коннекта и сессии - и обработка исключений
     */
    public static void closeSession(Connection conn, Statement st) {
        if (conn != null) {
            try {
                conn.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Не удалось осуществить корректное закрытие соединения с сервером!");
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * Метод получения PK из таблицы и заполнения их в список
     */
    public void getPrimaryKey(ArrayList<Integer> listPK, String querySQL) {
        try {
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            st = conn.createStatement();
            ResultSet queryResult = st.executeQuery(querySQL);
            while (queryResult.next()) {
                listPK.add(queryResult.getInt(1));
            }
            queryResult.close();
        } catch (SQLException ex) {
            System.out.println("При попытке считать табличные Primary key произошла ошибка!");
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
            closeSession(conn, st);
        }
    }
}