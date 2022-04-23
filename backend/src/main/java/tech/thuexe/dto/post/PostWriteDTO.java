package tech.thuexe.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.thuexe.entity.ImageEntity;
import tech.thuexe.entity.location.LocationEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostWriteDTO {
    private List<ImageEntity> images = new ArrayList<>();
    private double price;
    private String title;
    private String description;
    private LocationEntity location;
}
