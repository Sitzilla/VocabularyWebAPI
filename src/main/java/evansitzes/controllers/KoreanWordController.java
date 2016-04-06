package evansitzes.controllers;

import evansitzes.WordRequest;
import evansitzes.models.entities.KoreanWordEntity;
import evansitzes.models.KoreanWordRepository;
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
@RequestMapping("/korean")
public class KoreanWordController {

    @Autowired
    private KoreanWordRepository koreanWordRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<KoreanWordEntity> listAll() {
        return koreanWordRepository.findAllActive();
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    @ResponseBody
    public KoreanWordEntity getRandom() {
        List<KoreanWordEntity> list = koreanWordRepository.findAllActive();
        Random randomizer = new Random();
        return list.get(randomizer.nextInt(list.size()));
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public KoreanWordEntity create(@RequestBody final WordRequest request) {
        KoreanWordEntity entity = new KoreanWordEntity();
        entity.setForeignWord(request.getForeignWord());
        entity.setEnglishWord(request.getEnglishWord());
        entity.setActive(true);

        return koreanWordRepository.save(entity);
    }

}
