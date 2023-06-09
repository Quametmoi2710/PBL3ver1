package com.example.demo.ENTITY;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String name;
    private Integer totalQuantity;
    private Integer soldQuantity;
    private Integer remainQuantity;
    private Integer price;
    private String description;
    private Date productDate;
    private Date expirationDate;
    private Date createDate;
    private Date updateDate;
    @ManyToOne(targetEntity = ProductCategory.class)
    @JoinColumn(name = "productCategory")
    private ProductCategory productCategory;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = OrdersLine.class)
    List<OrdersLine> ordersLineList;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = CartLine.class)
    List<CartLine> cartLineList;
    public Product() {
    }
    public Product(Integer id, String name, Integer totalQuantity, Integer soldQuantity, Integer remainQuantity, Integer price, String description, Date productDate, Date expirationDate, Date createDate, Date updateDate, ProductCategory productCategory, List<OrdersLine> ordersLineList, List<CartLine> cartLineList) {
        this.id = id;
        this.name = name;
        this.totalQuantity = totalQuantity;
        this.soldQuantity = soldQuantity;
        this.remainQuantity = remainQuantity;
        this.price = price;
        this.description = description;
        this.productDate = productDate;
        this.expirationDate = expirationDate;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.productCategory = productCategory;
        this.ordersLineList = ordersLineList;
        this.cartLineList = cartLineList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Integer getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Integer soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public Integer getRemainQuantity() {
        return remainQuantity;
    }

    public void setRemainQuantity(Integer remainQuantity) {
        this.remainQuantity = remainQuantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
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

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public List<OrdersLine> getOrdersLineList() {
        return ordersLineList;
    }

    public void setOrdersLineList(List<OrdersLine> ordersLineList) {
        this.ordersLineList = ordersLineList;
    }

    public List<CartLine> getCartList() {
        return cartLineList;
    }

    public void setCartList(List<CartLine> cartLineList) {
        this.cartLineList = cartLineList;
    }
}
