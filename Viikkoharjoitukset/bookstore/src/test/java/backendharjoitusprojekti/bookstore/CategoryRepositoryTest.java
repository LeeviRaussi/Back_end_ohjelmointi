package backendharjoitusprojekti.bookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
//import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import backendharjoitusprojekti.bookstore.domain.CategoryRepository;
import backendharjoitusprojekti.bookstore.domain.Category;

//@SpringBootTest(classes = BookstoreApplication.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@ActiveProfiles("test")
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findByNameShouldReturnCategory() {
        List<Category> categories = categoryRepository.findByName("Comedy");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Comedy");
    }

    @Test
    public void createNewCategory() {
        Category category = new Category("Kokoelma");
        categoryRepository.save(category);
        assertThat(category.getCategoryId()).isNotNull();
    }

    @Test
    public void deleteNewCategory() {
        List<Category> categories = categoryRepository.findByName("Comedy");
        Category category = categories.get(0);
        categoryRepository.delete(category);
        List<Category> newCategories = categoryRepository.findByName("Comedy");
        assertThat(newCategories).hasSize(0);
    }

}
