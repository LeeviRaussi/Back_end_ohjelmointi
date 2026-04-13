package backend2026.musiikkikokoelma;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import backend2026.musiikkikokoelma.domain.AppUser;
import backend2026.musiikkikokoelma.domain.AppUserRepository;

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
    public void createNewAppUserTest() {
        AppUser appUser = new AppUser("testaaja", "$2a$10$HwmCgK6WsO5xHQtjqp1GV.nNKVQGxJAhIIZuovR1iCd4a.cdzm2N2", "USER");
        appUserRepository.save(appUser);
        assertThat(appUser.getUserId()).isNotNull();
    }

    @Test
    public void deleteAppUserTest() {
        AppUser appUser = appUserRepository.findByUsername("user");
        appUserRepository.delete(appUser);
        AppUser newAppUser = appUserRepository.findByUsername("user");
        assertThat(newAppUser).isNull();
    }

}
