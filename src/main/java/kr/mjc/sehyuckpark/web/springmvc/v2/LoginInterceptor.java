package kr.mjc.sehyuckpark.web.springmvc.v2;

import kr.mjc.sehyuckpark.web.dao.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER");

        if (user != null)
            return true;

        String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();
        String returnUrl = queryString == null ? requestURI :
                String.format("%s?%s", requestURI, queryString);

        String loginUrl = String
                .format("%s/springmvc/v2/user/loginForm?returnUrl=%s",
                        request.getContextPath(),
                        URLEncoder.encode(returnUrl, Charset.defaultCharset()));
        response.sendRedirect(loginUrl);
        return false;
    }
}
