package tech.thuexe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDetailEntity {

    @OneToMany(mappedBy = "itemDetail")
    private List<ImageEntity> images = new ArrayList<>();
}
