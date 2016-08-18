/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.DBUser;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author grze
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
       
        try {
            sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(DBUser.class)
                .buildSessionFactory();
            
            
        } catch (Throwable ex) {            
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
