package com.example.demo.REPOSITOTY;
import com.example.demo.ENTITY.ParentCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ParentCategoryRepository extends CrudRepository<ParentCategory, Integer> {
}
