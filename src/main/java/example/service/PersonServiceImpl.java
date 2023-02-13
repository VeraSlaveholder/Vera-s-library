package example.service;

import example.dao.PersonDAO;
import example.models.Book;
import example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDAO personDAO;

    public List<Person> allPeople() {
        List<Person> personList = personDAO.allPeople();
        return personList;
    }

    @Override
    public Person show(int id) {
        Person person = personDAO.show(id);
        return person;
    }

    @Override
    public void save(Person person) {
        personDAO.save(person);
    }

    @Override
    public void update(int id, Person updatedPerson) {
        personDAO.update(id, updatedPerson);
    }

    @Override
    public void delete(int id) {
        personDAO.delete(id);
    }

    @Override
    public List<Book> getBooksByPersonId(int id) {
        List<Book> bookList = personDAO.getBooksByPersonId(id);
        return bookList;
    }

    @Override
    public Optional<Person> getPersonByName(String name) {
        Optional<Person> personOptional = personDAO.getPersonByName(name);
        return personOptional;
    }
}
