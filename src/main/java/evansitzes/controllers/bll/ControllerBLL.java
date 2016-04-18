package evansitzes.controllers.bll;

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
        entity.setCategory(request.getCategory());
        entity.setActive(true);

        return repository.save(entity);
    }

    public WordEntity getRandom(final Integer level, final String category) {
        List<WordEntity> list = list(level, category);
        Random randomizer = new Random();
        return list.get(randomizer.nextInt(list.size()));
    }

    public Object deactivate(final WordEntity entity, final String authToken) {
        assertAuthTokenIsValid(authToken);
        entity.setActive(false);
        return repository.save(entity);
    }

    public List<WordEntity> list(final Integer level, final String category) {
        if (category != null && level != null) {
            return  repository.findByLevelAndCategory(level, category);
        } else if (category != null) {
            return repository.findByCategory(category);
        } else if (level != null) {
            return repository.findByLevel(level);
        }
        return repository.findAllActive();
    }

    public List<String> getCategories(Integer level) {
        if (level != null) {
            return repository.findCategoriesByLevel(level);
        }

        return repository.findCategories();
    }
}
