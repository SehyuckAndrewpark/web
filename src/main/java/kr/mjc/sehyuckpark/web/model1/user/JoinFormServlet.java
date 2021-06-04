package kr.mjc.sehyuckpark.web.model1.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/model1/user/joinForm")
public class JoinFormServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String msg =
                Optional.ofNullable((String) request.getParameter("msg")).orElse("");
        out.format("""
        <!DOCTYPE html>
        <html>
        <body>
          <h3>사용자 등록</h3>
          <form action="addUser" method="post">
            <p><input type="email" name="email" placeholder="이메일" required autofocus /></p>
            <p><input type="password" name="password" placeholder="비밀번호" required /></p>
            <p><input type="text" name="name" placeholder="이름" required /></p>
            <p><button type="submit">저장</button></p>
          </form>
          <p style="color:red;">%s</p>
        </body>
        </html>
        """, msg);
        out.close();
    }
}