package com.salpreh.productsmd.dtos;

import lombok.Data;

@Data
public class ProductCreateDto {
    private String title;
    private String description;
    private String imageUrl;
    private CopyrightCreateDto copyright;
}
