package com.salpreh.productsmd.controllers;

import java.util.Optional;
import java.util.UUID;

import com.salpreh.productsmd.dtos.ProductCreateDto;
import com.salpreh.productsmd.dtos.ProductDto;
import com.salpreh.productsmd.dtos.ProductUpdateDto;
import com.salpreh.productsmd.services.impl.ProductService;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDto create(@RequestBody ProductCreateDto product) {
        return productService.create(product);
    }

    @GetMapping
    public Page<ProductDto> read(@RequestParam Optional<Integer> page, @RequestParam Optional<Integer> size) {
        return productService.findAll(page, size);
    }

    @GetMapping("{productId}")
    public ProductDto readById(@PathVariable UUID productId) {
        return productService.findById(productId);
    }

    @PutMapping("{productId}")
    public ProductDto update(@PathVariable UUID productId, @RequestBody ProductUpdateDto product) {
        return productService.update(productId, product);
    }

    @DeleteMapping("{productId}")
    public ProductDto update(@PathVariable UUID productId) {
        return productService.delete(productId);
    }
}
