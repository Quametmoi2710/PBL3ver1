package com.example.demo.SERVICE;
import com.example.demo.ENTITY.Orders;
import com.example.demo.REPOSITOTY.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class OrderService {
    @Autowired private OrdersRepository ordersRepository;
    public List<Orders> listAll(){
        return (List<Orders>) this.ordersRepository.findAll();
    }
    public void saveOrders(Orders orders){
        this.ordersRepository.save(orders);
    }
    public Orders getById(Integer id){
        Optional<Orders> result = this.ordersRepository.findById(id);
        if(result.isPresent()) return result.get();
        else return null;
    }
    public void delete(Integer id){
        this.ordersRepository.deleteById(id);
    }
}
