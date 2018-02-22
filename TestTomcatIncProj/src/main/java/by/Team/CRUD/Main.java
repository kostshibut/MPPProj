package by.Team.CRUD;

import by.Team.CRUD.DAO.UserDAOImpl;

public class Main {

    public  static void main(String[] args){
        UserDAOImpl connection = new UserDAOImpl();

        connection.ConnectToDB();
        System.out.println(connection.ReadDataFromDB());
        connection.CloseDBConnect();
    }
}
