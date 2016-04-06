package evansitzes.controllers;

import evansitzes.models.entities.ChineseWordEntity;
import evansitzes.models.repositories.ChineseWordRepository;
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
@RequestMapping("/chinese")
public class ChineseWordController {

    @Autowired
    private ChineseWordRepository chineseWordRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<ChineseWordEntity> listAll() {
        return chineseWordRepository.findAllActive();
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    @ResponseBody
    public ChineseWordEntity getRandom() {
        List<ChineseWordEntity> list = chineseWordRepository.findAllActive();
        Random randomizer = new Random();
        return list.get(randomizer.nextInt(list.size()));
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ChineseWordEntity create(@RequestBody final WordRequest request) {
        ChineseWordEntity entity = new ChineseWordEntity();
        entity.setForeignWord(request.getForeignWord());
        entity.setEnglishWord(request.getEnglishWord());
        entity.setActive(true);

        return chineseWordRepository.save(entity);
    }

}
