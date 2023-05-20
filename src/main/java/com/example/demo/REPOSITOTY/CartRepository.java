package com.example.demo.REPOSITOTY;
import com.example.demo.ENTITY.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {
}
