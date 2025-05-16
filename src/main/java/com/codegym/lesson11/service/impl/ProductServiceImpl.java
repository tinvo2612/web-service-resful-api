package com.codegym.lesson11.service.impl;

import com.codegym.lesson11.dto.ProductDto;
import com.codegym.lesson11.entity.Category;
import com.codegym.lesson11.entity.Product;
import com.codegym.lesson11.mapper.ProductMapper;
import com.codegym.lesson11.repository.CategoryRepository;
import com.codegym.lesson11.repository.ProductRepository;
import com.codegym.lesson11.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductDto> getProducts() {
        List<Product> entities = productRepository.findAll();
        return entities.stream()
                        .map(product -> productMapper.entityToDto(product))
                        .collect(Collectors.toList());
    }

    @Override
    public ProductDto  getProductById(Long id){
        Optional<Product> product = productRepository.findById(id);
        return productMapper.entityToDto(product.get());
    }

    @Override
    public void createNewProduct(ProductDto productDto){
        Product existingProduct = productRepository.findByLink(productDto.getLink());
        if(Optional.ofNullable(existingProduct).isEmpty()){
            Optional<Category> existingCategory = categoryRepository.findById(productDto.getCategoryId());
            Product newProduct = productMapper.dtoToEntity(productDto);
            newProduct.setCategory(existingCategory.get());
            productRepository.save(newProduct);
        } else
        {
            try{
                throw new Exception("Product is existing");
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id).get();

        if(Optional.ofNullable(existingProduct).isPresent()){
        try {
            productRepository.deleteById(id);
            } catch (Exception e) {
            throw new RuntimeException("Error delete by ID: " + id, e);
            }
        }
    }

    @Override
    public void updateProduct(Long id,ProductDto productDto) {
        Product existingProduct = productRepository.findById(productDto.getId()).get();

        if(Optional.ofNullable(existingProduct).isPresent()){
            Category existingCategory = categoryRepository.findById(productDto.getCategoryId()).get();
            existingProduct = productMapper.dtoToEntity(productDto);
            existingProduct.setCategory(existingCategory);
            productRepository.save(existingProduct);
        }
    }


    @Override
    public List<ProductDto> findProductByName(String name) {
                List<Product> entities = productRepository.findByName(name);
        return entities.stream().map(product -> productMapper.
                entityToDto(product)).collect(Collectors.toList()
        );
        }
    }



