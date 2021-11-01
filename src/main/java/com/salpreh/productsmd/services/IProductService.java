package com.salpreh.productsmd.services;

import java.util.Optional;
import java.util.UUID;

import com.salpreh.productsmd.dtos.ProductCreateDto;
import com.salpreh.productsmd.dtos.ProductDto;
import com.salpreh.productsmd.dtos.ProductUpdateDto;

import org.springframework.data.domain.Page;

public interface IProductService {

    ProductDto create(ProductCreateDto product);
    Page<ProductDto> findAll(Optional<Integer> numPage, Optional<Integer> size);
    ProductDto findById(UUID productId);
    ProductDto update(UUID productId, ProductUpdateDto product);
    ProductDto delete(UUID productId);
}
