package com.codegym.lesson11.controller;


import com.codegym.lesson11.dto.ProductDto;
import com.codegym.lesson11.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProducts() {
        List<ProductDto> productDtoList = productService.getProducts();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getPorudct(@PathVariable Long id){
        ProductDto productDto = productService.getProductById(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> searchProduct(@Valid @RequestParam String name){
        List<ProductDto> searchResults = productService.findProductByName(name);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto){
        productService.createNewProduct(productDto);
                return new ResponseEntity<>("Create product successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Delete product successfully", HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,@RequestBody ProductDto productDto){
        productService.updateProduct(id, productDto);
        return new ResponseEntity<>("Update product successfully", HttpStatus.OK);
    }

}