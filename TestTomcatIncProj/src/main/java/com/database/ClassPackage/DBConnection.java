package com.database.ClassPackage;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class DBConnection
{
    private final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private final String USERNAME = "root";
    private final String PASSWORD = "375291304064Dy";
    private Connection connector;

    public void ConnectToDB(){
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            connector = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if(!connector.isClosed()){
                System.out.println("Соединение с БД установлено");
            }
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    public void ReadDataFromDB(){
        String query = "select * from users";
        try {
            Statement statement = connector.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setAge(resultSet.getInt(3));

                System.out.println(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void CloseDBConnect(){
        try {
            connector.close();

            if (connector.isClosed()){
                System.out.println("Соединение с БД закрыто");
            }
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
}