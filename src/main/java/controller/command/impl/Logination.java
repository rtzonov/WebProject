package controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import controller.command.Command;
import service.ServiceException;
import service.ServiceProvider;
import service.UserService;

public class Logination implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login;
        String password;

        login = request.getParameter("login");
        password = request.getParameter("password");

        ServiceProvider provider = ServiceProvider.getInstance();
        UserService userService = provider.getUserService();

        User user = null;
        RequestDispatcher requestDispatcher = null;
        try {
            user = userService.authorization(login, password);

            if (user == null) {
                response.sendRedirect("Controller?command=gotoindexpage&message=wrong2");
                return;
            }

            HttpSession session = request.getSession(true);
            session.setAttribute("auth", true);
            response.sendRedirect("Controller?command=gotomainpage");

        } catch (ServiceException e) {
            response.sendRedirect("Controller?command=gotoindexpage&message=wrong in catch");
        }

    }

}
