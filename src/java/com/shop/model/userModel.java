/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.model;

import com.shop.entity.CreditCard;
import com.shop.entity.Recharge;
import com.shop.entity.User;
import com.shop.entity.UserBalance;
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
    
    public User getInfo(login info)
    {
        User user_info=new User();
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        
        try{
            String email=info.getEmail();
            String password=info.getPassword();
            
            session.beginTransaction();
            String hql="from User where email=? and password=?";
            
            Query q=session.createQuery(hql);
            q.setString(0, email);
            q.setString(1, password);
            session.getTransaction();
            
            user_info=(User) q.uniqueResult();
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
        }
        session.close();
        return user_info;
    }
    
    public boolean checkCreditCard(Recharge rechargeCard)
    {
        boolean valid=false;
        Session session=HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.beginTransaction();
            String hql="from CreditCard where code=? and pin=?";
            String code=rechargeCard.getCode();
            String pin=rechargeCard.getPin();
            Query query=session.createQuery(hql);
            query.setString(0, code);
            query.setString(1, pin);
            session.getTransaction();
            List<CreditCard> creditCard=query.list();
            
            if(creditCard.size()==1)
            {
                if(creditCard.get(0).getStatus()==0)
                    valid=true;
            }
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
        }
        session.close();
        return valid;
    }
    
    public int getCreditCardBalance(Recharge card)
    {
        int balance=0;
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            String code=card.getCode();
            String pin=card.getPin();
            
            String hql="from CreditCard where code=? and pin=?";
            Query query=session.createQuery(hql);
            query.setString(0, code);
            query.setString(1, pin);
            session.getTransaction();
            CreditCard tempCard=(CreditCard) query.uniqueResult();
            balance=Integer.parseInt(tempCard.getBalance());
            
            tempCard.setStatus(1);
            session.update(tempCard);
            session.getTransaction().commit();
            
        }
        catch (Exception e)
        {
            session.close();
        }
        session.close();
        return balance;
    }
    
    public void insertUserBalance(UserBalance addBalance)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(addBalance);
            session.getTransaction().commit();
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
        }
        session.close();
    }
    
    public void invalidateCreditCard(String code,String pin)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.beginTransaction();
            String hql="from CreditCard where code=? and pin=?";
            Query query=session.createQuery(hql);
            query.setString(0, code);
            query.setString(1, pin);
            session.getTransaction();
        }
        catch(Exception e)
        {
            
        }
    }
}
