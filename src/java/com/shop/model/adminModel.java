
package com.shop.model;

import com.shop.entity.Admin;
import com.shop.entity.CreditCard;
import com.shop.entity.OrderList;
import com.shop.entity.Product;
import com.shop.entity.UserBalance;
import com.shop.entity.login;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class adminModel {
    
    public boolean adminLogin(login info)
    {
        boolean login=false;
        
        String username=info.getEmail();
        String password=info.getPassword();
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        
        try{
            session.beginTransaction();
            String hql="from Admin where username=? and password=?";
            Query q=session.createQuery(hql);
            q.setString(0, username);
            q.setString(1, password);
            session.getTransaction().commit();
            
            List <Admin> user=q.list();
            
            if(user.size() == 1)
            {
                login=true;
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
     return login; 
    }
    
    public Admin getInfo(login info)
    {
        Admin admin_info=new Admin();
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            
            String username=info.getEmail();
            String password=info.getPassword();
            
            String hql="from Admin where username=? and password=?";
            Query q=session.createQuery(hql);
            
            q.setString(0, username);
            q.setString(1, password);
            
            session.getTransaction();
            
            admin_info=(Admin) q.uniqueResult();
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
        }
        session.close();
        return admin_info;
    }
    
    public void insertProduct(Product product)
    {
        Session session =HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
        catch(Exception e){
            session.getTransaction().rollback();
        }
        
        session.close();
    }
    
    public List getAllProduct()
    {
        List<Product> list=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        
        try{
            session.beginTransaction();
            Criteria criteria=session.createCriteria(Product.class);
            
            list =(List<Product>) criteria.list();
            session.getTransaction().commit();
        }
        catch(Exception e){
            session.getTransaction().rollback();
        }
        session.close();
        return list;
    }
    
    public Product getProductDetailById(int id)
    {
        Product productDetail=new Product();
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            productDetail=(Product)session.get(Product.class,id );
            session.getTransaction();
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
        }
        session.close();
        return productDetail;
    }
    
    public void updateProduct(Product product)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
        }
        session.close();
    }
    
    public List getProductById(int id)
    {
        List<Product> productList=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        
        try{
            session.beginTransaction();
            String hql="from Product where id=?";
            Query q=session.createQuery(hql);
            q.setInteger(0, id);
            session.getTransaction();
            productList=q.list();
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
        }
        session.close();
        return  productList;
    }
    
    public List getProductByCategory(String category)
    {
        List<Product> productList=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        
        try{
            session.beginTransaction();
            String hql="from Product where category=?";
            Query q=session.createQuery(hql);
            q.setString(0,category);
            session.getTransaction();
            productList=q.list();
            
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
        }
        session.close();
        return productList;
    }
    
    public List getProductByBrand(String brand)
    {
        List<Product> productList=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            String hql="from Product where brand=?";
            Query q=session.createQuery(hql);
            
            q.setString(0, brand);
            session.getTransaction();
            
            productList=q.list();
        }
        catch(Exception e){
            session.getTransaction().rollback();
        }
        session.close();
        return productList;
    }
    
    public List sortProduct(int value)
    {
        List<Product> productList=null;
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.beginTransaction();
            
            if(value==1)
            {
                Criteria criteria=session.createCriteria(Product.class);
                
                criteria=criteria.addOrder(Order.asc("unitAvailable"));
                session.getTransaction();
                
                productList=criteria.list();
            }
            
            else{
                Criteria criteria=session.createCriteria(Product.class);
                
                criteria=criteria.addOrder(Order.desc("unitAvailable"));
                session.getTransaction();
                
                productList=criteria.list();
            }
            
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
        }
        session.close();
        return productList;
    }
    
    public void insertAdmin(Admin admin)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.beginTransaction();
            session.save(admin);
            session.getTransaction().commit();
            
        }
        catch(Exception e){
            session.getTransaction().rollback();
        }
        session.close();
    }
    
    public List getAdminList()
    {
        List<Admin> adminList=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        
        try{
            session.beginTransaction();
            
            Criteria criteria=session.createCriteria(Admin.class);
            session.getTransaction();
            adminList=criteria.list();
        }
        catch(Exception e){
            session.getTransaction().rollback();
        }
        session.close();
        return adminList;
    }
    
    public void insertCreditCard(CreditCard card)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(card);
            session.getTransaction().commit();
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
        }
        session.close();
    }
    
    public List<OrderList> getOrderList()
    {
        List<OrderList> oList=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Criteria criteria=session.createCriteria(OrderList.class);
            oList=criteria.list();
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
        }
        session.close();
        return oList;
    }
    
    public void orderAccept(int oid)
    {
       
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            OrderList order=(OrderList) session.load(OrderList.class,oid);
            order.setStatus(1);
            session.update(order);
            
            session.getTransaction().commit();
            
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
        }
        session.close();
        
    }
    
    public OrderList orderReject(int oid)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        OrderList order=new OrderList();
        try{
            session.beginTransaction();
            order=(OrderList) session.load(OrderList.class, oid);
            session.delete(order);
            session.getTransaction().commit();
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
            order=null;
        }
        session.close();
        return order;
    }
    
    public void userRefund(OrderList order)
    {
        UserBalance ubalance=new UserBalance();
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            int pid=order.getProductId();
            int uid=order.getUserId();
            int price=order.getPrice();

            String productId=pid+"(Refund)";
            ubalance.setProductId(productId);
            ubalance.setUserId(uid);
            ubalance.setCredit(price);
            ubalance.setDebit(0);
            Date d = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String date = dateFormat.format(d);
            ubalance.setDate(date);
            session.save(ubalance);
            session.getTransaction().commit();
            
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
            ubalance=null;
        }
        session.close();
    }
    
    public OrderList getOrderInfo(int oid)
    {
        OrderList order=new OrderList();
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            order=(OrderList) session.get(OrderList.class, oid);
            session.getTransaction();
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
            order=null;
        }
        session.close();
        return order;
    }
    
    public List<OrderList> getPendingOrderList()
    {
        List<OrderList> orderList=new ArrayList();
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            String hql="from OrderList where status='0'";
            Query query=session.createQuery(hql);
            session.getTransaction();
            orderList=query.list();
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
        }
        return orderList;
    }
    
    public List<OrderList> getAcceptedOrderList()
    {
        List<OrderList> orderList=new ArrayList();
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            String hql="from OrderList where status='1'";
            Query query=session.createQuery(hql);
            session.getTransaction();
            orderList=query.list();
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
        }
        return orderList;
    }
    
    public List<OrderList> getDeliveredOrderList()
    {
        List<OrderList> orderList=new ArrayList();
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            String hql="from OrderList where status='2'";
            Query query=session.createQuery(hql);
            session.getTransaction();
            orderList=query.list();
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
        }
        return orderList;
    }
}
