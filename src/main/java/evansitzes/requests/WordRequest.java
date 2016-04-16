package evansitzes.requests;

/**
 * Created by evan on 4/6/16.
 */
public class WordRequest {

    private String foreignWord;
    private String englishWord;
    private int level;
    private String category;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "WordRequest{" +
                "foreignWord='" + foreignWord + '\'' +
                ", englishWord='" + englishWord + '\'' +
                ", level=" + level +
                ", category='" + category + '\'' +
                '}';
    }
}
