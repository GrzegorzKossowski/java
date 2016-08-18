/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.Session;
import util.HibernateUtil;

@Entity
@Table(name = "DBUser")
public class DBUser implements Serializable {

    @Id
    @Column(name = "idUser")
    private int idUser;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "priviledge")
    private int priviledge;

    @Transient
    private String message;

    public DBUser() {
        this.message = "";
    }

    public DBUser(String login, String password) {
        this.message = "";
        this.login = login;
        this.password = password;
        this.priviledge = 999;
    }

    public DBUser(String login, String password, int priviledge) {
        this.message = "";
        this.login = login;
        this.password = password;
        this.priviledge = priviledge;
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
    
        for(DBUser u : users) {
            
            if (u.getLogin().equals(login) && u.getPassword().equals(passwd)) {
                this.setPriviledge(u.getPriviledge());
                return true;
            }
            
        }
        
        return false;
    }

    public boolean validate(String login, String passwd) {

        return (validateLogin(login) || validatePassword(passwd));

    }

    private boolean validateLogin(String login) {
        //TODO: login valdation
        setMessage(getMessage() + "Login OK. ");
        return true;
    }

    private boolean validatePassword(String passwd) {
        //TODO: passwd validation
        setMessage(getMessage() + "Pass OK. ");
        return true;
    }

    //getters setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPriviledge() {
        return priviledge;
    }

    public void setPriviledge(int priviledge) {
        this.priviledge = priviledge;
    }

    @Override
    public String toString() {
        return "User{" + "login=" + login + ", password=" + password + ", priviledge=" + priviledge + '}';
    }

}
