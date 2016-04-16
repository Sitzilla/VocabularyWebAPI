package evansitzes.controllers;

import evansitzes.WordResponse;
import evansitzes.models.entities.ChineseWordEntity;
import evansitzes.models.entities.WordEntity;
import evansitzes.models.repositories.ChineseWordRepository;
import evansitzes.requests.WordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by evan on 4/6/16.
 */
@Controller
@RequestMapping("/chinese")
public class ChineseWordController {

    @Autowired
    private ChineseWordRepository chineseWordRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public WordResponse listAll(@RequestParam(value="level", required = false) final Integer level,
                                    @RequestParam(value="category", required = false) final String category) {
        return new WordResponse(new ControllerBLL(chineseWordRepository).list(level, category));
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ChineseWordEntity getWord(@PathVariable(value="id") final long id) {
        return chineseWordRepository.findOne(id);
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    @ResponseBody
    public WordEntity getRandom(@RequestParam(value="level", required = false) final Integer level,
                                @RequestParam(value="category", required = false) final String category) {
        return new ControllerBLL(chineseWordRepository).getRandom(level, category);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Object create(@RequestBody final WordRequest request, @RequestHeader(value="Authorization") String authToken) {
        return new ControllerBLL(chineseWordRepository).buildEntity(new ChineseWordEntity(), request, authToken);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Object update(@PathVariable(value="id") final long id,
                         @RequestBody final WordRequest request,
                         @RequestHeader(value="Authorization") final String authToken) {
        return new ControllerBLL(chineseWordRepository).buildEntity(chineseWordRepository.findOne(id), request, authToken);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deactivate(@PathVariable(value="id") final long id, @RequestHeader(value="Authorization") final String authToken) {
        return new ControllerBLL(chineseWordRepository).deactivate(chineseWordRepository.findOne(id), authToken);
    }

}
