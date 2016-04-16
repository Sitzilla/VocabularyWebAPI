package evansitzes;

import evansitzes.models.entities.WordEntity;

import java.util.List;

/**
 * Created by evan on 4/16/16.
 */
public class WordResponse {
    private int size;
    private final List<WordEntity> words;

    public WordResponse(List<WordEntity> words) {
        this.words = words;
        size = words.size();
    }

    public int getSize() {
        return size;
    }

    public List<WordEntity> getWords() {
        return words;
    }
}
