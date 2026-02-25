package backendharjoitusprojekti.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backendharjoitusprojekti.bookstore.domain.Book;
import backendharjoitusprojekti.bookstore.domain.BookRepository;

@RestController
public class BookRestController {

    private BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<Book> bookListRest() {
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId);
    }

    @PostMapping("/books")
    public Book saveNewBookRest(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/books/{id}")
    public Book saveEditBookRest(@RequestBody Book editedBook, @PathVariable("id") Long bookId) {
        editedBook.setId(bookId);
        return bookRepository.save(editedBook);
    }

    @DeleteMapping("/books/{id}")
    public Iterable<Book> deleteBookRest(@RequestBody Book book, @PathVariable("id") Long bookId) {
        bookRepository.deleteById(bookId);
        return bookRepository.findAll();
    }

}
