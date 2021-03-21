package service.impl;

import bean.RegistrationInfo;
import bean.User;
import dao.DAOException;
import dao.DAOProvider;
import dao.UserDAO;
import service.ServiceException;
import service.UserService;

public class UserServiceImpl implements UserService {

    private static final DAOProvider provider = DAOProvider.getInstance();

    @Override
    public User authorization(String login, String password) throws ServiceException {
        // validation
        if(login == null || "".equals(login) ) {// to bo cont....
            throw new ServiceException("wrong login or password");
        }

        UserDAO userDAO = provider.getUserdao();

        User user = null;
        try {
            user = userDAO.authorization(login, password);
        }catch(DAOException e) {
            throw new ServiceException("error message", e);
        }
        return user;
    }

    @Override
    public boolean registration(RegistrationInfo regInfo) throws ServiceException {
        UserDAO userDAO = provider.getUserdao();

        try {
            userDAO.registration(regInfo);
        } catch (DAOException e) {
            throw new ServiceException(
                    e
            );
        }

        return false;
    }

}