package com.shop.entity;
// Generated Oct 15, 2017 6:54:40 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserBalance generated by hbm2java
 */
@Entity
@Table(name="user_balance"
    ,catalog="shop"
)
public class UserBalance  implements java.io.Serializable {


     private Integer id;
     private int userId;
     private int credit;
     private int debit;
     private String date;
     private String productId;

    public UserBalance() {
    }

    public UserBalance(int userId, int credit, int debit, String date, String productId) {
       this.userId = userId;
       this.credit = credit;
       this.debit = debit;
       this.date = date;
       this.productId = productId;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="userId", nullable=false)
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }

    
    @Column(name="credit", nullable=false)
    public int getCredit() {
        return this.credit;
    }
    
    public void setCredit(int credit) {
        this.credit = credit;
    }

    
    @Column(name="debit", nullable=false)
    public int getDebit() {
        return this.debit;
    }
    
    public void setDebit(int debit) {
        this.debit = debit;
    }

    
    @Column(name="date", nullable=false, length=20)
    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    
    @Column(name="productId", nullable=false, length=10)
    public String getProductId() {
        return this.productId;
    }
    
    public void setProductId(String productId) {
        this.productId = productId;
    }




}


