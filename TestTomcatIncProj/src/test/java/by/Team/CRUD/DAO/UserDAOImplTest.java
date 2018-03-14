package by.Team.CRUD.DAO;

import by.Team.CRUD.Actors.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDAOImplTest {
    private UserDAO userDAO = null;
    private User user;

    @Before
    public void setup(){
        userDAO = new UserDAOImpl();
        user = new User();
    }

    @Test
    public void GetDataFromDBTrue(){
        assertNotEquals("", userDAO.ReadDataFromDB());
    }

    @Test
    public void SetDataToDBTrue(){
        user.setName("AlexTest");
        user.setAge(15);
        assertEquals(true, userDAO.SetDataInDB(user));
    }

    @Test
    public void SetDataToDBWithID(){
        user.setId(54);
        user.setName("NickTest");
        user.setAge(40);
        assertEquals(true, userDAO.SetDataInDB(user));
    }

    @Test
    public void UpdateDataTrue(){
        user.setId(1);
        user.setName("UpdateTestName");
        user.setAge(99);
        assertEquals(true, userDAO.UpdateDataFromDB(user));
    }

    @Test
    public void UpdateUndefIndexTrue(){
        user.setId(18);
        user.setName("UpdateTestName");
        user.setAge(99);
        assertEquals(true, userDAO.UpdateDataFromDB(user));
    }

    @Test
    public void DeleteTestTrue(){
        user.setId(1);
        assertEquals(true, userDAO.DeleteDataFromDB(user));
    }

    @Test
    public void DeleteUndefIndexTrue(){
        user.setId(100);
        assertEquals(true, userDAO.DeleteDataFromDB(user));
    }

    @After
    public void theEnd(){
        userDAO = null;
        user = null;
    }
}