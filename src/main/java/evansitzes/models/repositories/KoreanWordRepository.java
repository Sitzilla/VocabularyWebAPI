package evansitzes.models.repositories;

import evansitzes.models.entities.KoreanWordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by evan on 4/6/16.
 */

@Transactional
public interface KoreanWordRepository extends JpaRepository<KoreanWordEntity, Long> {

    @Query("select k from KoreanWordEntity k where k.active = true")
    List<KoreanWordEntity> findAllActive();

}
