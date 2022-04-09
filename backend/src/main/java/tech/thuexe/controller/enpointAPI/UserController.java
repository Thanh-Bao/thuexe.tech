package tech.thuexe.controller.enpointAPI;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import tech.thuexe.DTO.user.UserDTO;
import tech.thuexe.entity.UserEntity;
import tech.thuexe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.thuexe.utility.CustomException;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController @RequiredArgsConstructor @RequestMapping(path = "${APIVersion}/user") @Validated
public class UserController {

    private final UserService userService;

    @CrossOrigin(origins="*")
    @GetMapping("/haha")
        public String haha(){
            return "haha";
        }

    @GetMapping("/exist/{username}")
    public ResponseEntity<Boolean> checkUserExist(@PathVariable String username) {
        return  ResponseEntity.ok().body(userService.exists(username));
    }

    @GetMapping("/isactive/{username}")
    public ResponseEntity<Boolean> checkUserIsActive(@PathVariable String username) throws CustomException {
        if(!userService.exists(username)){
            throw new CustomException("Username không tồn tại, hãy kiểm tra lại", HttpStatus.BAD_REQUEST);
        }
        boolean isActive = userService.getUser(username).isActive();
        return ResponseEntity.ok().body(isActive);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return  ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserEntity user) throws CustomException {
        if(userService.exists(user.getUsername())){
            throw new CustomException("Username đã tồn tại, hãy chọn username khác", HttpStatus.BAD_REQUEST);
        }
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path(null).toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

}


