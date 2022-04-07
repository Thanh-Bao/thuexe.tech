package tech.thuexe.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Id
    private String id = UUID.randomUUID().toString();

    @CreatedDate
    @Column(name="_createdDate", nullable = false)
    private Date createdDate;

    @CreatedBy
    @Column(name="_createdBy")
    private String createdBy;

}
