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
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;

@Controller("userControllerV2")
@RequestMapping("/springmvc/v2/user")
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/userList")
    public void userList(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "20") int count,
            Model model) {
        int offset = (page - 1) * count;
        List<User> userList = userDao.listUsers(offset, count);
        int totalCount = userDao.countUsers();
        model.addAttribute("userList", userList);
        model.addAttribute("totalCount", totalCount);
    }

    @GetMapping("/userInfo")
    public void userInfo(@RequestParam(required = false) Integer userId,
                         Model model) {
        model.addAttribute("user", userDao.getUser(userId));
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user,
                          RedirectAttributes attributes) {
        try {
            userDao.addUser(user);
            return "redirect:/springmvc/v2/user/userList";
        } catch (DuplicateKeyException e) {
            attributes.addFlashAttribute("msg", "Duplicate email");
            return "redirect:/springmvc/v2/user/userForm";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password,
                        @RequestParam(required = false, defaultValue = "/") String returnUrl,
                        HttpSession session, RedirectAttributes attributes) {
        try {
            User user = userDao.login(email, password);
            session.setAttribute("USER", user);
            return "redirect:" + returnUrl;
        } catch (EmptyResultDataAccessException e) {
            attributes.addFlashAttribute("email", email);
            attributes.addFlashAttribute("msg", "Wrong email or password");
            return "redirect:/springmvc/v2/user/loginForm?returnUrl=" +
                    URLEncoder.encode(returnUrl, Charset.defaultCharset());
        }
    }

    @PostMapping("/updateUser")
    public String updateUser(User user,
                             @SessionAttribute("USER") User sessionUser,
                             RedirectAttributes attributes) {
        try {
            user.setUserId(sessionUser.getUserId());
            userDao.updateUser(user);
            sessionUser.setEmail(user.getEmail());
            sessionUser.setName(user.getName());
            return "redirect:/springmvc/v2/user/myInfo";
        } catch (DuplicateKeyException e) {
            attributes.addFlashAttribute("user", user);
            attributes.addFlashAttribute("msg", "Duplicate email");
            return "redirect:/springmvc/v2/user/userEdit";
        }
    }

    @PostMapping("/updatePassword")
    public String updatePassword(String password, String newPassword,
                                 @SessionAttribute("USER") User user, RedirectAttributes attributes) {
        int result =
                userDao.updatePassword(user.getUserId(), password, newPassword);
        if (result > 0) {
            return "redirect:/springmvc/v2/user/myInfo";
        } else {
            attributes.addFlashAttribute("msg", "Wrong password");
            return "redirect:/springmvc/v2/user/passwordForm";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}

