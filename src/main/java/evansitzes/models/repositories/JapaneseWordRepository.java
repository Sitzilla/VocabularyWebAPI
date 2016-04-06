package evansitzes.models.repositories;

import evansitzes.models.entities.JapaneseWordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by evan on 4/6/16.
 */
@Transactional
public interface JapaneseWordRepository extends JpaRepository<JapaneseWordEntity, Long> {

    @Query("select j from JapaneseWordEntity j where j.active = true")
    List<JapaneseWordEntity> findAllActive();

}
