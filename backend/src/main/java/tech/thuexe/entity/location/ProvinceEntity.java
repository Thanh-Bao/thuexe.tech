package tech.thuexe.entity.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_Province")
public class ProvinceEntity {

    @Id
    private int id;

    @Column(name = "_name", length = 50, nullable = false)
    private String name;

    @Column(name = "_code", length = 20, nullable = false)
    private String code;

}
