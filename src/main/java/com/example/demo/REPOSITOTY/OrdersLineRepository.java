package com.example.demo.REPOSITOTY;

import com.example.demo.ENTITY.OrdersLine;
import org.springframework.data.repository.CrudRepository;

public interface OrdersLineRepository extends CrudRepository<OrdersLine, Integer> {
}
