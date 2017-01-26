package application.services;

import application.dao.PersonDao;
import application.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PhoneBoot
 * Created by Grzegorz Kossowski on 22.01.17.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public Person getPersonById(int id) {
        return this.personDao.getPersonById(id);
    }

    @Override
    public List<Person> getAllPersons() {
        return this.personDao.getAllPersons();
    }

    @Override
    public void saveOrUpdatePerson(Person person) {
        this.personDao.saveOrUpdatePerson(person);
    }

    @Override
    public void deletePersonById(int id) {
        this.personDao.deletePersonById(id);
    }

    @Override
    public List<Person> getPersonsFromQuery(String firstName, String lastName) {

        return personDao.getPersonsFromQuery(firstName, lastName);
    }
}
