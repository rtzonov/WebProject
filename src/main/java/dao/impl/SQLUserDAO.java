package dao.impl;

import bean.News;
import bean.RegistrationInfo;
import bean.TypeUser;
import bean.User;
import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.DAOException;
import dao.UserDAO;

import java.sql.*;
import java.util.List;

public class SQLUserDAO implements UserDAO{
    private static final ConnectionPool pool = ConnectionPool.getInstance();
    private static final String LOGIN_QUERY = "SELECT users.id, users.login, users.password, roles.type_users FROM users" +
            " INNER JOIN roles on users.roles_id = roles.id where login=? AND password=?;";
    static {
        MYSQLDriverLoader.getInstance();
    }

    @Override
    public User authorization(String login, String password) throws DAOException {
        User user = null;
        try (
                Connection connection = pool.takeConnection();
                PreparedStatement statement = connection.prepareStatement(LOGIN_QUERY)
        ){
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Integer id = (Integer) resultSet.getObject(1);

                TypeUser role = TypeUser.valueOf(resultSet.getString(4).toUpperCase());
                user = new User(id, login, password, role);
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e.getMessage(), e);
        }
        return user;
    }

    @Override
    public void registration(RegistrationInfo regInfo) throws DAOException {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        List<News> news = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC",
                    "root", "12345");

            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO users (login, password, roles_id) VALUE (?,?,?)");
            preparedStatement.setString(1, regInfo.getLogin());
            preparedStatement.setString(2, regInfo.getPassword());
            preparedStatement.setInt(3, 1);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
    }
}
