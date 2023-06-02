package com.example.demo.REPOSITOTY;
import com.example.demo.ENTITY.OrdersLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrdersLineRepository extends CrudRepository<OrdersLine, Integer> {
}
