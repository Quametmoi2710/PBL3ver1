package com.example.demo.ENTITY;
import javax.persistence.*;
@Entity
@Table(name = "CartLine")
public class CartLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product")
    private Product product;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user")
    private User user;
    private String name_product;
    private Integer quantity;
    private Integer price;
    private Integer total;

    public CartLine() {
    }

    public CartLine(Integer id, Product product, User user, String name_product, Integer quantity, Integer price, Integer total) {
        this.id = id;
        this.product = product;
        this.user = user;
        this.name_product = name_product;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if(id > 0) this.id = id;
        else System.out.println("Exception: id < 0 so can not setId !");
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        if(product != null)  this.product = product;
        else System.out.println("Exception: product is null so can not setProduct !");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        if(user != null) this.user = user;
        else System.out.println("Exception: user is null so can not setUser !");
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        if(quantity > 0) this.quantity = quantity;
        else System.out.println("Exception: quantity < 0 so can not setQuantity !");
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        if(price > 0) this.price = price;
        else System.out.println("Exception: price < 0 so can not setPrice !");
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        if(total > 0) this.total = total;
        else System.out.println("Exception: total < 0 so can not setTotal !");
    }

    @Override
    public String toString() {
        return "CartLine{" +
                "id=" + id +
                ", product=" + product +
                ", user=" + user +
                ", name_product='" + name_product + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}
