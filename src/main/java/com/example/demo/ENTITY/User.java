package com.example.demo.ENTITY;
import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phonenumber;
    private Date birthday;
    private String address;
    private Boolean status;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Orders.class)
    private List<Orders> ordersList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = CartLine.class)
    private List<CartLine> cartLineList;
    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role")
    private Role role;

    public User() {
        this.cartLineList = new ArrayList<CartLine>();
        this.ordersList = new ArrayList<Orders>();
        this.status = true;
    }

    public User(Integer id, String username, String password, String email, String phonenumber, Date birthday, String address, Boolean status, List<Orders> ordersList, List<CartLine> cartLineList, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phonenumber = phonenumber;
        this.birthday = birthday;
        this.address = address;
        this.status = status;
        this.ordersList = ordersList;
        this.cartLineList = cartLineList;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
       this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public List<CartLine> getCartLineList() {
        return cartLineList;
    }

    public void setCartLineList(List<CartLine> cartLineList) {
        this.cartLineList = cartLineList;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void addCartLine(CartLine cartLine){
        if(this.cartLineList == null) this.cartLineList = new ArrayList<CartLine>();
        this.cartLineList.add(cartLine);
    }

    public void addOrders(Orders orders){
        if(this.ordersList == null) this.ordersList = new ArrayList<Orders>();
        this.ordersList.add(orders);
    }

    public void clearAllCartLineList(){
        if(this.cartLineList != null) this.cartLineList.clear();
    }
}
