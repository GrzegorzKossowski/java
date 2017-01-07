package jdbc;

import beans.Person;
import beans.User;
import java.util.List;

/**
 *
 * @author grze
 */
public class JdbcTest {

    public static void main(String[] args) {

        JdbcUtil.JdbcConnecitonTest();

        User user = new User("mickey", "mouse123");
        System.out.println(JdbcUtil.isUserValid(user));
        
        List<Person> persons = JdbcUtil.getPersons("SELECT * FROM person");
        for (Person person : persons) {
            System.out.println(person.toString());
        }
        
        persons = JdbcUtil.getPersons("SELECT * FROM person WHERE firstname='Cecylia'");
        for (Person person : persons) {
            System.out.println(person.toString());
        }
        
//        JdbcUtil.deletePerson("7");
    
        Person person = new Person(1, "Graza", "Srodstopa", "654564", "6542", "lkfjsd@kdjfls.dd");
        JdbcUtil.updatePerson(person);
        
    }

}