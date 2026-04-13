package backend2026.musiikkikokoelma.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {

    List<Album> findByTitle(String title);

    // Lähde: https://www.baeldung.com/spring-data-sorting
    List<Album> findByOrderByTitle();

}
