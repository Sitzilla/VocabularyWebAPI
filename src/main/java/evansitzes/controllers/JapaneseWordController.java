package evansitzes.controllers;

import evansitzes.WordResponse;
import evansitzes.models.entities.JapaneseWordEntity;
import evansitzes.models.entities.WordEntity;
import evansitzes.models.repositories.JapaneseWordRepository;
import evansitzes.requests.WordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by evan on 4/6/16.
 */
@Controller
@RequestMapping("/japanese")
public class JapaneseWordController {

    @Autowired
    private JapaneseWordRepository japaneseWordRepository;
    @Autowired
    private FilterRegistrationBean myFilter;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public WordResponse listAll(@RequestParam(value="level", required = false) final Integer level,
                                @RequestParam(value="category", required = false) final String category) {
        return new WordResponse(new ControllerBLL(japaneseWordRepository).list(level, category));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JapaneseWordEntity getWord(@PathVariable(value="id") final long id) {
        return japaneseWordRepository.findOne(id);
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    @ResponseBody
    public WordEntity getRandom(@RequestParam(value="level", required = false) final Integer level,
                                @RequestParam(value="category", required = false) final String category) {
        return new ControllerBLL(japaneseWordRepository).getRandom(level, category);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Object create(@RequestBody final WordRequest request, @RequestHeader(value="Authorization") String authToken) {
        return new ControllerBLL(japaneseWordRepository).buildEntity(new JapaneseWordEntity(), request, authToken);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Object update(@PathVariable(value="id") final long id,
                         @RequestBody final WordRequest request,
                         @RequestHeader(value="Authorization") final String authToken) {
        return new ControllerBLL(japaneseWordRepository).buildEntity(japaneseWordRepository.findOne(id), request, authToken);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deactivate(@PathVariable(value="id") final long id, @RequestHeader(value="Authorization") final String authToken) {
        return new ControllerBLL(japaneseWordRepository).deactivate(japaneseWordRepository.findOne(id), authToken);
    }

}
