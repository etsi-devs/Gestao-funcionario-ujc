package mz.ac.ujc.esa.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
// @RestController
@RequestMapping
public class HomeController {

    @GetMapping("/admin")
    public String adminView() {
    return "iframe";
    }


    @GetMapping("/home")
    public String userView() {
        return "user/iframe";
    }

    @GetMapping("/gestor")
    public String gestorView() {
        return "gestor/iframe";
    }

    @GetMapping("/welcome")
    public String welcomeView() {
        return "welcome";
    }

}
