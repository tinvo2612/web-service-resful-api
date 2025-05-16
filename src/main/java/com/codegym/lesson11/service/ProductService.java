package com.codegym.lesson11.service;

import com.codegym.lesson11.dto.ProductDto;
import com.codegym.lesson11.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> getProducts();

    ProductDto getProductById(Long id);

    void createNewProduct(ProductDto productDto);

    List<ProductDto> findProductByName(String name);


    void deleteProduct(Long id);

//    ProductDto getProductByCategoryId(ProductDto productDto);

    void updateProduct(Long id,ProductDto productDto);

}
