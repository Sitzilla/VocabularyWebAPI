package evansitzes.models.repositories;

import evansitzes.models.entities.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by evan on 4/7/16.
 */
public interface WordRepository<entity extends WordEntity> extends JpaRepository<entity, Long> {

    @Query("select e from #{#entityName} e where e.active = true")
    List<entity> findAllActive();
}
