package com.example.demo.REPOSITOTY;
import com.example.demo.ENTITY.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
