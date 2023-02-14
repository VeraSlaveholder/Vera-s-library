package example.controllers;

import example.models.Book;
import example.models.Person;
import example.service.BookService;
import example.service.BookServiceImpl;
import example.service.PersonService;
import example.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BooksController {
    private final PersonService personService=new PersonServiceImpl();
    private final BookService bookService=new BookServiceImpl();


    @GetMapping()
    public String allBooks(Model model) {
        model.addAttribute("books", bookService.allBooks());
        return "books/allBooks";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.show(id));

        Optional<Person> bookOwner = bookService.getBookOwner(id);
        if (bookOwner.isPresent()) {
            model.addAttribute("owner", bookOwner.get());
        } else {
            model.addAttribute("people", personService.allPeople());
        }
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "books/new";
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", bookService.show(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "books/edit";
        bookService.update(id, book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookService.delete(id);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/releasePersonFromBook")
    public String releasePersonFromBook(@PathVariable("id") int id) {
        bookService.releasePersonFromBook(id);
        return "redirect:/books/" + id;
    }

    @PatchMapping("/{id}/assignBookToPerson")
    public String assignBookToPerson(@PathVariable("id") int id, @ModelAttribute("person") Person person) {
        bookService.assignBookToPerson(id, person);
        return "redirect:/books/" + id;
    }
}