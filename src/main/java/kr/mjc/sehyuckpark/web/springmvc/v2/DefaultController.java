package kr.mjc.sehyuckpark.web.springmvc.v2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/**")
    public void mapDefault() {
    }

    @GetMapping("/")
    public String mapIndex() {
        return "index"; // forward /WEB-INF/jsp/index.jsp
    }
}