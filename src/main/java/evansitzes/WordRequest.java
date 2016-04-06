package evansitzes;

/**
 * Created by evan on 4/6/16.
 */
public class WordRequest {

    private String foreignWord;
    private String englishWord;

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

    @Override
    public String toString() {
        return "WordRequest{" +
                "foreignWord='" + foreignWord + '\'' +
                ", englishWord='" + englishWord + '\'' +
                '}';
    }
}
