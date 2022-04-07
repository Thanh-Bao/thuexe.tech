package tech.thuexe.controller;

import org.modelmapper.ModelMapper;
import tech.thuexe.entity.RoleEntity;
import tech.thuexe.entity.UserEntity;
import tech.thuexe.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @RequiredArgsConstructor @RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;


    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getUser() {
        return  ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/controller/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<RoleEntity> saveRole(@RequestBody RoleEntity role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/controller/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getUsername(),form.getRoleName());
        return ResponseEntity.ok().build();
    }
}


@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}
