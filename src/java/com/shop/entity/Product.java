package com.shop.entity;
// Generated Oct 15, 2017 6:54:40 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name="product"
    ,catalog="shop"
)
public class Product  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String category;
     private int price;
     private int unitAvailable;
     private String imagePath;
     private String detail;
     private String brand;

    public Product() {
    }

    public Product(String name, String category, int price, int unitAvailable, String imagePath, String detail, String brand) {
       this.name = name;
       this.category = category;
       this.price = price;
       this.unitAvailable = unitAvailable;
       this.imagePath = imagePath;
       this.detail = detail;
       this.brand = brand;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false, length=100)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="category", nullable=false, length=100)
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

    
    @Column(name="price", nullable=false)
    public int getPrice() {
        return this.price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }

    
    @Column(name="unit_available", nullable=false)
    public int getUnitAvailable() {
        return this.unitAvailable;
    }
    
    public void setUnitAvailable(int unitAvailable) {
        this.unitAvailable = unitAvailable;
    }

    
    @Column(name="image_path", nullable=false, length=100)
    public String getImagePath() {
        return this.imagePath;
    }
    
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    
    @Column(name="detail", nullable=false, length=500)
    public String getDetail() {
        return this.detail;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }

    
    @Column(name="brand", nullable=false, length=100)
    public String getBrand() {
        return this.brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }




}


