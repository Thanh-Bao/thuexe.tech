package tech.thuexe.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name="_role")
public class RoleEntity extends BaseEntity {
    @Column(name="_name", nullable = false, length = 20)
    private String name;

    @Column(name="_description")
    private String description;

    @ManyToMany
    private Set<UserEntity> user = new HashSet<>();
}
