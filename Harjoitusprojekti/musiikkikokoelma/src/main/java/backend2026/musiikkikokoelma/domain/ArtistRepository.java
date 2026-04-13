package backend2026.musiikkikokoelma.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, Long> {

    List<Artist> findByName(String name);

    List<Artist> findByFoundingYear(int foundingYear);

    List<Artist> findByOrderByName();

}
