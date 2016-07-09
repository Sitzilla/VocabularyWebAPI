package evansitzes.controllers;

import evansitzes.WordResponse;
import evansitzes.controllers.bll.ControllerBLL;
import evansitzes.exceptions.UnprocessableEntityException;
import evansitzes.models.entities.KoreanWordEntity;
import evansitzes.models.entities.WordEntity;
import evansitzes.models.repositories.CategoryRepository;
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
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public WordResponse listAll(@RequestParam(value="level", required = false) final Integer level,
                                    @RequestParam(value="category", required = false) final String category) {
        return new WordResponse(new ControllerBLL(koreanWordRepository).list(level, category));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public KoreanWordEntity getWord(@PathVariable(value="id") final long id) {
        return koreanWordRepository.findOne(id);
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    @ResponseBody
    public WordEntity getRandom(@RequestParam(value="level", required = false) final Integer level,
                                @RequestParam(value="category", required = false) final String category) {
        return new ControllerBLL(koreanWordRepository).getRandom(level, category);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getCategories(@RequestParam(value="level", required = false) final Integer level) {
        return new ControllerBLL(koreanWordRepository).getCategories(level);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Object create(@RequestBody final WordRequest request, @RequestHeader(value="Authorization") String authToken) {
        assertValidRequest(request);
        return new ControllerBLL(koreanWordRepository).buildEntity(new KoreanWordEntity(), request, authToken);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Object update(@PathVariable(value="id") final long id,
                         @RequestBody final WordRequest request,
                         @RequestHeader(value="Authorization") final String authToken) {
        assertValidRequest(request);
        return new ControllerBLL(koreanWordRepository).buildEntity(koreanWordRepository.findOne(id), request, authToken);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deactivate(@PathVariable(value="id") final long id, @RequestHeader(value="Authorization") final String authToken) {
        return new ControllerBLL(koreanWordRepository).deactivate(koreanWordRepository.findOne(id), authToken);
    }

    @RequestMapping(value = "/{id}/increase", method = RequestMethod.PUT)
    @ResponseBody
    public Object update(@PathVariable(value="id") final long id) {
        return new ControllerBLL(koreanWordRepository).increaseKnowledgeCount(koreanWordRepository.findOne(id));
    }

    private void assertValidRequest(final WordRequest request) {
        if (request.getCategory() == null) {
            throw new UnprocessableEntityException("Required parameter \"category\"");
        }

        if (categoryRepository.findByCategory(request.getCategory()) == null) {
            throw new UnprocessableEntityException("Category <" + request.getCategory() + "> does not exists.");
        }
    }

}
