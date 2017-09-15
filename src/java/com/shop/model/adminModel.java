
package com.shop.model;

import com.shop.entity.Admin;
import com.shop.entity.login;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class adminModel {
    
    public boolean Login(login info)
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
}
