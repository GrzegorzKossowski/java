package hibernate;

import beans.User;

/**
 *
 * @author grze
 */
public class HibernateTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        User user;
        user = new User("mickey", "mouse123");
        System.out.println(HibernateUtil.isUserValid(user));

    }

}
