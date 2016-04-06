package evansitzes.models.entities;

import javax.persistence.*;

/**
 * Created by evan on 4/6/16.
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Table(name = "words")
public class WordEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="foreign_word")
    private String foreignWord;

    @Column (name="english_word")
    private String englishWord;

    @Column (name="active")
    private boolean active;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getForeignWord() {
        return foreignWord;
    }

    public void setForeignWord(String foreignWord) {
        this.foreignWord = foreignWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
