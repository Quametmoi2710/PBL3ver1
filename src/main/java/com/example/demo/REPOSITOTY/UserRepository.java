package com.example.demo.REPOSITOTY;
import com.example.demo.ENTITY.User;
import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<User, Integer> {

}
