/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.model;

import com.shop.entity.Product;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Md. Monirul Islam
 */
public class productModel {

 public List<Product> getAllProduct()
 {
     List<Product> productList=null;
     Session session=HibernateUtil.getSessionFactory().openSession();
     try{
         session.beginTransaction();
         Criteria criteria=session.createCriteria(Product.class);
         session.getTransaction();
         productList=criteria.list();
     }
     catch(Exception e)
     {
         session.getTransaction().rollback();
     }
     session.close();
     return productList;
 }
 
 public Product getProductById(int pid)
 {
     Product product=new Product();
     Session session=HibernateUtil.getSessionFactory().openSession();
     try{
         session.beginTransaction();
         product=(Product)session.get(Product.class,pid);
         session.getTransaction();
     }
     catch(Exception e)
     {
         session.getTransaction().rollback();
     }
     session.close();
     return product;
 }
}
