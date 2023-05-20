package com.example.demo.REPOSITOTY;

import com.example.demo.ENTITY.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
}
