package servlets;

import com.database.ClassPackage.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class DBConnect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DBConnection dbConnection = new DBConnection();

        dbConnection.ConnectToDB();

        PrintWriter out = resp.getWriter();
        out.println(dbConnection.ReadDataFromDB());

        dbConnection.CloseDBConnect();
    }
}
