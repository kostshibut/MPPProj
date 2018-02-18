package by.Team.CRUD.DB;

import by.Team.CRUD.Actors.User;
import by.Team.CRUD.Validate.Validator;
import com.mysql.jdbc.Driver;

import java.sql.*;

public class DBConnection
{
    private final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";
    private final String INSERT_Request = "INSERT INTO users (name, age) VALUES(?, ?)";
    private final String DELETE_Request = "delete from users where id=(?)";
    private final String UPDATE_Request = "update users set name=(?), age=(?) where id=(?)";
    private final String SELECT_Request = "select * from users";
    private Connection connector;
    private PreparedStatement preparedStatement = null;

    public void ConnectToDB(){
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            connector = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if(!connector.isClosed()){
                System.out.println("Соединение с БД установлено");
            }
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    public String ReadDataFromDB(){
        String answer = "";
        try {
            preparedStatement = connector.prepareStatement(SELECT_Request);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setAge(resultSet.getInt(3));

                answer += user.toString() + " ";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return answer;
    }

    public void SetDataInDB(String name, int age){

        User user = new User(name, age);

        try {
            preparedStatement = connector.prepareStatement(INSERT_Request);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteDataFromDB(int id){
        User user = new User();
        user.setId(id);
        try {
            preparedStatement = connector.prepareStatement(DELETE_Request);
            preparedStatement.setInt(1, user.getId());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateDataFromDB(int id, String name, int age){

        User user = new User(id, name, age);

        try{
            preparedStatement = connector.prepareStatement(UPDATE_Request);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setInt(3, user.getId());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void CloseDBConnect(){
        try {
            connector.close();
            preparedStatement.close();
            if (connector.isClosed()){
                System.out.println("Соединение с БД закрыто");
            }
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
}