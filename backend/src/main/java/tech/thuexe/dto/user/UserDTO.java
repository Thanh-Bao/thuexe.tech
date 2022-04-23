package tech.thuexe.dto.user;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.thuexe.dto.RoleDTO;

import java.util.HashSet;
import java.util.Set;

@Data @NoArgsConstructor
public class UserDTO {
    private String name;
    private String username;
    private int createdAt;
    private boolean isActive ;
    private String phone;
    private Set<RoleDTO> roles = new HashSet<RoleDTO>();
}
