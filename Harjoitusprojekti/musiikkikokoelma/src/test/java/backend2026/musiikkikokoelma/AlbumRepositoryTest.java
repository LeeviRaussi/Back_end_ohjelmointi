package backend2026.musiikkikokoelma;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import backend2026.musiikkikokoelma.domain.Album;
import backend2026.musiikkikokoelma.domain.AlbumRepository;
import backend2026.musiikkikokoelma.domain.Artist;
import backend2026.musiikkikokoelma.domain.ArtistRepository;

@DataJpaTest
@ActiveProfiles("test")
public class AlbumRepositoryTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Test
    public void findByTitleShouldReturnAlbum() {
        List<Album> albums = albumRepository.findByTitle("Brave New World");
        assertThat(albums).hasSize(1);
        assertThat(albums.get(0).getReleaseYear()).isEqualTo(2000);
    }

    @Test
    public void findByOrderByTitleShouldReturnAscendingTitleAlbum() {
        List<Album> albums = albumRepository.findByOrderByTitle();
        assertThat(albums).hasSize(4);
        assertThat(albums.get(3).getTitle()).isEqualTo("Harvest");
    }

    @Test
    public void createNewAlbumTest() {
        List<Artist> artists = artistRepository.findByName("Iron Maiden");
        Artist artist = artists.get(0);
        Album album = new Album("Dance of Death", 2003, artist, null);
        albumRepository.save(album);
        assertThat(album.getAlbumId()).isNotNull();
    }

    @Test
    public void deleteAlbumTest() {
        List<Album> albums = albumRepository.findByTitle("Freedom");
        Album album = albums.get(0);
        albumRepository.delete(album);
        List<Album> newAlbums = albumRepository.findByTitle("Freedom");
        assertThat(newAlbums).hasSize(0);
    }

}
