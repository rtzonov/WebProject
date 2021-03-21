package controller.command.impl;

import bean.News;
import controller.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.NewsService;
import service.ServiceException;
import service.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GoToLoginPage implements Command {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceProvider provider = ServiceProvider.getInstance();
        NewsService newsService = provider.getNewsService();

        try {
            List<News> news = newsService.takeAll();

            request.setAttribute("news", news);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            requestDispatcher.forward(request, response);

        } catch (ServiceException e) {
            // TODO перейти на глобальную страницу ошибок
            LOGGER.error(e);
            e.printStackTrace();
        }



    }
}
