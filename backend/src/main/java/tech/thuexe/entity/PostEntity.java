package tech.thuexe.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_Post")
public class PostEntity extends BaseEntity {

    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JsonManagedReference
    private List<ImageEntity> images = new ArrayList<>();

    @Column
    private double price;

    @Column
    @Nationalized
    @Size(min = 5, max = 30, message = "Tên xe phải từ 5->30 ký tự")
    private String title;

    @Column
    @Nationalized
    @Size(min = 20, max = 5000, message = "Nội dung phải từ 20 đến 5000 ký tự")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @JsonManagedReference
    private LocationEntity location;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private UserEntity user;

    @Column
    private boolean rented;

    public void addImage(ImageEntity image) {
        images.add(image);
        image.setPost(this);
    }

    public void removeImage(ImageEntity image) {
        images.remove(image);
        image.setPost(null);
    }

}
