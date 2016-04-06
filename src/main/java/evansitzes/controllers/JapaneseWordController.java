package evansitzes.controllers;

import evansitzes.models.entities.JapaneseWordEntity;
import evansitzes.models.repositories.JapaneseWordRepository;
import evansitzes.requests.WordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;

/**
 * Created by evan on 4/6/16.
 */
@Controller
@RequestMapping("/japanese")
public class JapaneseWordController {

    @Autowired
    private JapaneseWordRepository japaneseWordRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<JapaneseWordEntity> listAll() {
        return japaneseWordRepository.findAllActive();
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    @ResponseBody
    public JapaneseWordEntity getRandom() {
        List<JapaneseWordEntity> list = japaneseWordRepository.findAllActive();
        Random randomizer = new Random();
        return list.get(randomizer.nextInt(list.size()));
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public JapaneseWordEntity create(@RequestBody final WordRequest request) {
        JapaneseWordEntity entity = new JapaneseWordEntity();
        entity.setForeignWord(request.getForeignWord());
        entity.setEnglishWord(request.getEnglishWord());
        entity.setActive(true);

        return japaneseWordRepository.save(entity);
    }

}
