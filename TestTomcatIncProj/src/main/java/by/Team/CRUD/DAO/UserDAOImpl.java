package by.Team.CRUD.DAO;

import by.Team.CRUD.Actors.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class UserDAOImpl implements UserDAO
{
    private final String URL = "jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";
    private final String INSERT_Request = "INSERT INTO users (name, age) VALUES(?, ?)";
    private final String DELETE_Request = "delete from users where id=(?)";
    private final String UPDATE_Request = "update users set name=(?), age=(?) where id=(?)";
    private final String SELECT_Request = "select * from users";

    public Connection getConnector() {
        return connector;
    }

    private Connection connector;
    private PreparedStatement preparedStatement = null;

    public UserDAOImpl(){
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

    public void SetDataInDB(User user){
        try {
            preparedStatement = connector.prepareStatement(INSERT_Request);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteDataFromDB(User user){
        try {
            preparedStatement = connector.prepareStatement(DELETE_Request);
            preparedStatement.setInt(1, user.getId());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateDataFromDB(User user){
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

    @Override
    protected void finalize() throws Throwable {
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