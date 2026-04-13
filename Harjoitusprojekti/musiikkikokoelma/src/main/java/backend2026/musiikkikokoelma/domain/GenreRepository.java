package backend2026.musiikkikokoelma.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Long> {

    List<Genre> findByName(String name);

    List<Genre> findByOrderByName();

}
