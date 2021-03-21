package service.impl;

import java.util.List;

import bean.News;
import dao.DAOException;
import dao.DAOProvider;
import dao.NewsDAO;
import service.NewsService;
import service.ServiceException;

public class NewsServiceImpl implements NewsService {

    @Override
    public List<News> takeAll() throws ServiceException {

        DAOProvider provider = DAOProvider.getInstance();
        NewsDAO newsDAO = provider.getNewsDAO();

        List<News> news;
        try {
            news = newsDAO.all();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return news;
    }
}
