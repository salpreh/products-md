package com.salpreh.productsmd.dtos;

import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class CopyrightUpdateDto {
    private String clause;
    private ZonedDateTime dueDate;
}
