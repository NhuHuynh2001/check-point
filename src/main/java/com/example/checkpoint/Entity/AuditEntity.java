package com.example.checkpoint.Entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AuditEntity {

//    @CreatedBy
//    private String createBy;

//    @LastModifiedBy
//    private String modifierBy;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifierDate;

}
