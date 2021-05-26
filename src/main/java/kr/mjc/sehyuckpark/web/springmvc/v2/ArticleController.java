package kr.mjc.sehyuckpark.web.springmvc.v2;

import kr.mjc.sehyuckpark.web.dao.Article;
import kr.mjc.sehyuckpark.web.dao.ArticleDao;
import kr.mjc.sehyuckpark.web.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("articleControllerV2")
@RequestMapping("/springmvc/v2/article")

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
            HttpSession session, Model model) {
        int offset = (page - 1) * count;
        List<Article> articleList = articleDao.listArticles(offset, count);
        int totalCount = articleDao.countArticles();
        model.addAttribute("articleList", articleList);
        model.addAttribute("totalCount", totalCount);
        session.setAttribute("currentPage", page);
        session.setAttribute("countPerPage", count);
    }

    @GetMapping("/myArticle")
    public void myArticle(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int count,
            @SessionAttribute("USER") User user,
            HttpSession session, Model model) {
        int offset = (page - 1) * count;
        List<Article> myArticle = articleDao.myArticles(user.getUserId(), offset, count);
        int totalCount = articleDao.countMyArticles(user.getUserId());
        model.addAttribute("myArticle", myArticle);
        model.addAttribute("totalCount", totalCount);
        session.setAttribute("currentPage", page);
        session.setAttribute("countPerPage", count);
    }

    @GetMapping("/articleView")
    public void articleView(int articleId, Model model) {
        Article article = articleDao.getArticle(articleId);
        model.addAttribute("article", article);
        // forward /WEB-INF/springmvc/v2/article/articleView.jsp
    }

    @GetMapping("/articleEdit")
    public String articleEdit(@RequestParam int articleId,
                              @SessionAttribute("USER") User user, Model model) {
        Article article = articleDao.getArticle(articleId);
        if (user.getUserId() != article.getUserId())
            return "error/401";

        model.addAttribute("article", article);
        return "springmvc/v2/article/articleEdit";
    }

    @PostMapping("/addArticle")
    public String addArticle(@ModelAttribute Article article,
                             @SessionAttribute("USER") User user,
                             @SessionAttribute String countPerPage) {
        article.setUserId(user.getUserId());
        article.setName(user.getName());
        articleDao.addArticle(article);
        return "redirect:/springmvc/v2/article/articleList?page=1&count=" +
                countPerPage;
    }

    @PostMapping("/updateArticle")
    public String updateArticle(@ModelAttribute Article article,
                                @SessionAttribute("USER") User user) {
        article.setUserId(user.getUserId());

        int result = articleDao.updateArticle(article);
        if (result == 0)
            return "error/400";

        return "redirect:/springmvc/v2/article/articleView?articleId=" +
                article.getArticleId();
    }

    @GetMapping("/deleteArticle")
    public String deleteArticle(int articleId,
                                @SessionAttribute("USER") User user,
                                @SessionAttribute String currentPage,
                                @SessionAttribute String countPerPage) {
        int result = articleDao.deleteArticle(articleId, user.getUserId());
        if (result == 0) {
            return "error/401";
        }
        return String
                .format("redirect:/springmvc/v2/article/articleList?page=%s&count=%s",
                        currentPage, countPerPage);
    }

}
