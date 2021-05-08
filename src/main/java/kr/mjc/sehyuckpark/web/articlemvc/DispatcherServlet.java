package kr.mjc.sehyuckpark.web.articlemvc;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/articlemvc/*")
public class DispatcherServlet extends HttpServlet {

    @Autowired
    ArticleController articleController;

    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response)
        throws ServletException, IOException {
        String uri = request.getRequestURI();

        switch (uri) {
            case "/articlemvc/article/articleList" -> articleController.articleList(request, response);
            case "/articlemvc/article/addArticle" -> articleController.addArticle(request, response);
            case "/articlemvc/article/articleForm" -> articleController.articleForm(request, response);
            case "/articlemvc/article/articleInfo" -> articleController.articleInfo(request, response);
            case "/articlemvc/article/deleteArticle" -> articleController.deleteArticle(request, response);
            case "/articlemvc/article/deleteForm" -> articleController.deleteForm(request, response);
            case "/articlemvc/article/updateArticle" -> articleController.updateArticle(request, response);
            case "/articlemvc/article/updateForm" -> articleController.updateForm(request, response);
            case "/articlemvc/article/get" -> articleController.get(request, response);
            case "/articlemvc/article/getForm" -> articleController.getForm(request, response);
            default -> response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
