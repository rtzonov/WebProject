package service;

import bean.RegistrationInfo;
import bean.User;

public interface UserService {
    User authorization(String login, String passport) throws ServiceException;
    boolean registration(RegistrationInfo regInfo) throws ServiceException;
}
