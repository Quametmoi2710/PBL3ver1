package com.example.demo.SERVICE;
import com.example.demo.ENTITY.Product;
import com.example.demo.REPOSITOTY.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired private ProductRepository productRepository;
    public List<Product> listAll(){
        return (List<Product>) this.productRepository.findAll();
    }
    public void saveProduct(Product product){
        this.productRepository.save(product);
    }
    public Product getById(Integer id){
        Optional<Product> result = this.productRepository.findById(id);
        if(result.isPresent()) return result.get();
        else return null;
    }
    public void delete(Integer id){
        this.productRepository.deleteById(id);
    }
}
