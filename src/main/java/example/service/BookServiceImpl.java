package example.service;

import example.dao.BookDAO;
import example.models.Book;
import example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> index() {
        List<Book> bookList = bookDAO.index();
        return bookList;
    }

    @Override
    public Book show(int id) {
        Book book = bookDAO.show(id);
        return book;
    }

    @Override
    public void save(Book book) {
        bookDAO.save(book);
    }

    @Override
    public void update(int id, Book updatedBook) {
        bookDAO.update(id, updatedBook);
    }

    @Override
    public void delete(int id) {
        bookDAO.delete(id);
    }

    @Override
    public void release(int id) {
        bookDAO.release(id);
    }

    @Override
    public void assign(int id, Person selectedPerson) {
        bookDAO.assign(id, selectedPerson);
    }

    @Override
    public Optional<Person> getBookOwner(int id) {
        Optional<Person> bookOwner = bookDAO.getBookOwner(id);
        return bookOwner;
    }
}
