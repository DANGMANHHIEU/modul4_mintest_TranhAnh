package com.example.tranh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="painting")

public class Painting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namePainting;

    private int height;

    private int width;

    private String material;

    private String description;

    private double price;

     @ManyToMany(fetch = FetchType.LAZY)
     @JoinTable(name = "painting_category",
             joinColumns = @JoinColumn(name = "painting_id"),
             inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categoryList;

    public Painting() {
    }

    public Painting(String namePainting, int height, int width, String material, String description, double price, List<Category> categoryList) {
        this.namePainting = namePainting;
        this.height = height;
        this.width = width;
        this.material = material;
        this.description = description;
        this.price = price;
        this.categoryList = categoryList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePainting() {
        return namePainting;
    }

    public void setNamePainting(String code) {
        this.namePainting = code;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "Painting{" +
                "id=" + id +
                ", code='" + namePainting + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", material='" + material + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", categoryList=" + categoryList +
                '}';
    }

}
