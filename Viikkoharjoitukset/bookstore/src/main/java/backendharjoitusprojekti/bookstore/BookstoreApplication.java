package backendharjoitusprojekti.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backendharjoitusprojekti.bookstore.domain.Book;
import backendharjoitusprojekti.bookstore.domain.BookRepository;
import backendharjoitusprojekti.bookstore.domain.Category;
import backendharjoitusprojekti.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository categoryRepository) {
		return (args) -> {
			log.info("save a couple of categories");

			Category category1 = new Category("Horror");
			Category category2 = new Category("Dystopia");
			Category category3 = new Category("Comedy");

			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);

			log.info("save a couple of books");
			repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", "21,99", category1));
			repository.save(new Book("Animal Farm", "George Orwell", 1945, "2212343-5", "13,29", category2));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			log.info("fetch all books titled Animal Farm");
			for (Book book : repository.findByTitle("Animal Farm")) {
				log.info(book.toString());
			}
		};
	}

}
