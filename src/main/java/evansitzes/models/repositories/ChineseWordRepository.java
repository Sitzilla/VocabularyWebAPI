package evansitzes.models.repositories;

import evansitzes.models.entities.ChineseWordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by evan on 4/6/16.
 */

public interface ChineseWordRepository extends JpaRepository<ChineseWordEntity, Long> {

    @Query("select c from ChineseWordEntity c where c.active = true")
    List<ChineseWordEntity> findAllActive();

}