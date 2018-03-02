package by.Team.CRUD.Command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CommandTest {
    private Command command;
    HttpServletResponse resp = null;
    HttpServletRequest req = null;

    @Before
    public void setup(){
        command = new Command(req, resp);
    }

    @Test(expected = Exception.class)
    public void CRUDOperationsGetData() throws ServletException, IOException {
        req.setAttribute("getting", "someString");
        command.CRUDOperations();
    }

    @Test(expected = Exception.class)
    public void CRUDOperationsSetData() throws ServletException, IOException {
        req.setAttribute("setting", "someString");
        command.CRUDOperations();
    }

    @Test(expected = Exception.class)
    public void CRUDOperationsDelData() throws ServletException, IOException {
        req.setAttribute("deleting", "someString");
        command.CRUDOperations();
    }

    @Test(expected = Exception.class)
    public void CRUDOperationsUpdateData() throws ServletException, IOException {
        req.setAttribute("updating", "someString");
        command.CRUDOperations();
    }

    @After
    public void TheEnd(){
        command = null;
        req = null;
        resp = null;
    }
}