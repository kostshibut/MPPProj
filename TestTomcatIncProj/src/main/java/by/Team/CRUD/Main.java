package by.Team.CRUD;

import by.Team.CRUD.DB.DBConnection;

public class Main {

    public  static void main(String[] args){
        DBConnection connection = new DBConnection();

        connection.ConnectToDB();
        System.out.println(connection.ReadDataFromDB());
        connection.CloseDBConnect();
    }
}
