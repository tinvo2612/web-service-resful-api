package com.codegym.lesson11.repository;

import com.codegym.lesson11.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.link = :productLink")
    Product findByLink(@Param("productLink") String productLink);

    @Query("SELECT p FROM Product p WHERE p.name like %:name%")
    List<Product> findByName(@Param("name") String name);
}
