package tech.thuexe.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ADMIN_MNG")
public class TestController {
    @GetMapping("/test")
    public String usersMNG(){
        return "test";
    }
}
