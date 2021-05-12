package kr.mjc.sehyuckpark.web.mvc;

import kr.mjc.sehyuckpark.web.dao.Article;
import kr.mjc.sehyuckpark.web.dao.ArticleDao;
import kr.mjc.sehyuckpark.web.dao.User;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class ArticleController {

    private final ArticleDao articleDao;

    @Autowired
    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    /**
     * ArticleList
     */
    public void articleList(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException {
        String pageStr =
                Optional.ofNullable(request.getParameter("page")).orElse("1");
        int page = Integer.parseInt(pageStr);
        int count = 25;
        int offset = (page - 1) * count;
        List<Article> articleList = articleDao.listArticles(offset, count);
        request.setAttribute("articleList", articleList);
        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleList.jsp")
                .forward(request, response);
    }

    /**
     * ArticleView
     */
    public void articleView(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException {
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        Article article = articleDao.getArticle(articleId);
        request.setAttribute("article", article);
        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleView.jsp")
                .forward(request, response);
    }


    /**
     * ArticleForm
     */
    public void articleForm(HttpServletRequest request,
                            HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/mvc/user/loginForm");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleForm.jsp")
                .forward(request, response);
    }

    /**
     * ArticleEdit
     * 401 Unauthorized.
     */
    public void articleEdit(HttpServletRequest request,
                            HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/mvc/user/loginForm");
            return;
        }
        int articleId = Integer.parseInt(request.getParameter("articleId"));

        Article article = articleDao.getArticle(articleId);
        if (user.getUserId() == article.getUserId()) {
            request.setAttribute("article", article);
            request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleEdit.jsp")
                    .forward(request, response);
        } else {
            response.sendError(Response.SC_UNAUTHORIZED);
        }
    }

    /**
     * AddArticle
     */
    public void addArticle(HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/mvc/user/loginForm");
            return;
        }
        Article article = new Article();
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.setUserId(user.getUserId());
        article.setName(user.getName());

        articleDao.addArticle(article);
        response.sendRedirect("/mvc/article/articleList");
    }

    /**
     * UpdateArticle
     * 401 Unauthorized.
     */
    public void updateArticle(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/mvc/user/loginForm");
            return;
        }

        Article article = new Article();
        article.setArticleId(Integer.parseInt(request.getParameter("articleId")));
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.setUserId(user.getUserId());

        int updatedRows = articleDao.updateArticle(article);
        if (updatedRows > 0)
            response.sendRedirect(
                    request.getContextPath() + "/mvc/article/articleView?articleId=" +
                            article.getArticleId());
        else
            response.sendError(Response.SC_UNAUTHORIZED);
    }

    /**
     * DeleteArticle
     * 401 Unauthorized.
     */
    public void deleteArticle(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/mvc/user/loginForm");
            return;
        }

        int articleId = Integer.parseInt(request.getParameter("articleId"));

        int updatedRows = articleDao.deleteArticle(articleId, user.getUserId());
        if (updatedRows > 0)
            response
                    .sendRedirect(request.getContextPath() + "/mvc/article/articleList");
        else
            response.sendError(Response.SC_UNAUTHORIZED);
    }
}
