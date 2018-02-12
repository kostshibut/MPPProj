package servlets;

import com.database.ClassPackage.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DBConnect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DBConnection dbConnection = new DBConnection();
        dbConnection.ConnectToDB();
        dbConnection.ReadDataFromDB();
        dbConnection.CloseDBConnect();

        req.getRequestDispatcher("DBConnect.jsp").forward(req, resp);
    }
}
