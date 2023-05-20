package com.example.demo.REPOSITOTY;

import com.example.demo.ENTITY.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
