package it.uniroma3.siwfood.controller.validator;

import it.uniroma3.siwfood.model.Ingredient;
import it.uniroma3.siwfood.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component  // This annotation allows Spring to automatically detect this class as a Bean and use it as a Validator
public class IngredientValidator implements Validator {


    @Autowired
    private IngredientRepository ingredientRepository;


    @Override
    public void validate(Object o, Errors errors) {
        Ingredient ingredient = (Ingredient)o;
        if (ingredient.getName()!=null && ingredientRepository.existsByName(ingredient.getName())){
            errors.reject("ingredient.duplicate");
        }
    }
    @Override
    public boolean supports(Class<?> aClass) {
        return Ingredient.class.equals(aClass);
    }

}
