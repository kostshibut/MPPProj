package by.Team.CRUD.Command;

import by.Team.CRUD.Actors.User;
import by.Team.CRUD.DAO.UserDAO;
import by.Team.CRUD.DAO.UserDAOImpl;
import by.Team.CRUD.Validate.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Command {
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private UserDAO userDAOImpl;
    private User user;
    private Validator validator;

    public Command(HttpServletRequest req, HttpServletResponse resp){
        this.req = req;
        this.resp = resp;
        userDAOImpl = new UserDAOImpl();
        validator = new Validator(userDAOImpl);
    }

    public void CRUDOperations() throws ServletException, IOException {
        if(req.getParameter("getting") != null){
            GettingFromDb();
        }

        if(req.getParameter("setting") != null) {
            SettingToDB();
        }

        if(req.getParameter("deleting") != null){
            DeletingFromDB();
        }

        if(req.getParameter("updating") != null){
            UpdatingFromDB();
        }
    }

    private void GettingFromDb() throws ServletException, IOException {
        req.setAttribute("answer", userDAOImpl.ReadDataFromDB());
        req.getRequestDispatcher("GetInfo.jsp").forward(req, resp);
    }

    private void SettingToDB() throws ServletException, IOException {
        user = new User(req.getParameter("userNameToSet"), Integer.parseInt(req.getParameter("userAgeToSet")));
        userDAOImpl.SetDataInDB(user);
        req.setAttribute("reaction", "Succesfull getting");
        req.getRequestDispatcher("SetInfo.jsp").forward(req, resp);
    }

    private void DeletingFromDB() throws ServletException, IOException {
        user = new User();
        user.setId(Integer.parseInt(req.getParameter("userIDDelete")));

        if (validator.ValidateID(user)) {
            userDAOImpl.DeleteDataFromDB(user);
            req.setAttribute("reaction", "Succesfull deletion");
        }
        else {
            req.setAttribute("reaction", "Non-existent value of the identifier");
        }

        req.getRequestDispatcher("DeleteInfo.jsp").forward(req, resp);
    }

    private void UpdatingFromDB() throws ServletException, IOException {
        user = new User(Integer.parseInt(req.getParameter("userIDToUpdate")), req.getParameter("userNameToUpdate"),
                Integer.parseInt(req.getParameter("userAgeToUpdate")));

        if (validator.ValidateID(user)) {
            userDAOImpl.UpdateDataFromDB(user);
            req.setAttribute("reaction", "Succesfull udpdation");
        }
        else {
            req.setAttribute("reaction", "Non-existent value of the identifier");
        }

        req.getRequestDispatcher("UpdateInfo.jsp").forward(req, resp);
    }
}
