package tech.thuexe.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "_user")
public class UserEntity extends BaseEntity {

    @Column(name = "_username", nullable = false, unique = true)
    private String username;

    @Column(name = "_password", nullable = false)
    private String password;

    @Column(name = "_phone", length = 10)
    private String phone;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Column(nullable = false)
    private Set<RoleEntity> roles = new HashSet<>();
}
