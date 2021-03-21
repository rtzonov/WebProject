package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.News;
import dao.DAOException;
import dao.NewsDAO;

public class SQLNewsDAO implements NewsDAO {

    static {
        MYSQLDriverLoader.getInstance();
    }

    @Override
    public List<News> all() throws DAOException {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        List<News> news = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC",
                    "root", "12345");

            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM news");

            news = new ArrayList<News>();
            while(rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String brief = rs.getString("brief");
                News n = new News(id, title, brief);

                news.add(n);

            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }

        return news;
    }

}