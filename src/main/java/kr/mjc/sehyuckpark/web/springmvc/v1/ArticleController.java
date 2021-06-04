package kr.mjc.sehyuckpark.web.springmvc.v1;

import kr.mjc.sehyuckpark.web.dao.Article;
import kr.mjc.sehyuckpark.web.dao.ArticleDao;
import kr.mjc.sehyuckpark.web.dao.User;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller("articleControllerV1")
@RequestMapping("/springmvc/v1/article")
public class ArticleController {

    private final ArticleDao articleDao;

    @Autowired
    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping("/articleList") // /springmvc/v1/article/articleList
    public void articleList(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException {
        String pageStr = Optional.ofNullable(request.getParameter("page"))
                .orElse("1");
        int page = Integer.parseInt(pageStr);
        int count = 25;
        int offset = (page - 1) * count;
        List<Article> articleList = articleDao.listArticles(offset, count);
        request.setAttribute("articleList", articleList);
        request.getRequestDispatcher(
                "/WEB-INF/jsp/springmvc/v1/article/articleList.jsp")
                .forward(request, response);
    }

    @GetMapping("/articleView") // /springmvc/v1/article/articleView
    public void articleView(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException {
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        Article article = articleDao.getArticle(articleId);
        request.setAttribute("article", article);
        request.getRequestDispatcher(
                "/WEB-INF/jsp/springmvc/v1/article/articleView.jsp")
                .forward(request, response);
    }

    @GetMapping("/articleForm")
    public void articleForm(HttpServletRequest request,
                            HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER");
        if (user == null) {
            response.sendRedirect(
                    request.getContextPath() + "/app/springmvc/v1/user/loginForm");
            return;
        }
        request.getRequestDispatcher(
                "/WEB-INF/jsp/springmvc/v1/article/articleForm.jsp")
                .forward(request, response);
    }

    @GetMapping("/articleEdit")
    public void articleEdit(HttpServletRequest request,
                            HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER");
        if (user == null) {
            response.sendRedirect(
                    request.getContextPath() + "/app/springmvc/v1/user/loginForm");
            return;
        }
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        Article article = articleDao.getArticle(articleId);
        if (user.getUserId() == article.getUserId()) {
            request.setAttribute("article", article);
            request.getRequestDispatcher(
                    "/WEB-INF/jsp/springmvc/v1/article/articleEdit.jsp")
                    .forward(request, response);
        } else {
            response.sendError(Response.SC_UNAUTHORIZED);
        }
    }

    @PostMapping("/addArticle")
    public void addArticle(HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER");
        if (user == null) {
            response.sendError(Response.SC_BAD_REQUEST);
            return;
        }
        Article article = new Article();
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.setUserId(user.getUserId());
        article.setName(user.getName());

        articleDao.addArticle(article);
        response.sendRedirect(
                request.getContextPath() + "/app/springmvc/v1/article/articleList");
    }

    @PostMapping("/updateArticle")
    public void updateArticle(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER");
        if (user == null) {
            response.sendError(Response.SC_BAD_REQUEST);
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
                    request.getContextPath() +
                            "/app/springmvc/v1/article/articleView?articleId=" +
                            article.getArticleId());
        else
            response.sendError(Response.SC_BAD_REQUEST);
    }

    @GetMapping("/deleteArticle")
    public void deleteArticle(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER");
        if (user == null) {
            response.sendRedirect(
                    request.getContextPath() + "/app/springmvc/v1/user/loginForm");
            return;
        }
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        int updatedRows = articleDao.deleteArticle(articleId, user.getUserId());
        if (updatedRows > 0)
            response.sendRedirect(
                    request.getContextPath() + "/app/springmvc/v1/article/articleList");
        else
            response.sendError(Response.SC_UNAUTHORIZED);
    }
}