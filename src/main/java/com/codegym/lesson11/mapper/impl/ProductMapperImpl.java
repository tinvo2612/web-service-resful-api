package com.codegym.lesson11.mapper.impl;

import com.codegym.lesson11.dto.ProductDto;
import com.codegym.lesson11.entity.Product;
import com.codegym.lesson11.mapper.ProductMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDto entityToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public Product dtoToEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }
}
