package com.example.demo.SERVICE;
import com.example.demo.ENTITY.User;
import com.example.demo.REPOSITOTY.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired private UserRepository userRepository;
    // Lấy ra danh sách người dùng
    public List<User> listAll(){
        return (List<User>) this.userRepository.findAll();
    }

    // Lưu người dùng
    public void saveUser(User user){
        this.userRepository.save(user);
    }

    // Lấy người dùng dựa trên id
    public User getById(Integer id){
        Optional<User> result = this.userRepository.findById(id);
        if(result.isPresent()) return result.get();
        else return null;
    }
    //Kiểm tra đăng nhập
    public boolean checkLogin(String username, String password){
        boolean check = false;
        List<User> userList = this.listAll();
        for(User user : userList){
            if(user.getUsername().equalsIgnoreCase(username)
                    && user.getPassword().equalsIgnoreCase(password)){
                check = true;
                break;
            }
        }
        return check;
    }

    //Kiểm tra đăng kí
    public boolean checkSignup(String username, String email, String phonenumber){
        boolean check = true;
        List<User> userList = this.listAll();
        for(User user : userList){
            if(user.getUsername().equalsIgnoreCase(username)
                || user.getPhonenumber().equalsIgnoreCase(phonenumber)
                || user.getEmail().equalsIgnoreCase(email)){
                check = false;
                break;
            }
        }
        return check;
    }
    public void delete(Integer id){
        this.userRepository.deleteById(id);
    }
}
