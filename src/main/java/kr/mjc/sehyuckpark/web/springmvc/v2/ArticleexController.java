package kr.mjc.sehyuckpark.web.springmvc.v2;


import kr.mjc.sehyuckpark.web.dao.Article;
import kr.mjc.sehyuckpark.web.dao.ArticleDao;
import kr.mjc.sehyuckpark.web.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("articleexControllerV2")
@RequestMapping("/springmvc/v2/articleex")
public class ArticleexController {

    private final ArticleDao articleDao;

    @Autowired
    public ArticleexController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    /**
     * ArticleList
     */
    @GetMapping("/articleList")
    public void articleList(
            @RequestParam(name="page", required = false, defaultValue = "1") int page,
            Model model) {
        int count = 25;
        int offset = (page -1) * count;
        List<Article> articleList = articleDao.listArticles(offset, count);
        model.addAttribute("articleList", articleList);
    }

    /**
     * ArticleView
     */
    @GetMapping("/articleView")
    public String articleView(@RequestParam int articleId, Model model) {
        Article article = articleDao.getArticle(articleId);
        model.addAttribute("article", article);
        return "springmvc/v2/articleex/articleView";
    }

    /**
     * ArticleForm
     */
    @GetMapping("/articleForm")
    public String articleForm(HttpSession session, RedirectAttributes attributes) {
        User user = (User)session.getAttribute("USER");
        if (user == null) {
            attributes.addFlashAttribute("msg", "Please Login");
            return "redirect:/springmvc/v2/userex/loginForm";
        }
        return "/springmvc/v2/articleex/articleForm";
    }

    /**
     * ArticleEdit
     */
    @GetMapping("/articleEdit")
    public String articleEdit(@RequestParam int articleId, HttpSession session,
                              RedirectAttributes attributes, Model model) {
        User user = (User)session.getAttribute("USER");
        if (user == null) {
            attributes.addFlashAttribute("msg", "Please Login");
            return "redirect:/springmvc/v2/userex/loginForm";
        }
        Article article = articleDao.getArticle(articleId);
        model.addAttribute("article", article);
        if (user.getUserId() == article.getUserId()) {
            return "/springmvc/v2/articleex/articleEdit";
        }
        return "/redirect:/springmvc/v2/articleex/articleList";
    }

    /**
     * AddArticle
     */
    @PostMapping("/addArticle")
    public String addArticle(@ModelAttribute Article article,
                             HttpSession session, RedirectAttributes attributes) {
        User user = (User)session.getAttribute("USER");
        if (user == null) {
            attributes.addFlashAttribute("msg", "Please Login");
            return "redirect:/springmvc/v2/userex/loginForm";
        }
        else {
            articleDao.addArticle(article);
            return "redirect:/springmvc/v2/articleex/articleList";
        }
    }

    /**
     * UpdateArticle
     */
    @PostMapping("/updateArticle")
    public String updateArticle(@ModelAttribute Article article,
                                HttpSession session, RedirectAttributes attributes) {
        User user = (User)session.getAttribute("USER");
        if (user == null) {
            attributes.addFlashAttribute("msg", "Please Login");
            return "redirect:/springmvc/v2/userex/loginForm";
        }
        article.setUserId(user.getUserId());
        int updatedRows = articleDao.updateArticle(article);
        if (updatedRows > 0)
            return "redirect:/springmvc/v2/articleex/articleView" + "?articleId=" + article.getArticleId();
        else {
            return "redirect:/springmvc/v2/userex/userInfo";
        }
    }

    /**
     * DeleteArticle
     */
    @GetMapping("/deleteArticle")
    public String deleteArticle(@RequestParam int articleId,
                                HttpSession session, RedirectAttributes attributes) {
        User user = (User)session.getAttribute("USER");
        if (user == null) {
            attributes.addFlashAttribute("msg", "Please Login");
            return "redirect:/springmvc/v2/userex/loginForm";
        }
        Article article = articleDao.getArticle(articleId);
        if (user.getUserId() == article.getUserId()) {
            articleDao.deleteArticle(articleId, user.getUserId());
            return "redirect:/springmvc/v2/articleex/articleList";
        }
        else {
            return "redirect:/springmvc/v2/userex/userInfo";
        }
    }
}
