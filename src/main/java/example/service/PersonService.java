package example.service;

import example.models.Book;
import example.models.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> index();

    Person show(int id);

    void save(Person person);

    void update(int id, Person updatedPerson);

    void delete(int id);

    List<Book> getBooksByPersonId(int id);

    Optional<Person> getPersonByName(String name);
}
