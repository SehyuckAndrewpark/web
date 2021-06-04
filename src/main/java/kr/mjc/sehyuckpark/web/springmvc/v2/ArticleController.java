package kr.mjc.sehyuckpark.web.springmvc.v2;

import kr.mjc.sehyuckpark.web.HttpUtils;
import kr.mjc.sehyuckpark.web.dao.Article;
import kr.mjc.sehyuckpark.web.dao.ArticleDao;
import kr.mjc.sehyuckpark.web.dao.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("articleControllerV2")
@RequestMapping("/springmvc/v2/article")
@Slf4j
public class ArticleController {

    private final ArticleDao articleDao;

    @Autowired
    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping("/articleList")
    public void articleList(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "20") int count,
            HttpServletRequest request, Model model) {
        int offset = (page - 1) * count;
        List<Article> articleList = articleDao.listArticles(offset, count);
        int totalCount = articleDao.countArticles();
        model.addAttribute("articleList", articleList);
        model.addAttribute("totalCount", totalCount);
        log.debug(HttpUtils.getRequestURLWithQueryString(request));
        request.getSession().setAttribute("listPage",
                HttpUtils.getRequestURLWithQueryString(request));
    }

    @GetMapping("/userArticles")
    public String userArticles(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "20") int count,
            @RequestParam int userId, HttpServletRequest request, Model model) {
        int offset = (page - 1) * count;
        List<Article> articleList =
                articleDao.userArticles(userId, offset, count);
        int totalCount = articleDao.countUserArticles(userId);
        model.addAttribute("articleList", articleList);
        model.addAttribute("totalCount", totalCount);
        log.debug(HttpUtils.getRequestURLWithQueryString(request));
        request.getSession().setAttribute("listPage",
                HttpUtils.getRequestURLWithQueryString(request));
        return "springmvc/v2/article/articleList";
    }

    @GetMapping("/articleView")
    public void articleView(int articleId, @RequestHeader String referer,
                            HttpSession session, Model model) {
        session.setAttribute("referer", referer);
        Article article = articleDao.getArticle(articleId);
        model.addAttribute("article", article);
    }

    @GetMapping("/s/articleEdit")
    public String articleEdit(@RequestParam int articleId,
                              @SessionAttribute("USER") User user, Model model) {
        Article article = articleDao.getArticle(articleId);
        if (user.getUserId() != article.getUserId())
            return "error/401";
        model.addAttribute("article", article);
        return "springmvc/v2/article/s/articleEdit";
    }

    @PostMapping("/s/addArticle")
    public String addArticle(@ModelAttribute Article article,
                             @SessionAttribute("USER") User user) {
        article.setUserId(user.getUserId());
        article.setName(user.getName());
        articleDao.addArticle(article);
        return "redirect:/app/springmvc/v2/article/articleList?page=1";
    }

    @PostMapping("/s/updateArticle")
    public String updateArticle(@ModelAttribute Article article,
                                @SessionAttribute("USER") User user) {
        article.setUserId(user.getUserId());

        int result = articleDao.updateArticle(article);
        if (result == 0)
            return "error/400";

        return "redirect:/app/springmvc/v2/article/articleView?articleId=" +
                article.getArticleId();
    }

    @GetMapping("/s/deleteArticle")
    public String deleteArticle(int articleId,
                                @SessionAttribute("USER") User user,
                                @SessionAttribute("listPage") String listPage) {
        int result = articleDao.deleteArticle(articleId, user.getUserId());
        if (result == 0) {
            return "error/401";
        }
        return "redirect:" + listPage;
    }
}