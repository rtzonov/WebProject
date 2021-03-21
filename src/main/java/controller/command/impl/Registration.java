package controller.command.impl;

import bean.RegistrationInfo;
import controller.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.ServiceException;
import service.ServiceProvider;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Registration  implements Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final ServiceProvider SERVICE_PROVIDER = ServiceProvider.getInstance();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login;
        String password;
        login = request.getParameter("login");
        password = request.getParameter("password");

        RegistrationInfo info = new RegistrationInfo(login, password);

        UserService userService = SERVICE_PROVIDER.getUserService();

        try {
            userService.registration(info);
            response.sendRedirect("Controller?command=gotoindexpage");
        } catch (ServiceException e) {
            LOGGER.error(e);
            response.sendRedirect("Controller?command=gotoregistrationpage&message=error");

        }
    }
}



