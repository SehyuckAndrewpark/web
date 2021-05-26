package kr.mjc.sehyuckpark.web.springmvc.v2;

import kr.mjc.sehyuckpark.web.dao.User;
import kr.mjc.sehyuckpark.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Not Using Servlet API
 */
@Controller("userexControllerV2")
@RequestMapping("/springmvc/v2/userex")
public class UserexController {

    private final UserDao userDao;

    @Autowired
    public UserexController(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * UserList
     */
    @GetMapping("/userList")
    public void userList(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            Model model) {
        int count = 25;
        int offset = (page - 1) * count;
        List<User> userList = userDao.listUsers(offset, count);
        model.addAttribute("userList", userList);
    }

    /**
     * AddUser
     */
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user,
                          RedirectAttributes attributes) {
        try {
            userDao.addUser(user);
            return "redirect:/springmvc/v2/userex/userList";
        } catch (DuplicateKeyException e) {
            attributes.addFlashAttribute("msg", "Duplicate email");
            return "redirect:/springmvc/v2/userex/userForm";
        }
    }

    /**
     * Login
     */
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password,
                        HttpSession session, RedirectAttributes attributes) {
        try {
            User user = userDao.login(email, password);
            session.setAttribute("USER", user);
            return "redirect:/springmvc/v2/userex/userInfo";
        } catch (EmptyResultDataAccessException e) {
            attributes.addFlashAttribute("msg", "Wrong email or password");
            return "redirect:/springmvc/v2/userex/loginForm";
        }
    }

    /**
     * Logout
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
