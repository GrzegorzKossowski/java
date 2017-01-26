package application.controllers;

import application.entities.Person;
import application.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PhoneBoot
 * Created by Grzegorz Kossowski on 22.01.17.
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    //CRUD - CREATE

    @RequestMapping(value = {"/form", "/form/{}"}, method = RequestMethod.GET)
    public String failUriForm(Model model) {
        model.addAttribute(new Person());
        model.addAttribute("formTitle", "Add person");
        return "form";
    }

    @PostMapping(value = "/form")
    public String processForm(@ModelAttribute("person") Person person,
                              Model model) {
        personService.saveOrUpdatePerson(person);
        List<Person> persons = null;
        persons = personService.getAllPersons();
        model.addAttribute("persons", persons);
        return "list";
    }

    //CRUD - READ

    /**
     * Shows list of all persons
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<Person> persons = null;
        persons = personService.getAllPersons();
        model.addAttribute("persons", persons);
        return "list";

    }

    @RequestMapping(value = {"/find"}, method = RequestMethod.GET)
    public String showFindPersonForm(Model model) {
        model.addAttribute(new Person());
        return "findForm";
    }

    @RequestMapping(value = {"/find"}, method = RequestMethod.POST)
    public String processFindPersonForm(@ModelAttribute("firstName") String firstName,
                                        @ModelAttribute("lastName") String lastName,
                                        Model model) {
        model.addAttribute("persons", personService.getPersonsFromQuery(firstName, lastName));
        return "list";
    }

    //CRUD - UPDATE

    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String fillForm(@PathVariable("id") int id, Model model) {

        Person person = personService.getPersonById(id);
        if (person != null) {
            model.addAttribute(person);
            model.addAttribute("formTitle", "Edit person");
        } else {
            model.addAttribute(new Person());
            model.addAttribute("formTitle", "Add person");
        }
        return "form";
    }

    //CRUD - DELETE

    @GetMapping("/delete/{id}")
    public String deleteByID(@PathVariable("id") int id, Model model) {
        personService.deletePersonById(id);
        List<Person> persons = null;
        persons = personService.getAllPersons();
        model.addAttribute("persons", persons);
        return "list";
    }

}