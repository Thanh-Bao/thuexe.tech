package tech.thuexe.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

        model.addAttribute("posts", postService.getPostsAreNotRent(pageable));
        model.addAttribute("paging", paging);
        return "posts";
    }

    @GetMapping("/posts/desc")
    public String getPostsDesc(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "5") int limit,
                           Model model){

        Paging paging = new Paging();
        paging.setPage(page);
        paging.setLimit(limit);
        Pageable pageable = PageRequest.of(page - 1, limit);
        paging.setTotalItem(postService.count());
        paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / paging.getLimit()));

        model.addAttribute("posts", postService.findAllByTitleDesc(pageable));
        model.addAttribute("paging", paging);
        return "postsDesc";
    }

    @GetMapping("/posts/asc")
    public String getPostsAsc(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "limit", defaultValue = "5") int limit,
                               Model model){

        Paging paging = new Paging();
        paging.setPage(page);
        paging.setLimit(limit);
        Pageable pageable = PageRequest.of(page - 1, limit);
        paging.setTotalItem(postService.count());
        paging.setTotalPage((int) Math.ceil((double) paging.getTotalItem() / paging.getLimit()));

        model.addAttribute("posts", postService.findAllByTitleAsc(pageable));
        model.addAttribute("paging", paging);
        return "postsAsc";
    }

    @GetMapping("/posts/search")
    public String search(@RequestParam(value = "value", defaultValue = "kia") String value, Model model){
        model.addAttribute("posts", postService.findAllByName(value));
        return "search";
    }
}
