package com.salpreh.productsmd.dtos;

import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class CopyrightCreateDto {
    private String clause;
    private ZonedDateTime dueDate;
}
