package com.example.demo.ENTITY;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "ParentCategory")
public class ParentCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "parentCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = ProductCategory.class)
    private List<ProductCategory> productCategoryList;

    public ParentCategory() {
    }

    public ParentCategory(Integer id, String name, List<ProductCategory> productCategoryList) {
        this.id = id;
        this.name = name;
        this.productCategoryList = productCategoryList;
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

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }
}
