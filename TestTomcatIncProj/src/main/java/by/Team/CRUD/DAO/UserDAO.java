package by.Team.CRUD.DAO;

import by.Team.CRUD.Actors.User;

public interface UserDAO {
    String ReadDataFromDB();
    void SetDataInDB(User user);
    void DeleteDataFromDB(User user);
    void UpdateDataFromDB(User user);
}
