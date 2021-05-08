package kr.mjc.sehyuckpark.web.model2.article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/model2/article/updateForm")
public class UpdateFormServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/updateForm.jsp")
                .forward(request, response);
    }
}
