package backend2026.musiikkikokoelma;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import backend2026.musiikkikokoelma.domain.Artist;
import backend2026.musiikkikokoelma.domain.ArtistRepository;
import backend2026.musiikkikokoelma.domain.Song;
import backend2026.musiikkikokoelma.domain.SongRepository;

@DataJpaTest
@ActiveProfiles("test")
public class SongRepositoryTest {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Test
    public void findByTitleShouldReturnSong() {
        List<Song> songs = songRepository.findByTitle("Song X");
        assertThat(songs).hasSize(1);
        assertThat(songs.get(0).getReleaseYear()).isEqualTo(1995);
    }

    @Test
    public void findByReleaseYearShouldReturnSong() {
        List<Song> songs = songRepository.findByReleaseYear(1992);
        assertThat(songs).hasSize(1);
        assertThat(songs.get(0).getTitle()).isEqualTo("Fear of the Dark");
    }

    @Test
    public void findByOrderByNameShouldReturnAscendingTitleSong() {
        List<Song> songs = songRepository.findByOrderByTitle();
        assertThat(songs).hasSize(6);
        assertThat(songs.get(0).getTitle()).isEqualTo("Fear of the Dark");
    }

    @Test
    public void createNewSongTest() {
        List<Artist> artists = artistRepository.findByOrderByName();
        Artist artist = artists.get(0);
        Song song = new Song("Wasted Years", artist, 1986, null, null, null);
        songRepository.save(song);
        assertThat(song.getSongId()).isNotNull();
    }

    @Test
    public void deleteSongTest() {
        List<Song> songs = songRepository.findByTitle("Song X");
        Song song = songs.get(0);
        songRepository.delete(song);
        List<Song> newSongs = songRepository.findByTitle("Song X");
        assertThat(newSongs).hasSize(0);
    }

}
