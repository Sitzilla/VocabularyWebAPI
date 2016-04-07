package evansitzes.controllers;

import evansitzes.ControllerBLL;
import evansitzes.models.entities.KoreanWordEntity;
import evansitzes.models.entities.WordEntity;
import evansitzes.models.repositories.KoreanWordRepository;
import evansitzes.requests.WordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by evan on 4/6/16.
 */
@Controller
@RequestMapping("/korean")
public class KoreanWordController {

    @Autowired
    private KoreanWordRepository koreanWordRepository;

    private ControllerBLL controllerBLL;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<KoreanWordEntity> listAll() {
        return koreanWordRepository.findAllActive();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public KoreanWordEntity getWord(@PathVariable(value="id") final long id) {
        return koreanWordRepository.findOne(id);
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    @ResponseBody
    public WordEntity getRandom() {
        controllerBLL = new ControllerBLL(koreanWordRepository);
        return controllerBLL.getRandom(koreanWordRepository.findAllActive());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Object create(@RequestBody final WordRequest request, @RequestHeader(value="Authorization") String authToken) {
        controllerBLL = new ControllerBLL(koreanWordRepository);
        return controllerBLL.buildEntity(new KoreanWordEntity(), request, authToken);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Object update(@PathVariable(value="id") final long id, @RequestBody final WordRequest request, @RequestHeader(value="Authorization") final String authToken) {
        controllerBLL = new ControllerBLL(koreanWordRepository);
        return controllerBLL.buildEntity(koreanWordRepository.findOne(id), request, authToken);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deactivate(@PathVariable(value="id") final long id, @RequestHeader(value="Authorization") final String authToken) {
        controllerBLL = new ControllerBLL(koreanWordRepository);
        return controllerBLL.deactivate(koreanWordRepository.findOne(id), authToken);
    }

}
