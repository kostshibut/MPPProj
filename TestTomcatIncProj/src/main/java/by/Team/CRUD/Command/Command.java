package by.Team.CRUD.Command;

import by.Team.CRUD.Actors.User;
import by.Team.CRUD.DAO.UserDAO;
import by.Team.CRUD.DAO.UserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Command {
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private UserDAO userDAOImpl;
    private User user;

    public Command(HttpServletRequest req, HttpServletResponse resp){
        this.req = req;
        this.resp = resp;
        userDAOImpl = new UserDAOImpl();
    }

    public void CRUDoperations() throws ServletException, IOException {
        userDAOImpl.ConnectToDB();

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

        userDAOImpl.CloseDBConnect();
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
        userDAOImpl.DeleteDataFromDB(user);
        req.setAttribute("reaction", "Succesfull deletion");
        req.getRequestDispatcher("DeleteInfo.jsp").forward(req, resp);
    }

    private void UpdatingFromDB() throws ServletException, IOException {
        user = new User(Integer.parseInt(req.getParameter("userIDToUpdate")), req.getParameter("userNameToUpdate"),
                Integer.parseInt(req.getParameter("userAgeToUpdate")));
        userDAOImpl.UpdateDataFromDB(user);
        req.setAttribute("reaction", "Succesfull udpdation");
        req.getRequestDispatcher("UpdateInfo.jsp").forward(req, resp);
    }
}
