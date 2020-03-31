package lesson2;

import java.sql.*;

public class MainClass {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MainClass.Conn();
        MainClass.CreateTable();
        MainClass.WriteDB();
        MainClass.ReadDB();
        MainClass.CloseDB();
    }

    //ПОДКЛЮЧЕНИЕ
    public static void Conn() throws ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");// в современных драйверах не нужно
        String connectionURL = "jdbc:mysql://localhost:3306/shop";
        conn = DriverManager.getConnection(connectionURL, "root", "root");
        System.out.println("Ready!");
    }

    //СОЗДАЕМ ТАБЛИЦУ
    public static void CreateTable() throws SQLException {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists users (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(100) NULL, phone INT NULL, PRIMARY KEY( id));");
        System.out.println("Table ready!");
    }

    //ЗАПОЛНЕНИЕ
    public static void WriteDB() throws SQLException {
        statmt.execute("INSERT INTO users (name, phone) VALUES ('Petya', 125453); ");
        statmt.execute("INSERT INTO users (name, phone) VALUES ('Vasya', 321789); ");
        statmt.execute("INSERT INTO users (name, phone) VALUES ('Masha', 456123); ");

        System.out.println("Таблица заполнена");    }

     //ВЫВОД
    public static void ReadDB() throws SQLException{
        resSet = statmt.executeQuery("SELECT * FROM users");
        while(resSet.next()){
            int id = resSet.getInt("id");
            String name = resSet.getString("name");
            //String phone = resSet.getString("phone");
            //System.out.println(String.format("ID = %d name = %s phone = %s",id,name,phone));
            System.out.println(String.format("ID = %d name = %s",id,name));
        }

    }

    // --------Закрытие--------
    public static void CloseDB () throws ClassNotFoundException, SQLException
    {
        resSet.close();
        statmt.close();
        conn.close();
        System.out.println("Соединения закрыты");
    }

}
