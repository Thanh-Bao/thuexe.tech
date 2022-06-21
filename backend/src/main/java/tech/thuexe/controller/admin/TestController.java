package tech.thuexe.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.thuexe.service.UserService;

@Controller
@RequestMapping("/ADMIN_MNG")
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public String getDashboard(){
        return "dashboard";
    }

    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("users", userService.getUsers());
        return "users";
    }
}
