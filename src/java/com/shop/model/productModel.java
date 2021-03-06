
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
 
 public List<Cart> getUserCart(int userId)
 {
     List<Cart> userCart=null;
     Session session=HibernateUtil.getSessionFactory().openSession();
     try{
         session.beginTransaction();
         String hql="from Cart where userId=? and orderStatus=?";
         Query query=session.createQuery(hql);
         query.setInteger(0, userId);
         query.setInteger(1, 0);/*orderStatus=1 means added to orderList */
         session.getTransaction();
         userCart=query.list();
     }
     catch(Exception e)
     {
         session.getTransaction().rollback();
     }
     session.close();
     return userCart;
 }
 
 public int getCartQuantity(int pid,int uid)
 {
     int quantity=0;
     Session session=HibernateUtil.getSessionFactory().openSession();
     try{
         session.beginTransaction();
         String hql="select q.quantity from Cart q where q.productId=? and q.userId=?";
         Query query=session.createQuery(hql);
         query.setInteger(0, pid);
         query.setInteger(1, uid);
         session.getTransaction();
         quantity=(int) query.uniqueResult();
     }
     
     catch(Exception e)
     {
         session.getTransaction().rollback();
     }
     session.close();
     return quantity;
 }
 
 public void deleteCart(int cid)
 {
     Session session=HibernateUtil.getSessionFactory().openSession();
     try{
         session.beginTransaction();
         Cart cart=(Cart) session.load(Cart.class, cid);
         session.delete(cart);
         session.getTransaction().commit();
     }
     catch(Exception e)
     {
         session.getTransaction().rollback();
     }
     session.close();
 }
 
 public void updateCart(int quantity,int cid)
 {
     Session session=HibernateUtil.getSessionFactory().openSession();
     try{
         session.beginTransaction();
         Cart temp=(Cart) session.load(Cart.class, cid);
         temp.setQuantity(quantity);
         session.update(temp);
         session.getTransaction().commit();
     }
     catch(Exception e)
     {
         session.getTransaction().rollback();
     }
     session.close();
 }
 
 public void cartToOrder(int cid)
 {
     Session session=HibernateUtil.getSessionFactory().openSession();
     try{
         session.beginTransaction();
         Cart temp=(Cart)session.load(Cart.class, cid);
         temp.setOrderStatus(1);
         session.update(temp);
         session.getTransaction().commit();
     }
     catch(Exception e)
     {
         session.getTransaction().rollback();
     }
     session.close();
 }
 
 public List<Cart> getOrderedList(int uid)
 {
     List<Cart> plist=null;
     Session session=HibernateUtil.getSessionFactory().openSession();
     try{
         session.beginTransaction();
         String hql="from Cart where userId=? and orderStatus=?";
         Query query=session.createQuery(hql);
         query.setInteger(0, uid);
         query.setInteger(1,1);
         session.getTransaction();
         plist=query.list();
     }
     catch(Exception e)
     {
         session.getTransaction().rollback();
     }
     session.close();
     return plist;
 }
 
 public void orderToCart(int cid)
 {
     Session session=HibernateUtil.getSessionFactory().openSession();
     try{
         session.beginTransaction();
         Cart temp=(Cart)session.load(Cart.class, cid);
         temp.setOrderStatus(0);
         session.update(temp);
         session.getTransaction().commit();
     }
     catch(Exception e)
     {
         session.getTransaction().rollback();
     }
     session.close();
 }
}
