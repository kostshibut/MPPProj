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

        if(req.getParameter("action") != null && req.getParameter("action").equalsIgnoreCase("get_info")){
            System.out.println(req.getParameter("setInfo"));
            DBConnection dbConnection = new DBConnection();

            dbConnection.ConnectToDB();


            req.setAttribute("answer", dbConnection.ReadDataFromDB());

            dbConnection.CloseDBConnect();

            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }
}
