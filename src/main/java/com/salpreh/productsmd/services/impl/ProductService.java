package com.salpreh.productsmd.services.impl;

import java.util.Optional;
import java.util.UUID;

import com.salpreh.productsmd.config.ServicePagingConfig;
import com.salpreh.productsmd.dtos.ProductCreateDto;
import com.salpreh.productsmd.dtos.ProductDto;
import com.salpreh.productsmd.dtos.ProductUpdateDto;
import com.salpreh.productsmd.dtos.ResultPage;
import com.salpreh.productsmd.entities.Product;
import com.salpreh.productsmd.exceptions.ProductNotFoundException;
import com.salpreh.productsmd.repositories.ProductRepository;
import com.salpreh.productsmd.services.IProductService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    @Override
    public ProductDto create(ProductCreateDto product) {
        Product p = modelMapper.map(product, Product.class);
        p = productRepository.save(p);

        return modelMapper.map(p, ProductDto.class);
    }

    @Override
    public ResultPage<ProductDto> findAll(Optional<Integer> numPage, Optional<Integer> size) {
        Pageable pageable = PageRequest.of(
            numPage.orElse(ServicePagingConfig.DEFAULT_PAGE),
            size.orElse(ServicePagingConfig.DEFAULT_PAGE_SIZE)
        );

        Page<Product> page = productRepository.findAll(pageable);

        return modelMapper.map(page, new TypeToken<ResultPage<ProductDto>>() {}.getType());
    }

    @Override
    public ProductDto findById(UUID productId) {
        Product p = productRepository.findById(productId)
            .orElseThrow(ProductNotFoundException::new);

        return modelMapper.map(p, ProductDto.class);
    }

    @Override
    public ProductDto update(UUID productId, ProductUpdateDto product) {
        Product p = productRepository.findById(productId)
            .orElseThrow(ProductNotFoundException::new);

        if (product.getCopyright() == null) p.setCopyright(null);
        modelMapper.map(product, p);
        p = productRepository.save(p);

        return modelMapper.map(p, ProductDto.class);
    }

    @Override
    public ProductDto delete(UUID productId) {
        Product p = productRepository.findById(productId)
            .orElseThrow(ProductNotFoundException::new);

        productRepository.delete(p);

        return modelMapper.map(p, ProductDto.class);
    }
}
