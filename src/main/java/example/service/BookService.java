package example.service;

import example.models.Book;
import example.models.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> index();

    public Book show(int id);

    public void save(Book book);

    public void update(int id, Book updatedBook);

    public void delete(int id);

    public void release(int id);

    public void assign(int id, Person selectedPerson);

    public Optional<Person> getBookOwner(int id);
}
