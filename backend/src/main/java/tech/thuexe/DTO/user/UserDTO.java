package tech.thuexe.DTO.user;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class UserDTO {
    private String name;
    private String username;
    private int createdAt;
    private String phone;
}
