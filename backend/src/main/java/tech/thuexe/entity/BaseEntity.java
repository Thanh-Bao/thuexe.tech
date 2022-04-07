package tech.thuexe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Data 
public class BaseEntity {

    @Id
    private String id = UUID.randomUUID().toString();

    @CreatedDate
    @Column(name="_createdAt", nullable = false)
    private int createdAt = (int) Instant.now().getEpochSecond();

    @CreatedBy
    @Column(name="_createdBy")
    private String createdBy;

}
