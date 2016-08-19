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

        for (DBUser u : users) {
            data.add(u);
        }

        return data;

    }

    public static void addNewUser(DBUser user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
