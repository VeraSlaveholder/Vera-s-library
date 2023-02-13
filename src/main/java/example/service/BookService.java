package example.service;

import example.models.Book;
import example.models.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> allBooks();

    public Book show(int id);

    public void save(Book book);

    public void update(int id, Book updatedBook);

    public void delete(int id);

    public void releasePersonFromBook(int id);

    public void assignBookToPerson(int id, Person selectedPerson);

    public Optional<Person> getBookOwner(int id);
}
