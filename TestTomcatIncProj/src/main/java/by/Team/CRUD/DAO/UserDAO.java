package by.Team.CRUD.DAO;

import by.Team.CRUD.Actors.User;

public interface UserDAO {
    void ConnectToDB();
    String ReadDataFromDB();
    void SetDataInDB(User user);
    void DeleteDataFromDB(User user);
    void UpdateDataFromDB(User user);
    void CloseDBConnect();
}
