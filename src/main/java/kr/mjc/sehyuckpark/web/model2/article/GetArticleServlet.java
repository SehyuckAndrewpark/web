package kr.mjc.sehyuckpark.web.model2.article;

import kr.mjc.sehyuckpark.web.dao.Article;
import kr.mjc.sehyuckpark.web.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/model2/article/get")

public class GetArticleServlet extends HttpServlet {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        int articleId = Integer.parseInt(request.getParameter("articleId"));

        try {
            Article article = articleDao.getArticle(articleId);
            HttpSession session = request.getSession();
            session.setAttribute("Article", article);
            response.sendRedirect(request.getContextPath() + "/model2/article/articleInfo");
        } catch (EmptyResultDataAccessException e) {
            response.sendRedirect(request.getContextPath() +
                    "/model2/article/getForm?msg=Wrong Information");
        }
    }
}
