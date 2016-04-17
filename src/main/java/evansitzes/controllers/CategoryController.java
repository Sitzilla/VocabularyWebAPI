package evansitzes.controllers;

import evansitzes.exceptions.UnprocessableEntityException;
import evansitzes.models.entities.CategoryEntity;
import evansitzes.models.repositories.CategoryRepository;
import evansitzes.requests.CategoryRequest;
import evansitzes.requests.WordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static evansitzes.helpers.ValidateAuthToken.assertAuthTokenIsValid;

/**
 * Created by evan on 4/6/16.
 */
@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<CategoryEntity> listAll() {
        return categoryRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Object create(@RequestBody final CategoryRequest request, @RequestHeader(value="Authorization") String authToken) {
        assertAuthTokenIsValid(authToken);
        final String category = request.getCategory();
        final CategoryEntity entity = new CategoryEntity();

        assertValidRequest(category);
        entity.setCategory(category);

        return categoryRepository.save(entity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Object update(@PathVariable(value="id") final long id,
                         @RequestBody final WordRequest request,
                         @RequestHeader(value="Authorization") final String authToken) {
        assertAuthTokenIsValid(authToken);
        final String category = request.getCategory();
        assertValidRequest(category);
        final CategoryEntity entity = categoryRepository.findOne(id);
        entity.setCategory(category);

        //TODO need to update every word that currently uses the category

        return categoryRepository.save(entity);
    }

    private void assertValidRequest(final String category) {
        if (category == null) {
            throw new UnprocessableEntityException("Required parameter \"category\"");
        }

        if (categoryRepository.findByCategory(category) != null) {
            throw new UnprocessableEntityException("Duplicate: category <" + category + "> already exists.");
        }
    }

}
