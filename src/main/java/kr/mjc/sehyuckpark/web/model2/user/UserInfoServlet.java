package kr.mjc.sehyuckpark.web.model2.user;

import kr.mjc.sehyuckpark.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/model2/user/userInfo")
public class UserInfoServlet extends HttpServlet {

    @Autowired
    private UserDao userDao;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/model2/user/userInfo.jsp")
                .forward(request, response);
    }
}
