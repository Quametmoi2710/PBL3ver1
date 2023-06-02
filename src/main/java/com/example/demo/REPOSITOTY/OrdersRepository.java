package com.example.demo.REPOSITOTY;
import com.example.demo.ENTITY.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer> {
}
