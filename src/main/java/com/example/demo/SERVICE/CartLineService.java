package com.example.demo.SERVICE;
import com.example.demo.ENTITY.CartLine;
import com.example.demo.REPOSITOTY.CartLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CartLineService {
    @Autowired private CartLineRepository cartLineRepository;
    public List<CartLine> listAll(){
        return (List<CartLine>) this.cartLineRepository.findAll();
    }
    public void saveCartLine(CartLine cartLine){
        this.cartLineRepository.save(cartLine);
    }
    public CartLine getById(Integer id){
        Optional<CartLine> result = this.cartLineRepository.findById(id);
        if(result.isPresent()) return result.get();
        else return null;
    }
    public void delete(Integer id){
        this.cartLineRepository.deleteById(id);
    }
    public void deleteAllByUserId(int user_id){
        List<CartLine> cartLineList = this.listAll();
        for(CartLine cartLine : cartLineList){
            if(cartLine.getUser().getId() == user_id){
                this.delete(cartLine.getId());
            }
        }
    }
}
