package com.example.demo.ENTITY;
import javax.persistence.*;
@Entity
@Table(name = "OrdersLine")
public class OrdersLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(targetEntity = Orders.class)
    @JoinColumn(name = "orders", nullable = false)
    private Orders orders;
    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product", nullable = true)
    private String product;

    @Column(length = 25, nullable = false)
    private String nameProduct;

    private Integer quantity;

    private Integer price;

    @Column(length = 50, nullable = true)
    private String note;

    private Integer total;

    public OrdersLine() {
    }

    public OrdersLine(Integer id, Orders orders, String product, String nameProduct, Integer quantity, Integer price, String note, Integer total) {
        this.id = id;
        this.orders = orders;
        this.product = product;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
