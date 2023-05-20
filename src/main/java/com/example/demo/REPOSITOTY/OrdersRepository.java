package com.example.demo.REPOSITOTY;

import com.example.demo.ENTITY.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {
}
