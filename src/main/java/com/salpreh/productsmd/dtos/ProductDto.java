package com.salpreh.productsmd.dtos;

import java.time.ZonedDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class ProductDto {
    private UUID id;
    private String title;
    private String description;
    private ZonedDateTime createdAt;
    private String imageUrl;
    private CopyrightDto copyright;
}
