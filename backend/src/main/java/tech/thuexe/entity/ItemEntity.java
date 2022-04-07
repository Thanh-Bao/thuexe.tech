package tech.thuexe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity extends BaseEntity{

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private UserEntity user;

}
