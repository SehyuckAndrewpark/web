package kr.mjc.sehyuckpark.web.model1.user;

import kr.mjc.sehyuckpark.web.dao.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/model1/user/")
public class MenuServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER");

        out.println("<html><body><h3>Model 1. Only Servlets</h3>");
        out.format("<p><a href='%s/'>홈</a></p>", request.getContextPath());
        out.println("<p><a href='userList'>사용자 목록</a></p>");
        out.println("<p><a href='loginForm'>로그인</a></p>");
        out.println("<p><a href='joinForm'>회원가입</a></p>");
        out.println("</body></html>");
        out.close();
    }
}