package com.example.demo.CONTROLLER;
import com.example.demo.ENTITY.*;
import com.example.demo.SERVICE.*;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
@Controller
public class UserController {
    @Autowired private UserService userService;
    @Autowired private ProductService productService;
    @Autowired private RoleService roleService;
    @Autowired private CartLineService cartLineService;
    @Autowired private OrdersLineService ordersLineService;
    @Autowired private OrderService orderService;

    @Autowired private ContactService contactService;

    //Phương thức hiển thị trang cá nhân
    @GetMapping("/information")
    public String information(HttpSession session, Model model){
        String username = (String) session.getAttribute("account");
        User user = this.userService.getByUsername(username);

        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("address", user.getAddress());
        model.addAttribute("phonenumber", user.getPhonenumber());
        model.addAttribute("birthday", user.getBirthday().toString());

        if(user.getOrdersList() != null && user.getOrdersList().size() > 0){
            List<Orders> ordersList = user.getOrdersList();
            model.addAttribute("ordersList", ordersList);
        }
        return"information";
    }

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
    public String cart(HttpSession session, Model model){
        if(session.getAttribute("account") != null){
            // Lấy ra tài khoản user hiện ta đăng đăng nhập
            String username = (String) session.getAttribute("account");
            User user = this.userService.getByUsername(username);
            List<CartLine> cartLineList = user.getCartLineList();
            model.addAttribute("username", username);
            model.addAttribute("cartLineList", cartLineList);

            int discount = 0;
            if(session.getAttribute("discount") != null) discount = (int) session.getAttribute("discount");
            model.addAttribute("discount", discount);

            int totalPriceForProduct = 0;
            for(CartLine cartLine : cartLineList){
                totalPriceForProduct += cartLine.getTotal();
            }
            model.addAttribute("totalPriceForProduct", totalPriceForProduct);

            int priceForShip = 50;
            if(user.getCartLineList().size() == 0) priceForShip = 0;
            model.addAttribute("priceForShip", priceForShip);


            int totalForOrders = totalPriceForProduct + priceForShip - discount;
            model.addAttribute("totalForOrders", totalForOrders);
            return "cart";
        }
        return "login";
    }

