package evansitzes.models.repositories;

import evansitzes.models.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by evan on 4/17/16.
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity> findAll();

    @Query("select e from CategoryEntity e where e.category = (:category)")
    CategoryEntity findByCategory(@Param("category") String category);
}
