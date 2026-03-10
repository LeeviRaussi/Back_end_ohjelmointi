package backendharjoitusprojekti.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
//import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import backendharjoitusprojekti.bookstore.domain.Book;
import backendharjoitusprojekti.bookstore.domain.BookRepository;
import backendharjoitusprojekti.bookstore.domain.Category;
import backendharjoitusprojekti.bookstore.domain.CategoryRepository;

//@SpringBootTest(classes = BookstoreApplication.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@ActiveProfiles("test")
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = bookRepository.findByTitle("A Farewell to Arms");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Ernest Hemingway");
    }

    @Test
    public void createNewBook() {
        List<Category> categories = categoryRepository.findByName("Comedy");
        Category category = categories.get(0);
        Book book = new Book("Testausta", "Testaaja", 2026, "123456-7", "13,37", category);
        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook() {
        List<Book> books = bookRepository.findByTitle("A Farewell to Arms");
        Book book = books.get(0);
        bookRepository.delete(book);
        List<Book> newBooks = bookRepository.findByTitle("A Farewell to Arms");
        assertThat(newBooks).hasSize(0);
    }

}
