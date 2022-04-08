package tech.thuexe.controller.enpointAPI;

import org.springframework.validation.annotation.Validated;
import tech.thuexe.DTO.user.UserDTO;
import tech.thuexe.entity.RoleEntity;
import tech.thuexe.entity.UserEntity;
import tech.thuexe.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController @RequiredArgsConstructor @RequestMapping("/api") @Validated
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUser() {
        return  ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/users/test")
    public ResponseEntity<String> test() {
        return  ResponseEntity.ok().body(userService.getUsername());
    }

    @PostMapping("/user/save")
    public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserEntity user)  {
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
