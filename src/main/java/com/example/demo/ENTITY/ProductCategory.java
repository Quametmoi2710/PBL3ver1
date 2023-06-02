package com.example.demo.ENTITY;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "ProductCategory")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String name;
    @ManyToOne(targetEntity = ParentCategory.class)
    @JoinColumn(name = "parentCategory")
    private ParentCategory parentCategory;
    @OneToMany(mappedBy = "productCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Product.class)
    List<Product> productList;
    public ProductCategory() {
    }
    public ProductCategory(Integer id, String name, ParentCategory parentCategory, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.parentCategory = parentCategory;
        this.productList = productList;
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

    public ParentCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(ParentCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
