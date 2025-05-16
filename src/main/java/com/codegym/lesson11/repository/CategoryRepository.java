package com.codegym.lesson11.repository;


import com.codegym.lesson11.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Long>{

}
