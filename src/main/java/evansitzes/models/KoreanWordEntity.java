package evansitzes.models;

import javax.persistence.*;

/**
 * Created by evan on 4/6/16.
 */
@Entity
@Table(name = "korean_words")
public class KoreanWordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name="korean_word")
    private String koreanWord;

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

    public String getKoreanWord() {
        return koreanWord;
    }

    public void setKoreanWord(String koreanWord) {
        this.koreanWord = koreanWord;
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
