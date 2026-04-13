package backend2026.musiikkikokoelma;

/* import java.util.ArrayList;
import java.util.List; */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend2026.musiikkikokoelma.domain.Album;
import backend2026.musiikkikokoelma.domain.AlbumRepository;
import backend2026.musiikkikokoelma.domain.AppUser;
import backend2026.musiikkikokoelma.domain.AppUserRepository;
import backend2026.musiikkikokoelma.domain.Artist;
import backend2026.musiikkikokoelma.domain.ArtistRepository;
import backend2026.musiikkikokoelma.domain.Genre;
import backend2026.musiikkikokoelma.domain.GenreRepository;
import backend2026.musiikkikokoelma.domain.Song;
import backend2026.musiikkikokoelma.domain.SongRepository;

@SpringBootApplication
public class MusiikkikokoelmaApplication {

    private static final Logger log = LoggerFactory.getLogger(MusiikkikokoelmaApplication.class);

    public static void main(String[] args) {
		SpringApplication.run(MusiikkikokoelmaApplication.class, args);
	}

	@Bean
	public CommandLineRunner musiikkikokoelmaHhInitialize(AlbumRepository albumRepository, AppUserRepository appUserRepository, ArtistRepository artistRepository, GenreRepository genreRepository, SongRepository songRepository) {
		return (args) -> {
			Genre genre1 = new Genre("Heavy metal");
			Genre genre2 = new Genre("Folk");
			Genre genre3 = new Genre("Rock");

			Artist artist1 = new Artist("Iron Maiden", 1975, null, null);
			Artist artist2 = new Artist("Neil Young", 1968, null, null);
			Artist artist3 = new Artist("Pearl Jam", 1990, null, null);

			Album album1 = new Album("Brave New World", 2000, artist1, null);
			Album album2 = new Album("Harvest", 1972, artist2, null);
			Album album3 = new Album("Fear of the Dark", 1992, artist1, null);
			Album album4 = new Album("Freedom", 1989, artist2, null);

			Song song1 = new Song("Out of the Silent Planet", artist1, 2000, album1, "6:25", genre1);
			Song song2 = new Song("Heart of Gold", artist2, 1972, album2, "3:08", genre2);
			Song song3 = new Song("Song X", artist2, 1995, null, "4:40", genre3);
			Song song4 = new Song("Fear of the Dark", artist1, 1992, album3,null, genre1);
			Song song5 = new Song("Wickerman", artist1, 2000, album1, "4:05", genre1);
			Song song6 = new Song("Moonchild", artist1, null, null, null, null);

			if (genreRepository.count() == 0) {
				log.info("Lisätään genrejä");
				genreRepository.save(genre1);
				genreRepository.save(genre2);
				genreRepository.save(genre3);
			}

			if (artistRepository.count() == 0) {
				log.info("Lisätään artisteja");
				artistRepository.save(artist1);
				artistRepository.save(artist2);
				artistRepository.save(artist3);
			}

			if (albumRepository.count() == 0) {
				log.info("Lisätään albumeja");
				albumRepository.save(album1);
				albumRepository.save(album2);
				albumRepository.save(album3);
				albumRepository.save(album4);
			}

			if (songRepository.count() == 0) {
				log.info("Lisätään kappaleita");
				songRepository.save(song1);
				songRepository.save(song2);
				songRepository.save(song3);
				songRepository.save(song4);
				songRepository.save(song5);
				songRepository.save(song6);
			}

			if (appUserRepository.count() == 0) {
				log.info("Lisätään käyttäjä/salasana parit");
				AppUser user1 = new AppUser("user", "$2a$10$BJYjlTlBFff2HMI8bxOZj.1UsDYnta6V8cVxLmEutacc8rlzCAzi.", "USER");
				AppUser user2 = new AppUser("admin", "$2a$10$681R2/IWETdQpqSs2AdFM.xAcTlqj2uKZzK8JEPt.uomDejxHGzu2", "ADMIN");
				appUserRepository.save(user1);
				appUserRepository.save(user2);
			}
		};
	}

}
