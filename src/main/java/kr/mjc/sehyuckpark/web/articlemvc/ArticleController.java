package kr.mjc.sehyuckpark.web.articlemvc;

import kr.mjc.sehyuckpark.web.dao.Article;
import kr.mjc.sehyuckpark.web.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Component
public class ArticleController {

    private final ArticleDao articleDao;

    @Autowired
    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public void articleList(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Article> articleList = articleDao.listArticles(0, 100);
        request.setAttribute("articleList", articleList);

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleList.jsp")
                .forward(request, response);
    }

    public void articleForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleForm.jsp")
                .forward(request, response);
    }

    public void addArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Article article = new Article();
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.setUserId(Integer.parseInt(request.getParameter("userId")));
        article.setName(request.getParameter("name"));
        articleDao.addArticle(article);
        response.sendRedirect(request.getContextPath() + "/articlemvc/article/articleList");
    }

    public void articleInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleInfo.jsp")
                .forward(request, response);
    }

    public void deleteArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int articleId = Integer.parseInt(request.getParameter("articleId"));
        int userId = Integer.parseInt(request.getParameter("userId"));

        articleDao.deleteArticle(articleId, userId);
        response.sendRedirect(request.getContextPath() + "/articlemvc/article/articleList");
    }

    public void deleteForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/deleteForm.jsp")
                .forward(request, response);
    }

    public void getForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/getForm.jsp")
                .forward(request, response);
    }

    public void get(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int articleId = Integer.parseInt(request.getParameter("articleId"));

        try {
            Article article = articleDao.getArticle(articleId);
            HttpSession session = request.getSession();
            session.setAttribute("Article", article);
            response.sendRedirect(request.getContextPath() + "/articlemvc/article/articleInfo");
        } catch (EmptyResultDataAccessException e) {
            response.sendRedirect(request.getContextPath() +
                    "/articlemvc/article/getForm?msg=Wrong Information");
        }
    }

    public void updateArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Article article = new Article();
        article.setArticleId(Integer.parseInt(request.getParameter("articleId")));
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.setUserId(Integer.parseInt(request.getParameter("userId")));

        articleDao.updateArticle(article);
        response.sendRedirect(request.getContextPath() + "/articlemvc/article/articleList");
    }

    public void updateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/updateForm.jsp")
                .forward(request, response);
    }

}
