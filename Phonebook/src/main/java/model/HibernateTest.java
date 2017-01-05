package model;

import beans.Person;
import beans.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author grze
 */
public class HibernateTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Person.class)
//                .addAnnotatedClass(User.class)
//                .buildSessionFactory();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        List<Person> persons = null;

        try {
            User user;

//add user
            user = new User("login" + Integer.toString((int) (Math.random() * 1000)), "passwd" + Integer.toString((int) (Math.random() * 1000)));
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
            System.out.println("\n" + user.toString() + "\n");

            //edit
            /**
             * session = factory.getCurrentSession();
             * session.beginTransaction(); user = session.get(User.class, 3);
             * user.setPassword("duffy321"); session.getTransaction().commit();
             * session.close(); System.out.println(user.toString()); /*
             */
            //delete
            /**
             * session = factory.getCurrentSession();
             * session.beginTransaction(); user = session.get(User.class, 4);
             * session.delete(user); session.getTransaction().commit();
             * session.close(); /*
             */
            
            session = factory.getCurrentSession();
            session.beginTransaction();

            persons = session.createQuery("FROM Person", Person.class).getResultList();

            session.getTransaction().commit();
            session.close();

            for (Person person : persons) {
                System.out.println(person);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }

    }

}
