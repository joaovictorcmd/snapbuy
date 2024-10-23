package com.joaovictorcmd.snapbuy.snapbuy.entities;

import com.joaovictorcmd.snapbuy.snapbuy.entities.associations.OrderItem;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author joaovictorcmd
 * @date 2024 Oct 23
 */
@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double price;
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String name, String description, Double price, String imgUrl, Category category, Set<OrderItem> items) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.category = category;
        this.items = items;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Order> getOrders() {
        return items.stream().map(OrderItem::getOrder).toList();
    }
}
