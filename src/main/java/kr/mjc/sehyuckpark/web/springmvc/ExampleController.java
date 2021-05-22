package kr.mjc.sehyuckpark.web.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ExampleController {
    /**
     * Use Servlet API
     */
    @GetMapping("/springmvc/hi")
    public void hi(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/springmvc/hi.jsp")
                .forward(request, response);
    }

    /**
     * Not Use Servlet API. return type: String
     * @return
     */
    @GetMapping("/springmvc/hello")
    public String hello() {
        return "springmvc/hello"; // view 이름
    }

    /**
     * Not Use Servlet API. return type: void
     * @return
     */
    @GetMapping("/springmvc/welcome")
    public void welcome() {

    }
}
