package ru.storemanager.manager.models.category;

import lombok.Builder;
import ru.storemanager.manager.models.product.Product;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Builder
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column(name = "sub_level")
    private Long secondaryPath;

    @Column(name = "level")
    private Long primaryPath;

    @Column(name = "parent_id")
    private Long parentId;

    @OneToMany
    private List<Product> products;

    public Category() {
    }

    public Category(Long id, String name, Long secondaryPath, Long primaryPath, Long parentId, List<Product> products) {
        this.id = id;
        this.name = name;
        this.secondaryPath = secondaryPath;
        this.primaryPath = primaryPath;
        this.parentId = parentId;
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(name, category.name) && Objects.equals(secondaryPath, category.secondaryPath) && Objects.equals(primaryPath, category.primaryPath) && Objects.equals(parentId, category.parentId) && Objects.equals(products, category.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSecondaryPath() {
        return secondaryPath;
    }

    public void setSecondaryPath(Long secondaryPath) {
        this.secondaryPath = secondaryPath;
    }

    public Long getPrimaryPath() {
        return primaryPath;
    }

    public void setPrimaryPath(Long primaryPath) {
        this.primaryPath = primaryPath;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
