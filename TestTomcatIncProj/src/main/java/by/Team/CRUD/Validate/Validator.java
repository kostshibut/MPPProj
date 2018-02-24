package by.Team.CRUD.Validate;

import by.Team.CRUD.Actors.User;
import by.Team.CRUD.DAO.UserDAO;
import by.Team.CRUD.DAO.UserDAOImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validator {
    private final String SELECT_Request = "select id from users";
    private PreparedStatement preparedStatement = null;
    private UserDAOImpl userDAO;

    public Validator(UserDAO userDAO){
        this.userDAO = (UserDAOImpl)userDAO;
    }

    public boolean ValidateID(User user){
        try {
            preparedStatement = userDAO.getConnector().prepareStatement(SELECT_Request);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                if(user.getId() == resultSet.getInt(1)){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
