package it.uniroma3.siwfood.service;

import it.uniroma3.siwfood.model.Ingredient;
import it.uniroma3.siwfood.model.RecipeIngredient;
import it.uniroma3.siwfood.repository.IngredientRepository;
import it.uniroma3.siwfood.repository.RecipeIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeIngredienteRepository recipeIngredienteRepository;


    public Ingredient findById (long id) {
        return ingredientRepository.findById(id).get();
    }


    public Iterable<Ingredient> findAll(){
        return ingredientRepository.findAll();
    }

    public Iterable<RecipeIngredient> findAllRecipeIngredients(){
        return recipeIngredienteRepository.findAll();
    }




    public void save(Ingredient ingrediente) {
        ingredientRepository.save(ingrediente);
    }

    public void saveRecipyIngredient(RecipeIngredient ingrediente) {
        recipeIngredienteRepository.save(ingrediente);
    }
}