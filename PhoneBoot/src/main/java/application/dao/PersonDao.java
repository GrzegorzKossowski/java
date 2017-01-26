package application.dao;

import application.entities.Person;

import java.util.List;

/**
 * PhoneBoot
 * Created by Grzegorz Kossowski on 22.01.17.
 */
public interface PersonDao {

    Person getPersonById(int id);

    Person getPerson(String firstName, String lastName);

    List<Person> getAllPersons();

    void saveOrUpdatePerson(Person person);

    void deletePersonById(int id);

    List<Person> getPersonsFromQuery(String firstName, String lastName);
}
