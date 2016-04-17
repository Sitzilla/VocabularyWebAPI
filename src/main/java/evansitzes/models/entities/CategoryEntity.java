package evansitzes.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by evan on 4/17/16.
 */
@Entity
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @Column(name="id")
    private long id;

    @Column(name="category")
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}