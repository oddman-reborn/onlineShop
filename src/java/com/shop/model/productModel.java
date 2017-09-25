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

    public List getCategory() {
        List category = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            String hql="select val.category from Product val";
            Query query=session.createQuery(hql);
            session.getTransaction();
            category=query.list();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        session.close();
        return category;
    }

}
