package com.salpreh.productsmd.dtos;

import java.time.ZonedDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class CopyrightDto {
    private UUID id;
    private String clause;
    private ZonedDateTime dueDate;
}
