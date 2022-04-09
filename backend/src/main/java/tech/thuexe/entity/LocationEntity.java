package tech.thuexe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_Location")
public class LocationEntity extends BaseEntity {

    @Column
    private String province;

    @Column
    private String district;

    @Column
    private String ward;

    @Column
    private String street;

    @OneToOne(mappedBy = "location")
    private PostEntity post;

}
