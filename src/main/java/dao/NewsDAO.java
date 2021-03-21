package dao;

import bean.News;

import java.util.List;

public interface NewsDAO {

    List<News> all()  throws DAOException;

}
