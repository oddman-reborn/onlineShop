
package com.shop.model;

import com.shop.entity.Cart;
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
 
 public List<Product> getProductByCategory(String category)
 {
     List<Product> productList=null;
     Session session=HibernateUtil.getSessionFactory().openSession();
     
     try{
         session.beginTransaction();
         String hql="from Product where category=?";
         Query query=session.createQuery(hql);
         query.setString(0, category);
         session.getTransaction();
         productList=query.list();
     }
     catch(Exception e)
     {
         session.getTransaction().rollback();
     }
     session.close();
     return productList;
 }
 
 public void insertCart(Cart cart)
 {
     Session session=HibernateUtil.getSessionFactory().openSession();
     try{
         session.beginTransaction();
         session.save(cart);
         session.getTransaction().commit();
     }
     catch(Exception e)
     {
         session.getTransaction().rollback();
     }
     session.close();
 }
 
 public List<Product> getCart(int userId)
 {
     List<Product> productList=null;
     Session session=HibernateUtil.getSessionFactory().openSession();
     try{
         session.beginTransaction();
         String hql="from Cart where userId=?";
         Query query=session.createQuery(hql);
         query.setInteger(0, userId);
         
     }
     catch(Exception e)
     {
         session.getTransaction().rollback();
     }
     return productList;
 }
}
