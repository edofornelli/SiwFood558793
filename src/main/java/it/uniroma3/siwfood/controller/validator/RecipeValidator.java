package it.uniroma3.siwfood.controller.validator;

import it.uniroma3.siwfood.model.Recipe;
import it.uniroma3.siwfood.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RecipeValidator implements Validator {
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
public void validate(Object o, Errors errors) {
    Recipe recipe = (Recipe)o;
    if (recipe.getName()!=null && recipe.getChef()!=null
            && recipeRepository.existsByNameAndChef(recipe.getName(), recipe.getChef())) {
        errors.reject("recipe.duplicate");
    }
}
@Override
public boolean supports(Class<?> aClass) {
    return Recipe.class.equals(aClass);
}

}
