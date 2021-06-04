package kr.mjc.sehyuckpark.web.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 모든 요청을 받아서 uri에 따라 컨트롤러 메서드를 호출한다.
 */
@WebServlet("/mvc/*")
@Slf4j
public class DispatcherServlet extends HttpServlet {

    @Autowired
    UserController userController;

    @Autowired
    ArticleController articleController;

    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getPathInfo();
        switch (uri) {
            case "/user/userList" -> userController.userList(request, response);
            case "/user/joinForm" -> userController.joinForm(request, response);
            case "/user/loginForm" -> userController.loginForm(request, response);
            case "/user/userInfo" -> userController.userInfo(request, response);
            case "/user/addUser" -> userController.addUser(request, response);
            case "/user/login" -> userController.login(request, response);
            case "/user/logout" -> userController.logout(request, response);

            case "/article/articleList" -> articleController.articleList(request, response);
            case "/article/articleView" -> articleController.articleView(request, response);
            case "/article/articleForm" -> articleController.articleForm(request, response);
            case "/article/articleEdit" -> articleController.articleEdit(request, response);
            case "/article/addArticle" -> articleController.addArticle(request, response);
            case "/article/updateArticle" -> articleController.updateArticle(request, response);
            case "/article/deleteArticle" -> articleController.deleteArticle(request, response);

            default -> response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}