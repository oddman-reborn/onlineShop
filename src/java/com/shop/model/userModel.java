/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.model;

import com.shop.entity.User;
import com.shop.entity.login;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Monirul Islam
 */
public class userModel {
    
    public boolean checkEmail(String email)
    {
        boolean access=false;
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            String hql="from User where email=?";
            Query q=session.createQuery(hql);
            q.setString(0, email);
            session.getTransaction().commit();
            List<User> list=q.list();
            
            if(list.isEmpty())
            {
                access=true;
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return access;
    }
    
    public void insertUser(User user)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } 
        catch(Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
    }
    
    public boolean userLogin(login info)
    {
        boolean login=false;
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            String email=info.getEmail();
            String password=info.getPassword();
            session.beginTransaction();
            String hql="from User where email=? and password=?";
            Query q=session.createQuery(hql);
            q.setString(0, email);
            q.setString(1, password);
            
            session.getTransaction().commit();
            
            List <User> member=(List<User>)q.list();
            
            if(member.size() == 1)
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
}
