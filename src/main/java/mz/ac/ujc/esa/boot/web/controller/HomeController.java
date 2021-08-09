package mz.ac.ujc.esa.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
// @RestController
public class HomeController {

    @GetMapping("/admin")
    public String adminView() {
        return "/iframe";
    }

    @GetMapping("/home")
    public String userView() {
        return "user/iframe";
    }

    @GetMapping("/gestor")
    public String gestorView() {
        return "gestor/iframe";
    }
}
