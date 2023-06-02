package com.example.demo.REPOSITOTY;
import com.example.demo.ENTITY.ProductCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
}
