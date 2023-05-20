package com.example.demo.ENTITY;
import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product", nullable = false)
    private Product product;
    private Integer quantity;
    private Integer price;
    private Integer total;
    private Boolean status;
    private Date createDate;
    private Date updateDate;
    public Cart() {
    }
    public Cart(Integer id, User user, Product product, Integer quantity, Integer price, Integer total, Boolean status, Date createDate, Date updateDate) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
