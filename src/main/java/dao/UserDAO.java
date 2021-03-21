package dao;

import bean.RegistrationInfo;
import bean.User;

public interface UserDAO {

    User authorization (String login, String password) throws DAOException;
    void registration(RegistrationInfo regInfo) throws DAOException;

}
