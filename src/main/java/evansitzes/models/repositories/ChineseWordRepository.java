package evansitzes.models.repositories;

import evansitzes.models.entities.ChineseWordEntity;
import evansitzes.models.entities.JapaneseWordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by evan on 4/6/16.
 */
@Transactional
public interface ChineseWordRepository extends JpaRepository<ChineseWordEntity, Long> {

    @Query("select c from ChineseWordEntity c where c.active = true")
    List<ChineseWordEntity> findAllActive();

}