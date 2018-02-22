package by.Team.CRUD.Validate;

import by.Team.CRUD.Actors.User;
import by.Team.CRUD.DAO.UserDAO;
import by.Team.CRUD.DAO.UserDAOImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Validator {
    private final String SELECT_Request = "select * from users";
    private PreparedStatement preparedStatement = null;
    private UserDAOImpl userDAO;
    private List<Integer> ListID = new ArrayList<Integer>();
    public Validator(UserDAO userDAO){
        this.userDAO = (UserDAOImpl)userDAO;
    }

    public boolean ValidateID(User user){
        try {
            preparedStatement = userDAO.getConnector().prepareStatement(SELECT_Request);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                ListID.add(resultSet.getInt(1));
            }

            for (int i = 0; i < ListID.size(); i++){
                if (ListID.get(i) == user.getId()){
                    return true;
                }

                System.out.println(ListID.get(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
