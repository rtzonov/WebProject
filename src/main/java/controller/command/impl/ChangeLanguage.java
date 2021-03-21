package controller.command.impl;

import controller.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.RequestParameter;
import util.SessionAttribute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

public class ChangeLanguage implements Command {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String REFERENCE = "referer";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String localeParameter = request.getParameter(RequestParameter.LOCALE);
          Locale.Builder builder = new Locale.Builder();
          builder.setLanguageTag(localeParameter);
          Locale locale = builder.build();
          request.getSession().setAttribute(SessionAttribute.LANGUAGE, locale);
          String header = request.getHeader(REFERENCE);
          response.sendRedirect("Controller?command=gotoindexpage");
    }
}
