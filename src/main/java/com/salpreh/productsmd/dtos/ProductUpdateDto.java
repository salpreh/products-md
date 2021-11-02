package com.salpreh.productsmd.dtos;

import lombok.Data;

@Data
public class ProductUpdateDto {
    private String title;
    private String description;
    private String imageUrl;
    private CopyrightUpdateDto copyright;
}
