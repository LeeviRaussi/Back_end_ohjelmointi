package backend2026.musiikkikokoelma;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import backend2026.musiikkikokoelma.domain.Genre;
import backend2026.musiikkikokoelma.domain.GenreRepository;

@DataJpaTest
@ActiveProfiles("test")
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;
    
    @Test
    public void findByNameShouldReturnGenre() {
        List<Genre> genres = genreRepository.findByName("Folk");
        assertThat(genres).hasSize(1);
        assertThat(genres.get(0).getGenreId()).isEqualTo(2);
    }

    @Test
    public void findByOrderByNameShouldReturnAscendingNameGenre() {
        List<Genre> genres = genreRepository.findByOrderByName();
        assertThat(genres).hasSize(3);
        assertThat(genres.get(0).getName()).isEqualTo("Folk");
    }

    @Test
    public void createNewGenreTest() {
        Genre genre = new Genre("Country");
        genreRepository.save(genre);
        assertThat(genre.getGenreId()).isNotNull();
    }

    @Test
    public void deleteGenreTest() {
        List<Genre> genres = genreRepository.findByName("Folk");
        Genre genre = genres.get(0);
        genreRepository.delete(genre);
        List<Genre> newGenres = genreRepository.findByName("Folk");
        assertThat(newGenres).hasSize(0);
    }

}
