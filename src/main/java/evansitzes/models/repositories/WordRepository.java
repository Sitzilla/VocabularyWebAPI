package evansitzes.models.repositories;

import evansitzes.models.entities.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by evan on 4/7/16.
 */
public interface WordRepository<entity extends WordEntity> extends JpaRepository<entity, Long> {

    @Query("select e from #{#entityName} e where e.active = true")
    List<entity> findAllActive();

    @Query("select e from #{#entityName} e where e.level = (:level) and e.active = true")
    List<entity> findByLevel(@Param("level") int level);

    @Query("select e from #{#entityName} e where e.category = (:category) and e.active = true")
    List<entity> findByCategory(@Param("category") String category);

    @Query("select e from #{#entityName} e where e.level = (:level) and e.category = (:category) and e.active = true")
    List<entity> findByLevelAndCategory(@Param("level") int level, @Param("category") String category);

    @Query("select e.category from #{#entityName} e where e.active = true group by e.category")
    List<String> findCategories();

    @Query("select e.category from #{#entityName} e where e.active = true and e.level = (:level) group by e.category")
    List<String> findCategoriesByLevel(@Param("level") int level);
}
