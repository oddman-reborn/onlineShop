
package com.shop.model;

import com.shop.entity.Admin;
import com.shop.entity.Product;
import com.shop.entity.login;
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
}
