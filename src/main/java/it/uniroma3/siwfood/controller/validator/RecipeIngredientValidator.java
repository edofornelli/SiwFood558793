package it.uniroma3.siwfood.controller.validator;

import it.uniroma3.siwfood.model.Ingredient;
import it.uniroma3.siwfood.model.RecipeIngredient;
import it.uniroma3.siwfood.repository.IngredientRepository;
import it.uniroma3.siwfood.repository.RecipeIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RecipeIngredientValidator implements Validator {

    @Autowired
    private RecipeIngredienteRepository recipeIngredienteRepository;

    @Override
    public void validate(Object o, Errors errors) {
        RecipeIngredient recipeIngredient = (RecipeIngredient)o;
        if (recipeIngredient.getIngredient()!=null && recipeIngredient.getRecipe()!=null

                && recipeIngredienteRepository.existsByIngredientAndRecipe(recipeIngredient.getIngredient(), recipeIngredient.getRecipe())){
            errors.reject("recipeingredient.duplicate");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return RecipeIngredient.class.equals(aClass);
    }

}
