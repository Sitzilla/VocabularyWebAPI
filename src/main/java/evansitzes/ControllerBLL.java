package evansitzes;

import evansitzes.models.entities.WordEntity;
import evansitzes.models.repositories.WordRepository;
import evansitzes.requests.WordRequest;

import java.util.List;
import java.util.Random;

import static evansitzes.helpers.ValidateAuthToken.assertAuthTokenIsValid;

/**
 * Created by evan on 4/7/16.
 */
public class ControllerBLL {

    private final WordRepository repository;

    public ControllerBLL(final WordRepository repository) {
        this.repository = repository;
    }

    public Object buildEntity(final WordEntity entity, final WordRequest request, final String authToken) {
        assertAuthTokenIsValid(authToken);

        entity.setForeignWord(request.getForeignWord());
        entity.setEnglishWord(request.getEnglishWord());
        entity.setLevel(request.getLevel());
        entity.setActive(true);

        return repository.save(entity);
    }

    public WordEntity getRandom(final List entities) {
        List<WordEntity> list = entities;
        Random randomizer = new Random();
        return list.get(randomizer.nextInt(list.size()));
    }

    public Object deactivate(final WordEntity entity, final String authToken) {
        assertAuthTokenIsValid(authToken);
        entity.setActive(false);
        return repository.save(entity);
    }
}
