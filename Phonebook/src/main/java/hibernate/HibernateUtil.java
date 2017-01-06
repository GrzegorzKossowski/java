package hibernate;

import beans.Person;
import beans.User;
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
        }

        return sessionFactory;
        
    }

    public static boolean isUserValid(User user) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<User> users = null;

        try {
            
            session.beginTransaction();
            users = session.createQuery("FROM User WHERE login='" + user.getLogin() + "'").list();
            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
        } finally {
            factory.close();
        }

        return !(users.isEmpty() || users == null);

    }

}