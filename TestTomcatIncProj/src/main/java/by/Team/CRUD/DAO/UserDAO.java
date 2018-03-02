package by.Team.CRUD.DAO;

import by.Team.CRUD.Actors.User;

public interface UserDAO {
    String ReadDataFromDB();
    boolean SetDataInDB(User user);
    boolean DeleteDataFromDB(User user);
    boolean UpdateDataFromDB(User user);
}
