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
    ArticleexController articleexController;

    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response)
        throws ServletException, IOException {
        String uri = request.getRequestURI();

        switch (uri) {
            case "/articlemvc/article/articleList" -> articleexController.articleList(request, response);
            case "/articlemvc/article/addArticle" -> articleexController.addArticle(request, response);
            case "/articlemvc/article/articleForm" -> articleexController.articleForm(request, response);
            case "/articlemvc/article/articleInfo" -> articleexController.articleInfo(request, response);
            case "/articlemvc/article/deleteArticle" -> articleexController.deleteArticle(request, response);
            case "/articlemvc/article/deleteForm" -> articleexController.deleteForm(request, response);
            case "/articlemvc/article/updateArticle" -> articleexController.updateArticle(request, response);
            case "/articlemvc/article/updateForm" -> articleexController.updateForm(request, response);
            case "/articlemvc/article/get" -> articleexController.get(request, response);
            case "/articlemvc/article/getForm" -> articleexController.getForm(request, response);
            default -> response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
