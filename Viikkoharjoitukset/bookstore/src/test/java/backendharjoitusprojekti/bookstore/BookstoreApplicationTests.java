package backendharjoitusprojekti.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import backendharjoitusprojekti.bookstore.web.BookController;
import backendharjoitusprojekti.bookstore.web.BookRestController;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;

	@Autowired
	private BookRestController bookRestController;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void bookControllerLoad() throws Exception {
		assertThat(bookController).isNotNull();
	}

	@Test
	public void bookRestControllerLoad() throws Exception {
		assertThat(bookRestController).isNotNull();
	}

}
