package com.example.demo.SERVICE;
import com.example.demo.ENTITY.ProductCategory;
import com.example.demo.REPOSITOTY.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ProductCategoryService {
    @Autowired private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> listAll(){
        return (List<ProductCategory>) this.productCategoryRepository.findAll();
    }
    public void saveProductCategory(ProductCategory productCategory){
        this.productCategoryRepository.save(productCategory);
    }
    public ProductCategory getById(Integer id){
        Optional<ProductCategory> result = this.productCategoryRepository.findById(id);
        if(result.isPresent()) return result.get();
        else return null;
    }
    public void delete(Integer id){
        this.productCategoryRepository.deleteById(id);
    }
}
