package service;

import bean.News;

import java.util.List;

public interface NewsService {
    List<News> takeAll() throws ServiceException;
}
