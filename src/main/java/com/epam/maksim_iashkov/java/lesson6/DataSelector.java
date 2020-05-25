package com.epam.maksim_iashkov.java.lesson6;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс для создания отчета по сгенерированным данным
 */
public class DataSelector {

    private Scanner scanner = new Scanner(System.in);                                       //Инициализация сканера
    private Connection conn;                                                                //Инициализация коннекта к БД/серверу
    private Statement st;                                                                   //Инициализация на указатель сессии

    /**
     * Метод задания последовательности шагов выполнения и проверок при создании отчета
     */
    public void startSelect() {
        boolean checkVEpamke = false;   //Указатель на наличие БД vepamke

        System.out.println("Отчёт об уникальных именах пользователей, имеющих более 100 друзей на март 2015 года и в среднем [3;15) лайков за посты");

        try {
            /*Блок установления коннекта и сессия с сервером*/
            conn = DriverManager.getConnection(DataCreator.URL, DataCreator.USER_NAME, DataCreator.PASSWORD);
            st = conn.createStatement();

            System.out.println("Установлено соединение с сервером СУБД");
            System.out.println("Введите что-либо для построения и выведения отчёта");
            scanner.nextLine();     //Для оговоренной возможности просмотра созданных данных перед выведением отчета

            /*Проверка наличия БД vepamke*/
            ResultSet check_DB = st.executeQuery("SELECT datname FROM pg_database;");   //Вывести все БД с сервера
            while (check_DB.next()) {
                if (check_DB.getString(1).equals("vepamke")) {
                    checkVEpamke = true;    //Если нужная БД есть - сменить флаг
                    break;
                }
            }
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
            DataCreator.closeSession(conn, st);
            return;
        }

        if (!checkVEpamke) {    //Если искомая БД не найдена - то не из чего строить отчет
            System.out.println("Требуемая база данных VEpamke отсутствует!");
            DataCreator.closeSession(conn, st);
            return;
        }

        if (checkTables()) {    //Проверка наличия и заполненности 4 требуемых таблиц
            System.out.println("Итоговая выборка результирующего запроса будет пуста!");
            return;
        }
        implementQuery();   //Вызов метода для SELECT-запроса и построения отчета
    }

    /**
     * Метод проверки целостности таблиц, если хоть одна таблица пуста/недоступна/удалена - вернет false
     */
    public boolean checkTables() {
        return ((checkEmpty("SELECT * FROM users")) |
                (checkEmpty("SELECT * FROM friendships")) |
                (checkEmpty("SELECT * FROM posts")) |
                (checkEmpty("SELECT * FROM likes")));
    }

    /**
     * Метод непосредственной отправки SELECT-запроса и выведения результата в консоль
     */
    public void implementQuery() {
        ArrayList<String> result = new ArrayList<>();   //Список искомых имен по заданию
        try {
            /*Соединяемся к БД*/
            conn = DriverManager.getConnection(DataCreator.DB_URL, DataCreator.USER_NAME, DataCreator.PASSWORD);
            st = conn.createStatement();

            /*Сам селект на выведение искомых пользователей*/
            String SQL_query = "SELECT DISTINCT u.name FROM users u JOIN\n" +
                    "((SELECT uid FROM (SELECT u.id as uid, count(l.userid) as lk FROM users u LEFT JOIN posts p ON u.id = p.userid LEFT JOIN likes l ON p.id = l.postid\n" +
                    "GROUP BY u.id, p.id) AS lik\n" +
                    "GROUP BY uid\n" +
                    "HAVING 3 <= avg(lk) AND avg(lk) < 15)\n" +
                    "INTERSECT\n" +
                    "(SELECT uid FROM (SELECT u.id as uid, f.userid2 as friend FROM users u LEFT JOIN friendships f ON u.id = f.userid1\n" +
                    "WHERE f.timestamp <= '2015-03-31') AS frnd\n" +
                    "GROUP BY uid\n" +
                    "HAVING count(friend) > 100)) AS preuid\n" +
                    "ON u.id = uid";

            ResultSet resultSet = st.executeQuery(SQL_query);   //Выполняем селект
            while (resultSet.next()) {  //Перемещаем указатель чтения для рекорд-сета
                result.add(resultSet.getString(1));     //Построчно записываем имена в список
            }
            resultSet.close();
            DataCreator.closeSession(conn, st);
            System.out.println("Список искомых имён:");
            System.out.println(result);     //Выводим искомый список имён в консоль
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
            DataCreator.closeSession(conn, st);
        }
    }

    /**
     * Метод проверки наличия/целостности конкретной таблицы
     */
    public boolean checkEmpty(String query) {
        try {
            /*Коннект к нужной БД*/
            conn = DriverManager.getConnection(DataCreator.DB_URL, DataCreator.USER_NAME, DataCreator.PASSWORD);
            st = conn.createStatement();
            ResultSet check_Tables = st.executeQuery(query);    //Делаем SELECT * FROM нужная таблица
            if (!check_Tables.next()) { //Если рекорд-сет на выборку из таблицы пуст - оповещаем
                System.out.println("После выполнения запроса: " + query + " - было выявлено, что таблица пуста!");
                check_Tables.close();
                return true;
            }
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
            DataCreator.closeSession(conn, st);
            return true;
        }
        DataCreator.closeSession(conn, st);
        return false;
    }
}