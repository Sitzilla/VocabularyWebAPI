package evansitzes.controllers;

import evansitzes.models.entities.WordEntity;
import evansitzes.models.repositories.JapaneseWordRepository;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by evan on 4/16/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class TestControllerBLL {

    private static final Logger LOGGER = Logger.getLogger(TestControllerBLL.class);
    private static final String SHINBUN = "shinbun";

    @Mock
    private JapaneseWordRepository japaneseWordRepository;

    @Test
    public void returnAllJapaneseWords() {
        final ControllerBLL controllerBLL = new ControllerBLL(japaneseWordRepository);

        final List<WordEntity> entities1 = controllerBLL.list(null, null);
        assertTrue(entities1.size() > 0);
        LOGGER.info("Total of " + entities1.size() + " Japanese words found");

        final List<WordEntity> entities2 = controllerBLL.list(2, SHINBUN);
        assertTrue(entities2.size() > 0 && entities2.size() < entities1.size());
        LOGGER.info("Total of " + entities2.size() + " filtered Japanese words found");

        final List<WordEntity> entities3 = controllerBLL.list(1, null);
        assertTrue(entities3.size() > 0 && entities3.size() < entities1.size());
        LOGGER.info("Total of " + entities3.size() + " filtered Japanese words found");

        final List<WordEntity> entities4 = controllerBLL.list(null, SHINBUN);
        assertTrue(entities4.size() > 0 && entities4.size() < entities1.size());
        LOGGER.info("Total of " + entities4.size() + " filtered Japanese words found");

        final WordEntity entity = controllerBLL.getRandom(2, SHINBUN);
        assertTrue(entity.isActive());
        assertTrue(entity.getCategory().equals("shinbun"));
        assertTrue(entity.getLevel() == 2);
        LOGGER.info("Found random word: " + entity);

    }

}
