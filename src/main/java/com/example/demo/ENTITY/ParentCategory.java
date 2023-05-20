package com.example.demo.ENTITY;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "ParentCategory")
public class ParentCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;
    @OneToMany(mappedBy = "parentCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductCategory> categoryList;
    public ParentCategory() {
    }
    public ParentCategory(Integer id, String name, List<ProductCategory> categories) {
        this.id = id;
        this.name = name;
        this.categoryList = categories;
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

    public List<ProductCategory> getCategories() {
        return categoryList;
    }

    public void setCategories(List<ProductCategory> categories) {
        this.categoryList = categories;
    }
}
