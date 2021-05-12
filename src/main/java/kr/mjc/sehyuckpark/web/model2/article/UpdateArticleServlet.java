package kr.mjc.sehyuckpark.web.model2.article;

import kr.mjc.sehyuckpark.web.dao.Article;
import kr.mjc.sehyuckpark.web.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/model2/article/updateArticle")
public class UpdateArticleServlet extends HttpServlet {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Article article = new Article();
        article.setArticleId(Integer.parseInt(request.getParameter("articleId")));
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.setUserId(Integer.parseInt(request.getParameter("userId")));

        articleDao.updateArticle(article);
        response.sendRedirect(request.getContextPath() + "/model2/article/articleList");
    }
}