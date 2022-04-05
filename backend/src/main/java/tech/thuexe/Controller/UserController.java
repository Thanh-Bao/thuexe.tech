package tech.thuexe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.thuexe.DAO.RoleRepository;
import tech.thuexe.DAO.UserRepository;
import tech.thuexe.entity.RoleEntity;
import tech.thuexe.entity.UserEntity;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String findAll() {
        String username = "Bao123";
        String password = "has1234";
        String role ="Admin";
        UserEntity e = new UserEntity();
        e.setUsername(username);
        e.setPassword(password);
        RoleEntity newRole = roleRepository.findByName(role);
        e.getRoles().add(newRole);
        userRepository.save(e);
        return "XXXX" + e;
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