    //Phương thức hiển thị trang contact
    @GetMapping("/contact")
    public String contact(HttpSession session, Model model){
        String username = (String) session.getAttribute("account");
        model.addAttribute("username", username);
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    //Phương thức hiển thị chi tiết sản phẩm
    @GetMapping("/detail")
    public String detail(){
        return "detail";
    }

    //Phương thức hiển trang shop
    @GetMapping("/shop")
    public String shop(Model model, HttpSession session){
        String username = (String) session.getAttribute("account");
        User user = this.userService.getByUsername(username);
        int numberOfCartLine = user.getCartLineList().size();
        model.addAttribute("numberOfCartLine", numberOfCartLine);
        model.addAttribute("username", username);
        return "shop";
    }

    //Nơi xử lí phương thức đăng kí tài khoản
    @PostMapping("/checkSignup")
    public String save(RedirectAttributes ra, Model model, User user, @RequestParam(name = "commit_password") String commit_password){
        if(this.userService.checkSignup(user.getUsername(),user.getEmail(), user.getPhonenumber())){
            if(commit_password.equalsIgnoreCase(user.getPassword())){
                Role role = this.roleService.getById(2);
                role.addUser(user);
                user.setRole(role);
                this.userService.saveUser(user);
                String username = user.getUsername();
                model.addAttribute("notify_signup", "Đăng kí tài khoản thành công");
                return "login";
            }
            else{
                model.addAttribute("notify_signup", "Nhập lại mật khẩu không đúng !");
                return "signup";
            }
        }
        model.addAttribute("notify_signup", "Thông tin tài khoản đã tồn tại !");
        return "signup";
    }

    //Hàm xử lí kiểm tra Login
    @PostMapping("/checkLogin")
    public String checkLogin(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, HttpSession session, RedirectAttributes ra, Model model){
        if(userService.checkLogin(username, password)){
            User user = this.userService.getByUsername(username);
            session.setAttribute("account", username);
            model.addAttribute("username", username);
            int numberOfCartLine = user.getCartLineList().size();
            model.addAttribute("numberOfCartLine", numberOfCartLine);
            return "shop";
        }
        else if(username.equalsIgnoreCase("") || password.equalsIgnoreCase("")){
            ra.addFlashAttribute("notify_login", "Chưa nhập mật khẩu hoặc tài khoản");
            return"redirect:/login";
        }
        ra.addFlashAttribute("notify_login", "Tài khoản hoặc mật khẩu không hợp lệ");
        return"redirect:/login";
    }

    //Hàm xử lí thêm vào giỏ hàng
    @GetMapping("/addProductToCart/{id}")
    public String addToCart(@PathVariable(name = "id") Integer id, HttpSession session){
        String username = (String) session.getAttribute("account");
        User user = this.userService.getByUsername(username);
        Product product = this.productService.getById(id);
        if(user.getCartLineList() != null){
            List<CartLine> cartLineList = user.getCartLineList();
            int position = -1;
            boolean check = false;
            for(CartLine cartLine : cartLineList){
                position++;
                if(cartLine.getName_product().equalsIgnoreCase(product.getName())){
                    check = true;
                    break;
                }
            }
            if(check){
                cartLineList.get(position).setQuantity(cartLineList.get(position).getQuantity() + 1);
                cartLineList.get(position).setTotal(cartLineList.get(position).getPrice() * cartLineList.get(position).getQuantity());
                user.setCartLineList(cartLineList);
                this.userService.saveUser(user);
                return "redirect:/shop";
            }
        }
        CartLine cartLine = new CartLine();
        cartLine.setProduct(product);
        cartLine.setName_product(product.getName());
        cartLine.setPrice(product.getPrice());
        cartLine.setQuantity(1);
        cartLine.setTotal(cartLine.getPrice() * cartLine.getQuantity());
        cartLine.setUser(user);
        user.addCartLine(cartLine);
        this.userService.saveUser(user);
        return "redirect:/shop";
    }
    //Hàm xử lí đặt hàng
    @GetMapping("/orders")
    public String Orders(HttpSession session, RedirectAttributes ra){
        String username = (String) session.getAttribute("account");
        User user = this.userService.getByUsername(username);
        //Kiểm tra sản phẩm có trong giỏ hàng
        if(user.getCartLineList().size() > 0){
            List<CartLine> cartLineList = user.getCartLineList();
            Orders orders = new Orders();
            int totalPriceForOrders = 0;
            for(CartLine cartLine : cartLineList){
                OrdersLine ordersLine = new OrdersLine();
                Product product = cartLine.getProduct();
                if(product.getRemainQuantity() > 0){
                    totalPriceForOrders += cartLine.getTotal();

                    product.setRemainQuantity(product.getRemainQuantity() - 1);
                    product.setSoldQuantity(product.getSoldQuantity() + 1);
                    this.productService.saveProduct(product);

                    ordersLine.setProduct(product);
                    ordersLine.setNameProduct(cartLine.getName_product());
                    ordersLine.setQuantity(cartLine.getQuantity());
                    ordersLine.setPrice(cartLine.getPrice());
                    ordersLine.setTotal(cartLine.getTotal());
                    ordersLine.setOrders(orders);
                    orders.addOrdersLine(ordersLine);
                }
            }
            int discount = 0;
            if(session.getAttribute("discount") != null) discount = (int) session.getAttribute("discount");
            orders.setUser(user);
            orders.setOrderAddress(user.getAddress());
            orders.setOrderPhonenumber(user.getPhonenumber());
            orders.setStatus("Đang chờ phê duyệt");
            orders.setTotal(totalPriceForOrders - discount);
            orders.setOrderDate(new Date(Calendar.getInstance().getTime().getTime()));
            //orders.setShipDate();
            user.addOrders(orders);
            user.clearAllCartLineList();
            this.userService.saveUser(user);
            this.cartLineService.deleteAllByUserId(user.getId());
            session.removeAttribute("discount");
            ra.addFlashAttribute("notify_orders", "Đặt hàng thành công !");
            ra.addFlashAttribute("check", 1);
            return "redirect:/cart";
        }
        ra.addFlashAttribute("notify_orders", "Chưa có sản phẩm trong giỏ hàng");
        ra.addFlashAttribute("check", 0);
        return "redirect:/cart";
    }

    //Hàm xóa một sản phẩm trong giỏ hàng
    @GetMapping("/deleteProductInCart/{id}")
    public String deleteProductInCart(@PathVariable(name = "id") Integer id){
        this.cartLineService.delete(id);
        return "redirect:/cart";
    }

    //Hàm cập nhập số lượng trong giỏ hàng
    @PostMapping("/updateCart/{id}")
    public String updateCart(@PathVariable(name = "id") Integer id, @RequestParam(name = "quantity") Integer quantity){
        CartLine cartLine = this.cartLineService.getById(id);
        cartLine.setQuantity(quantity);
        cartLine.setTotal(cartLine.getQuantity() * cartLine.getPrice());
        this.cartLineService.saveCartLine(cartLine);
        return "redirect:/cart";
    }

    //Hàm Đăng xuất tài khoản
    @GetMapping("/logout")
    public String logout(HttpSession session){
        if(session.getAttribute("account") != null) session.removeAttribute("account");
        if(session.getAttribute("discount") != null) session.removeAttribute("discount");
        return "redirect:/index";
    }

    //Hàm hủy đơn hàng
    @GetMapping("/deleteOrders/{id}")
    public String deleteOrders(@PathVariable(name = "id") Integer id, RedirectAttributes ra){
        Orders orders = this.orderService.getById(id);
        if(orders.getStatus().equalsIgnoreCase("Đã phê duyệt") || orders.getStatus().equalsIgnoreCase("Đang chờ phê duyệt")){
            this.orderService.delete(id);
        }
        return "redirect:/information";
    }

    //Hàm xử lí giảm giá
    @PostMapping("/discount")
    public String discount(@RequestParam(name = "discount") String discount, HttpSession session){
        if(discount.equalsIgnoreCase("SpringBoot2023")){
            session.setAttribute("discount", 50);
        }
        return "redirect:/cart";
    }

    //Hàm xử lí gửi contact
    @PostMapping("/sentContact")
    public String sentContact(Contact contact, RedirectAttributes ra){
        this.contactService.saveContact(contact);
        ra.addFlashAttribute("notify_contact", "Gửi thành công");
        return "redirect:/contact";
    }

    //Hàm hiển thị chi tiết đơn đặt hàng
    @GetMapping("/ordersDetail/{id}")
    public String ordersDetail(HttpSession session, Model model, @PathVariable(name = "id") Integer id){
        String username = (String) session.getAttribute("account");
        User user = this.userService.getByUsername(username);
        model.addAttribute("username", user.getUsername());

        Orders orders = this.orderService.getById(id);
        model.addAttribute("ordersLineList", orders.getOrdersLineList());
        model.addAttribute("orders", orders);

        return "order_detail";
    }
}