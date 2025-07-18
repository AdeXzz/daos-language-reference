package com.innovyze.aquaservice.platform.u202311334.shared.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;
}
