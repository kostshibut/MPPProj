package com.database;

import com.database.ClassPackage.DBConnection;

public class Main {

    public  static void main(String[] args){
        DBConnection connection = new DBConnection();

        connection.ConnectToDB();
        connection.ReadDataFromDB();
        connection.CloseDBConnect();
    }
}
