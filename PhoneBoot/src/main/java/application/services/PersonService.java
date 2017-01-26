package application.services;

import application.entities.Person;

import java.util.List;

/**
 * PhoneBoot
 * Created by Grzegorz Kossowski on 22.01.17.
 */
public interface PersonService {

    Person getPersonById(int id);

    List<Person> getAllPersons();

    void saveOrUpdatePerson(Person person);

    void deletePersonById(int id);

    List<Person> getPersonsFromQuery(String firstName, String lastName);

}
