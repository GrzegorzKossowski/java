package application.dao;

import application.entities.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * PhoneBoot
 * Created by Grzegorz Kossowski on 22.01.17.
 */
@Repository
public class FakePersonDaoImpl implements PersonDao {

    private static List<Person> persons;
    private static int dbIndex;

    static {

        persons = new ArrayList<Person>() {
            {
                add(new Person(1, "John", "Doe", "48 22 895 17 53", "48 799 753 753"));
                add(new Person(2, "Mary", "Doe", "49 58 456 65 87", "49 852 456 159"));
                add(new Person(3, "Chewbawca", "de Wookee", "48 22 895 17 53", "48 799 753 753"));
                add(new Person(4, "Kaczka", "Dziwaczka", "48 22 895 17 53", "48 799 753 753"));
                add(new Person(5, "Bolek", "Lolek", "48 22 895 17 53", "48 799 753 753"));
            }
        };
        dbIndex = 5;
    }


    @Override
    public Person getPersonById(int id) {

        for(Person person : persons) {
            if(person.getId() == id)
                return person;
        }

        return null;
    }

    @Override
    public Person getPerson(String firstName, String lastName) {

        for(Person p : persons) {
            if(p.getFirstName().equals(firstName) || p.getLastName().equals(lastName)) {
                return p;
            }
        }

        return null;
    }

    @Override
    public List<Person> getAllPersons() {
        return this.persons;
    }

    @Override
    public void saveOrUpdatePerson(Person person) {

        boolean isUpdate = false;
        int getPos = 0;

        for(Person p : persons) {
            if(p.getId() == person.getId()) {
                isUpdate = true;
                break;
            }
            getPos++;
        }

        if(isUpdate) {
            persons.get(getPos).setFirstName(person.getFirstName());
            persons.get(getPos).setLastName(person.getLastName());
            persons.get(getPos).setPhone(person.getPhone());
            persons.get(getPos).setMobile(person.getMobile());
        } else {
            person.setId(getDbIndex());
            persons.add(person);
        }

    }

    @Override
    public void deletePersonById(int id) {
        int pos = 0;
        for(Person p : persons) {
            if(p.getId() == id) {
                persons.remove(pos);
                break;
            }
            pos++;
        }
    }

    @Override
    public List<Person> getPersonsFromQuery(String firstName, String lastName) {

        List<Person> tempPersons = new ArrayList<Person>();

        for(Person p : persons) {
            if(p.getFirstName().equals(firstName) || p.getLastName().equals(lastName)) {
                tempPersons.add(p);
            }
        }

        return tempPersons;
    }

    public static int getDbIndex() {
        incrementDbIndex();
        return dbIndex;
    }

    public static void incrementDbIndex() {
        FakePersonDaoImpl.dbIndex++;
    }
}
