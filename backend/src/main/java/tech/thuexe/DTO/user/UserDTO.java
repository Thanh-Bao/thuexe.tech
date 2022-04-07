package tech.thuexe.DTO.user;
import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String username;
    private int createdAt;
    private String phone;
}
