package com.example.demo.REPOSITOTY;
import com.example.demo.ENTITY.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
