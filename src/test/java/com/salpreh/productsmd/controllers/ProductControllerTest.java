package com.salpreh.productsmd.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.ZonedDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salpreh.productsmd.dtos.CopyrightCreateDto;
import com.salpreh.productsmd.dtos.ProductCreateDto;
import com.salpreh.productsmd.entities.Product;
import com.salpreh.productsmd.repositories.ProductRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createProduct_success() throws Exception {
        assertEquals(0, productRepository.count());

        ProductCreateDto product = buildDummyCreateProduct();

        this.mockMvc.perform(
            post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    objectMapper.writeValueAsString(product)
                )
        )
        .andExpect(status().is2xxSuccessful());

        List<Product> products = productRepository.findAll();
        assertEquals(1, products.size());

        Product p = products.get(0);
        assertNotNull(p.getCopyright());
        assertNotNull(p.getCreatedAt());
    }

    private ProductCreateDto buildDummyCreateProduct() {
        ProductCreateDto p = new ProductCreateDto();

        p.setTitle("Dummy product");
        p.setDescription("description");
        p.setImageUrl("https://dummy_file.jpg");
        p.setCopyright(new CopyrightCreateDto() {{
            setClause("Trademark clause");
            setDueDate(ZonedDateTime.now());
        }});

        return p;
    }
}
