package com.example.demo.CONTROLLER;
import com.example.demo.ENTITY.User;
import com.example.demo.SERVICE.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
@Controller
public class UserController {
    @Autowired private UserService userService;

    //Phương thức hiển thị trang chủ
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    //Phương thức hiển thị trang đăng nhập tài khoản
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    //Phương thức hiển thị trang đăng kí tài khoản
    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    //Phương thức hiển thị giỏ hàng
    @GetMapping("/cart")
    public String cart(HttpSession session){
        return"cart";
    }

    //Phương thức hiển thị trang contact
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    //Phương thức hiển thị chi tiết sản phẩm
    @GetMapping("/detail")
    public String detail(){
        return "detail";
    }

    //Phương thức hiển trang shop
    @GetMapping("/shop")
    public String shop(){
        return "shop";
    }

    //Nơi xử lí phương thức đăng kí tài khoản
    @PostMapping("/checkSignup")
    public String save(Model model, User user, RedirectAttributes ra){
        if(userService.checkSignup(user.getUsername(), user.getEmail(), user.getPhonenumber())){
            this.userService.saveUser(user);
            model.addAttribute("notify_signup", "Register successfully");
            ra.addFlashAttribute("message", "The user has been saved successfully.");
            return "shop";
        }
        else model.addAttribute("notify_signup","Information has been already");
        return "signup";
    }

    //Hàm xử lí kiểm tra Login
    @PostMapping("/checkLogin")
    public String checkLogin(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, Model model, HttpSession session){
        if(userService.checkLogin(username, password)){
            session.setAttribute("account", username);
            return "shop";
        }
        model.addAttribute("notify_login", "Invalid username or password");
        return"login";
    }
}
