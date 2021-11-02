package com.salpreh.productsmd.repositories;

import java.util.UUID;

import com.salpreh.productsmd.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> { }
