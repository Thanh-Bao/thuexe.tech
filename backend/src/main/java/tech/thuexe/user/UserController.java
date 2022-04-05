package tech.thuexe.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @GetMapping
    public Object findAll() {
        return "Hello";
    }

    @GetMapping("/profile/{username}")
    public Object getUserByUsername(@PathVariable(name = "username") String username) {
        return "Hello";
    }

    @PostMapping("/follow")
    public Object followUser(){
        return "Hello";
    }

    @PostMapping("/unfollow")
    public Object unfollowUser(){
        return "Hello";
    }
}

