package com.example.demo.REPOSITOTY;
import com.example.demo.ENTITY.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
