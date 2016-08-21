/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.DBUser;
import org.hibernate.Session;

/**
 *
 * @author grze
 */
public class HibernateController {
    
    private static String message = "";

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String msg) {
        message = msg;
    }
    
    //validate
    public boolean dbValidate(String login, String passwd) {

        List<DBUser> users;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            users = session
                    .createQuery("from DBUser u where u.login='" + login + "'")
                    .list();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
        
        if (!users.isEmpty() && validateDBuser(login, passwd, users)) {
            return true;
        } else {
            setMessage("No user or wrong password.");
            return false;
        }
        
    }
    
    private boolean validateDBuser(String login, String passwd, List<DBUser> users) {
    
        return users.stream().anyMatch((u) -> (u.getLogin().equals(login) && u.getPassword().equals(passwd)));
    }
    

    /**
     * Fill users table in admins panel from DB source
     *
     * @return
     */
    public static ObservableList<DBUser> fillTableView() {

        List<DBUser> users = null;
        ObservableList<DBUser> data = FXCollections.observableArrayList();

        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            users = session
                    .createQuery("from DBUser")
                    .list();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.getStackTrace();
        }

        //TODO: dereferencing possible null pointer
        for (DBUser u : users) {
            data.add(u);
        }

        return data;

    }

    /**
     * Add new user to Users table in admin panel
     *
     * @param user
     */
    public static void addNewUser(DBUser user) {

        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    public static boolean deleteUser(DBUser tmpUser) {

        try {
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.createQuery("delete from DBUser where login='"+tmpUser.getLogin()
                    +"' AND priviledge="+tmpUser.getPriviledge())
                    .executeUpdate();
            session.getTransaction().commit();
            
            return true;
            
        } catch (Exception e) {
            return false;
        }        

    }

}
