package tech.thuexe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_Likes")

public class LikeEntity extends BaseEntity{

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName="id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="product_id",
            nullable=false)
    private PostEntity postLiked;

}
