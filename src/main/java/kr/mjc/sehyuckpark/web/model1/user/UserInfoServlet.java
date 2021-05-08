package kr.mjc.sehyuckpark.web.model1.user;

import kr.mjc.sehyuckpark.web.dao.User;
import kr.mjc.sehyuckpark.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/model1/user/userInfo")
public class UserInfoServlet extends HttpServlet {

    @Autowired
    private UserDao userDao;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER");

        out.println("<html><body><h3>사용자 정보</h3>");
        out.format("<p>%s</p>", user);
        out.println("</body></html>");
        out.close();
    }
}
