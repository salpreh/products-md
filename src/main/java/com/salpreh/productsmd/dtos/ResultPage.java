package com.salpreh.productsmd.dtos;

import java.util.List;

import lombok.Data;

@Data
public class ResultPage<T> {
    private List<T> content;
    private int totalPages;
    private int numberOfElements;
}
