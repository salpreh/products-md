package com.salpreh.productsmd.entities;

import java.time.ZonedDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private UUID id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private ZonedDateTime createdAt;

    @Column
    private String imageUrl;

    @PrePersist
    public void prePersist() {
        if (createdAt == null) createdAt = ZonedDateTime.now();
    }
}
