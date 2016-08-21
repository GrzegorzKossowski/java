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
    private Integer priviledge;
    @Column(name = "description")
    private String description;

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

    public DBUser(String login, Integer priviledge, String description) {
        this.login = login;
        this.priviledge = priviledge;
        this.description = description;
    }

    public DBUser(String login, String password, Integer priviledge, String description) {
        this.login = login;
        this.password = password;
        this.priviledge = priviledge;
        this.description = description;
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

    //getters setters

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

    public Integer getPriviledge() {
        return priviledge;
    }

    public void setPriviledge(Integer priviledge) {
        this.priviledge = priviledge;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    

    @Override
    public String toString() {
        return "User{"+ idUser + ", " + login + ", " + password + ", " + priviledge + ", " + description + "}";
    }

}
