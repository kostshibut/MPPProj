package by.Team.CRUD.Validate;

import by.Team.CRUD.Actors.User;
import by.Team.CRUD.DAO.UserDAO;
import by.Team.CRUD.DAO.UserDAOImpl;

import static org.junit.Assert.*;

public class ValidatorTest {

    @org.junit.Test
    public void validateID() {
        UserDAO userDAO = new UserDAOImpl();
        Validator validator = new Validator(userDAO);
        User user = new User();
        user.setId(5);

        assertEquals(false, validator.ValidateID(user));
    }
}