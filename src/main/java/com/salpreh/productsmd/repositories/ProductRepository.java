package com.salpreh.productsmd.repositories;

import java.util.UUID;

import com.salpreh.productsmd.entities.Product;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, UUID> { }
