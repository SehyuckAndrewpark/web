package kr.mjc.sehyuckpark.web.model2.user;

import kr.mjc.sehyuckpark.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/model2/user/userList")
public class UserListServlet extends HttpServlet {

    @Autowired
    private UserDao userDao;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("userList", userDao.listUsers(0, 100));

        request.getRequestDispatcher("/WEB-INF/jsp/model2/user/userList.jsp")
                .forward(request, response);
    }
}
