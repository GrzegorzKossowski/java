package hibernate;

import beans.Person;
import beans.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author grze
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            Configuration configuration = new Configuration()
                    .configure()
                    .addAnnotatedClass(Person.class)
                    .addAnnotatedClass(User.class);
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            sessionFactory = configuration.buildSessionFactory();
        }

        return sessionFactory;

    }

    public static void closeSessionFactory() {

        if (sessionFactory != null) {
            sessionFactory.close();
        }

        System.out.println("Closing sessionFactory");

    }

    public static boolean isUserValid(User user) {

//        sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = null;

        try {

            session.beginTransaction();
            users = session.createQuery("FROM User WHERE login='" + user.getLogin() + "'").list();
            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return !(users.isEmpty() || users == null);

    }

    public static List<Person> getPersons(String sql) {

        List<Person> persons = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            persons = session.createQuery(sql).getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        
        //code between
        return persons;
    }

    public static Person getPerson(String personId) {

        Session session = null;
        Person person = null;
        int id = Integer.parseInt(personId);

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            person = session.get(Person.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        
        return person;
    }

    public static boolean savePerson(Person person) {

        boolean error = false;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
            error = false;
        } catch (HibernateException e) {
            error = true;
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return error;
    }

    public static void deletePerson(String personId) {

        Session session = null;
        Person person = null;
        int id = Integer.parseInt(personId);
        

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            person = session.get(Person.class, id);
            session.delete(person);
        
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }

        
    }

    public static void updatePerson(Person person) {
        
        Session session = null;
        Person tempPerson = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            tempPerson = session.get(Person.class, person.getId());
            tempPerson.setFirstname(person.getFirstname());
            tempPerson.setLastname(person.getLastname());
            tempPerson.setPhone(person.getPhone());
            tempPerson.setMobile(person.getMobile());
            tempPerson.setEmail(person.getEmail());          

            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }

    }

}
