package com.example.demo.SERVICE;
import com.example.demo.ENTITY.Role;
import com.example.demo.REPOSITOTY.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class RoleService {
    @Autowired private RoleRepository roleRepository;

    public List<Role> listAll(){
        return (List<Role>) this.roleRepository.findAll();
    }
    public void saveRole(Role role){
        this.roleRepository.save(role);
    }
    public Role getById(Integer id){
        Optional<Role> result = this.roleRepository.findById(id);
        if(result.isPresent()) return result.get();
        else return null;
    }
    public void delete(Integer id){
        this.roleRepository.deleteById(id);
    }
}
