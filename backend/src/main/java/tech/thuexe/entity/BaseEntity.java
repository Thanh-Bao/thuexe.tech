package tech.thuexe.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @Setter(AccessLevel.NONE)
    @Column(name="_id",updatable = false, nullable = false)
    private String id = UUID.randomUUID().toString() ;

    //Unix Timestamp
    @Column(name="_createAt")
    private long createAt = Instant.now().getEpochSecond();
}
