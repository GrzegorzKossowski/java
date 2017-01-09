package hibernate;

import beans.Person;
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

//        User user;
//        user = new User("mickey", "mouse123");
//        System.out.println(HibernateUtil.isUserValid(user));
//        Person person = new Person("Baba", "Jaga", "48 22 7982564", "48 987654321", "baba@jaga.com");
//        HibernateUtil.savePerson(person);       
//            Person person = HibernateUtil.getPerson("1");
//            System.out.println(person.toString());

        String sql = "from Person ORDER BY lastname";
        for (Person p : HibernateUtil.getPersons(sql)) {
            System.out.println(p);
        }

HibernateUtil.closeSessionFactory();

    }

}
