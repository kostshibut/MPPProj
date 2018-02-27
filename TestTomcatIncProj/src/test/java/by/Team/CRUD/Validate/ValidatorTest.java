package by.Team.CRUD.Validate;

import by.Team.CRUD.Actors.User;
import by.Team.CRUD.DAO.UserDAO;
import by.Team.CRUD.DAO.UserDAOImpl;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class ValidatorTest {
    private Validator validator;
    private User user;
    private UserDAO userDAO;

    @Before
    public void initValidate(){
        userDAO = new UserDAOImpl();
        validator = new Validator(userDAO);
        user = new User();
    }
    @Test
    public void validateID() {
        user.setId(5);
        assertEquals(true , validator.ValidateID(user));
    }
}