package tech.thuexe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import static javax.persistence.FetchType.EAGER;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "_User")
public class UserEntity {
    @Column(name = "_name", length = 25)
    private String name;
    @Column(name = "_username", unique = true, nullable = false, length = 20)
    private String username;
    @Column(name = "_password", length = 20, nullable = false)
    private String password;
    @ManyToMany(fetch = EAGER)
    private Collection<RoleEntity> roles = new ArrayList<>();
}
