package tech.thuexe.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.thuexe.service.PostService;
import tech.thuexe.service.UserService;
import tech.thuexe.utility.Paging;

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
    public String getPosts(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "5") int limit,
                           Model model){

        Paging paging = new Paging();
        paging.setPage(page);
        paging.setLimit(limit);
        Pageable pageable = PageRequest.of(page - 1, limit);
        paging.setTotalItem(postService.count());
        paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / paging.getLimit()));

        model.addAttribute("posts", postService.getPosts(pageable));
        model.addAttribute("paging", paging);
        return "posts";
    }
}
