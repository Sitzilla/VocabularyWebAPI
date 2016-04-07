package evansitzes.controllers;

import evansitzes.ControllerBLL;
import evansitzes.models.entities.ChineseWordEntity;
import evansitzes.models.entities.WordEntity;
import evansitzes.models.repositories.ChineseWordRepository;
import evansitzes.requests.WordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by evan on 4/6/16.
 */
@Controller
@RequestMapping("/chinese")
public class ChineseWordController {


    @Autowired
    private ChineseWordRepository chineseWordRepository;

    private ControllerBLL controllerBLL;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ChineseWordEntity> listAll() {
        return chineseWordRepository.findAllActive();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ChineseWordEntity getWord(@PathVariable(value="id") final long id) {
        return chineseWordRepository.findOne(id);
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    @ResponseBody
    public WordEntity getRandom() {
        controllerBLL = new ControllerBLL(chineseWordRepository);
        return controllerBLL.getRandom(chineseWordRepository.findAllActive());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Object create(@RequestBody final WordRequest request, @RequestHeader(value="Authorization") String authToken) {
        controllerBLL = new ControllerBLL(chineseWordRepository);
        return controllerBLL.buildEntity(new ChineseWordEntity(), request, authToken);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Object update(@PathVariable(value="id") final long id, @RequestBody final WordRequest request, @RequestHeader(value="Authorization") final String authToken) {
        controllerBLL = new ControllerBLL(chineseWordRepository);
        return controllerBLL.buildEntity(chineseWordRepository.findOne(id), request, authToken);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deactivate(@PathVariable(value="id") final long id, @RequestHeader(value="Authorization") final String authToken) {
        controllerBLL = new ControllerBLL(chineseWordRepository);
        return controllerBLL.deactivate(chineseWordRepository.findOne(id), authToken);
    }

}
