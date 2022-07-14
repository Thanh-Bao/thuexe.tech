package tech.thuexe.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.thuexe.service.PostService;
import tech.thuexe.service.UserService;

@Controller
@RequestMapping("/ADMIN_MNG")
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping("/dashboard")
    public String getDashboard(){
        return "dashboard";
    }

    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/posts")
    public String getPosts(Model model){
        model.addAttribute("posts", postService.getPosts());
        return "posts";
    }
}
