package com.example.demo.SERVICE;
import com.example.demo.ENTITY.OrdersLine;
import com.example.demo.REPOSITOTY.OrdersLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersLineService {
    @Autowired private OrdersLineRepository ordersLineRepository;
    public List<OrdersLine> listAll(){
        return (List<OrdersLine>) this.ordersLineRepository.findAll();
    }
    public void saveOrdersLine(OrdersLine ordersLine){
        this.ordersLineRepository.save(ordersLine);
    }
    public OrdersLine getById(Integer id){
        Optional<OrdersLine> result = this.ordersLineRepository.findById(id);
        if(result.isPresent()) return result.get();
        else return null;
    }
    public void delete(Integer id){
        this.ordersLineRepository.deleteById(id);
    }
}
