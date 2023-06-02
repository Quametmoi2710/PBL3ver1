package com.example.demo.ENTITY;
import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user")
    private User user;
    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = OrdersLine.class)
    List<OrdersLine> ordersLineList;
    private String orderAddress;
    private String orderPhonenumber;
    private Date orderDate;
    private Date shipDate;
    private String status;
    private Integer total;
    public Orders() {
    }

    public Orders(Integer id, User user, String orderAddress, String orderPhonenumber, Date orderDate, Date shipDate, String status, List<OrdersLine> ordersLineList, Integer total) {
        this.id = id;
        this.user = user;
        this.orderAddress = orderAddress;
        this.orderPhonenumber = orderPhonenumber;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.status = status;
        this.ordersLineList = ordersLineList;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderPhonenumber() {
        return orderPhonenumber;
    }

    public void setOrderPhonenumber(String orderPhonenumber) {
        this.orderPhonenumber = orderPhonenumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrdersLine> getOrdersLineList() {
        return ordersLineList;
    }

    public void setOrdersLineList(List<OrdersLine> ordersLineList) {
        this.ordersLineList = ordersLineList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void addOrdersLine(OrdersLine ordersLine){
        if(this.ordersLineList == null) this.ordersLineList = new ArrayList<OrdersLine>();
        this.ordersLineList.add(ordersLine);
    }
}
