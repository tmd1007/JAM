package com.java.JAM.service;

import com.java.JAM.Article;
import com.java.JAM.dao.ArticleDao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleService {

    private ArticleDao articleDao;

    public ArticleService(Connection conn) {
        this.articleDao = new ArticleDao(conn);
    }

    public int doWrite(String title, String body) {
        return articleDao.doWrite(title, body);
    }

    public List<Article> getArticles(){

        List<Map<String, Object>> articleListMap = articleDao.getArticles();

        List<Article> articles = new ArrayList<>();

        for (Map<String, Object> articleMap : articleListMap) {
            articles.add(new Article(articleMap));
        }

        return articles;
    }

    public Article getArticle(int id) {

        Map<String, Object> articleMap = articleDao.getArticle(id);

        if (articleMap.isEmpty()) {
            return null;
        }

        return new Article(articleMap);
    }

    public int getArticleCount(int id) {
        return articleDao.getArticleCount(id);
    }

    public void doModify(String title, String body, int id) {
        articleDao.doModify(title, body, id);
    }

    public void doDelete(int id) {
        articleDao.doDelete(id);
    }
}