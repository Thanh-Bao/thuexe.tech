package tech.thuexe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageEntity {

    @Column(nullable = false)
    private String link;

    @ManyToOne
    @JoinColumn(name="product_id",
                nullable=false)
    private PostDetailEntity itemDetail;



}
