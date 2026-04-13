package backend2026.musiikkikokoelma;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import backend2026.musiikkikokoelma.domain.Artist;
import backend2026.musiikkikokoelma.domain.ArtistRepository;

@DataJpaTest
@ActiveProfiles("test")
public class ArtistRepositoryTest {

    @Autowired
    private ArtistRepository artistRepository;

    @Test
    public void findByNameShouldReturnArtist() {
        List<Artist> artists = artistRepository.findByName("Iron Maiden");
        assertThat(artists).hasSize(1);
        assertThat(artists.get(0).getFoundingYear()).isEqualTo(1975);
    }

    @Test
    public void findByFoundingYearShouldReturnArtist() {
        List<Artist> artists = artistRepository.findByFoundingYear(1968);
        assertThat(artists).hasSize(1);
        assertThat(artists.get(0).getName()).isEqualTo("Neil Young");
    }

    @Test
    public void findByOrderByNameShouldReturnAscendingNameAlbum() {
        List<Artist> artists = artistRepository.findByOrderByName();
        assertThat(artists).hasSize(3);
        assertThat(artists.get(2).getFoundingYear()).isEqualTo(1990);
    }

    @Test
    public void createNewArtistTest() {
        Artist artist = new Artist("FLOW", 2003, null, null);
        artistRepository.save(artist);
        assertThat(artist.getArtistId()).isNotNull();
    }

    @Test
    public void deleteArtistTest() {
        List<Artist> artists = artistRepository.findByName("Pearl Jam");
        Artist artist = artists.get(0);
        artistRepository.delete(artist);
        List<Artist> newArtists = artistRepository.findByName("Pearl Jam");
        assertThat(newArtists).hasSize(0);
    }

}
