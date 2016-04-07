package evansitzes.controllers;

import evansitzes.ControllerBLL;
import evansitzes.models.entities.JapaneseWordEntity;
import evansitzes.models.entities.WordEntity;
import evansitzes.models.repositories.JapaneseWordRepository;
import evansitzes.requests.WordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by evan on 4/6/16.
 */
@Controller
@RequestMapping("/japanese")
public class JapaneseWordController {

    @Autowired
    private JapaneseWordRepository japaneseWordRepository;

    private ControllerBLL controllerBLL;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<JapaneseWordEntity> listAll() {
        return japaneseWordRepository.findAllActive();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JapaneseWordEntity getWord(@PathVariable(value="id") final long id) {
        return japaneseWordRepository.findOne(id);
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    @ResponseBody
    public WordEntity getRandom() {
        controllerBLL = new ControllerBLL(japaneseWordRepository);
        return controllerBLL.getRandom(japaneseWordRepository.findAllActive());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Object create(@RequestBody final WordRequest request, @RequestHeader(value="Authorization") String authToken) {
        controllerBLL = new ControllerBLL(japaneseWordRepository);
        return controllerBLL.buildEntity(new JapaneseWordEntity(), request, authToken);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Object update(@PathVariable(value="id") final long id, @RequestBody final WordRequest request, @RequestHeader(value="Authorization") final String authToken) {
        controllerBLL = new ControllerBLL(japaneseWordRepository);
        return controllerBLL.buildEntity(japaneseWordRepository.findOne(id), request, authToken);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deactivate(@PathVariable(value="id") final long id, @RequestHeader(value="Authorization") final String authToken) {
        controllerBLL = new ControllerBLL(japaneseWordRepository);
        return controllerBLL.deactivate(japaneseWordRepository.findOne(id), authToken);
    }

}
