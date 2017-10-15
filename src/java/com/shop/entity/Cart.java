package com.shop.entity;
// Generated Oct 15, 2017 6:54:40 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cart generated by hbm2java
 */
@Entity
@Table(name="cart"
    ,catalog="shop"
)
public class Cart  implements java.io.Serializable {


     private Integer id;
     private int userId;
     private int productId;
     private int price;
     private int quantity;
     private int orderStatus;

    public Cart() {
    }

    public Cart(int userId, int productId, int price, int quantity, int orderStatus) {
       this.userId = userId;
       this.productId = productId;
       this.price = price;
       this.quantity = quantity;
       this.orderStatus = orderStatus;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="user_id", nullable=false)
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }

    
    @Column(name="product_id", nullable=false)
    public int getProductId() {
        return this.productId;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }

    
    @Column(name="price", nullable=false)
    public int getPrice() {
        return this.price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }

    
    @Column(name="quantity", nullable=false)
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    @Column(name="order_status", nullable=false)
    public int getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }




}


