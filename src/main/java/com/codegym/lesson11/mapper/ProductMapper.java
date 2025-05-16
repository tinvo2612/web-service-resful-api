package com.codegym.lesson11.mapper;

import com.codegym.lesson11.dto.ProductDto;
import com.codegym.lesson11.entity.Product;

import java.util.List;

public interface ProductMapper {
    ProductDto entityToDto(Product product);

    /*không biết khi nào dùng cái này */
    Product dtoToEntity(ProductDto productDto);
}
