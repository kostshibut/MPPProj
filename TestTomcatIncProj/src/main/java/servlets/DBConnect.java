package servlets;

import com.database.ClassPackage.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DBConnect extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DBConnection dbConnection = new DBConnection();
        dbConnection.ConnectToDB();

        if(req.getParameter("action") != null && req.getParameter("action").equalsIgnoreCase("get_info")){
            req.setAttribute("answer", dbConnection.ReadDataFromDB());
            req.getRequestDispatcher("GetInfo.jsp").forward(req, resp);
        }

        if(req.getParameter("userNameToSet") != null && req.getParameter("userAgeToSet") != null){

            dbConnection.SetDataInDB(req.getParameter("userNameToSet"), Integer.parseInt(req.getParameter("userAgeToSet")));
            req.setAttribute("reaction", "Everybody be cool, u... be cool");
            req.getRequestDispatcher("SetInfo.jsp").forward(req, resp);
        }

        if(req.getParameter("userIDDelete") != null){
            dbConnection.DeleteDataFromDB(Integer.parseInt(req.getParameter("userIDDelete")));
            req.setAttribute("reaction", "Succesfull deletion");
            req.getRequestDispatcher("DeleteInfo.jsp").forward(req, resp);
        }

        if(req.getParameter("userIDToUpdate") != null){
            dbConnection.UpdateDataFromDB(Integer.parseInt(req.getParameter("userIDToUpdate")), req.getParameter("userNameToUpdate"),
                    Integer.parseInt(req.getParameter("userAgeToUpdate")));
            req.setAttribute("reaction", "Succesfull udpdation");
            req.getRequestDispatcher("UpdateInfo.jsp").forward(req, resp);
        }

        dbConnection.CloseDBConnect();
    }
}
