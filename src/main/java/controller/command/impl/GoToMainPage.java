package controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.command.Command;

public class GoToMainPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if(session == null) {
            response.sendRedirect("Controller?command=gotoindexpage&message=eeerrror2");
            return;
        }

        Boolean isAuth = (Boolean) session.getAttribute("auth");

        if (isAuth == null || !isAuth) {
            response.sendRedirect("Controller?command=gotoindexpage&message=eeerrror");
            return;
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        requestDispatcher.forward(request, response);

    }

}
