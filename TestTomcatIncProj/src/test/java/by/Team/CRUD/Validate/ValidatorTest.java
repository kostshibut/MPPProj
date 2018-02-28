package by.Team.CRUD.Validate;

import by.Team.CRUD.Actors.User;
import by.Team.CRUD.DAO.UserDAO;
import by.Team.CRUD.DAO.UserDAOImpl;

import static org.junit.Assert.*;

import org.junit.After;
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
    public void validateIDFalseID() {
        user.setId(5);
        assertEquals(false , validator.ValidateID(user));
    }

    @Test
    public void validateIDTrueID(){
        user.setId(1);
        assertEquals(true, validator.ValidateID(user));
    }

    @Test
    public void validateIDNegativeIDFalse(){
        user.setId(-1);
        assertEquals(false, validator.ValidateID(user));
    }

    @Test
    public void validateIDNullIDFalse(){
        assertEquals(false, validator.ValidateID(user));
    }

    @Test
    public void validateIDStringTrue(){
        user.setId(Integer.parseInt("1"));
        assertEquals(true, validator.ValidateID(user));
    }

    @Test
    public void validateIDStringNegativeValueFalse(){
        user.setId(Integer.parseInt("-1"));
        assertEquals(false, validator.ValidateID(user));
    }

    @Test
    public void validateIDStringParseFalse(){
        user.setId(Integer.parseInt("10"));
        assertEquals(false, validator.ValidateID(user));
    }

    @Test(expected = Exception.class)
    public void validateIDExceptionByEmptyString(){
        user.setId(Integer.parseInt(""));
    }

    @Test(expected = Exception.class)
    public void validateIDExceptionByStringParse(){
        user.setId(Integer.parseInt("some string"));
        validator.ValidateID(user);
    }

    @Test(expected = Exception.class)
    public void validateIDOverFlowException(){
        user.setId(Integer.parseInt("100000000000000"));
    }

    @After
    public void finishValidate(){
        userDAO = null;
        validator = null;
        user = null;
    }
}