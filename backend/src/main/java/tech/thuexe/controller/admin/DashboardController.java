package tech.thuexe.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/admin/dashboard")
    public String getDashBoard(){
    return "dashboard";
    }

    @GetMapping("/admin/users")
    public String getUsers(){
        return "users";
    }

    @GetMapping("/admin/login")
    public String getLoginPage(){
        return "login";
    }
}
