package backendharjoitusprojekti.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
//import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import backendharjoitusprojekti.bookstore.domain.AppUser;
import backendharjoitusprojekti.bookstore.domain.AppUserRepository;

//@SpringBootTest(classes = BookstoreApplication.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@ActiveProfiles("test")
public class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository appUserRepository;

    @Test
    public void findByUsernameShouldReturnUsername() {
        AppUser appUser = appUserRepository.findByUsername("user");
        assertThat(appUser.getRole()).isEqualTo("USER");
    }

    @Test
    public void createNewAppUser() {
        AppUser appUser = new AppUser("testaaja", "$2a$10$HwmCgK6WsO5xHQtjqp1GV.nNKVQGxJAhIIZuovR1iCd4a.cdzm2N2", "USER");
        appUserRepository.save(appUser);
        assertThat(appUser.getId()).isNotNull();
    }

    @Test
    public void deleteAppUser() {
        AppUser appUser = appUserRepository.findByUsername("user");
        appUserRepository.delete(appUser);
        AppUser newAppUser = appUserRepository.findByUsername("user");
        assertThat(newAppUser).isNull();
    }

}
