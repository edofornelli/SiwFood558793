package it.uniroma3.siwfood.service;

import it.uniroma3.siwfood.model.Ingredient;
import it.uniroma3.siwfood.model.Recipe;
import it.uniroma3.siwfood.model.RecipeIngredient;
import it.uniroma3.siwfood.repository.IngredientRepository;
import it.uniroma3.siwfood.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientService ingredientService;

    public Recipe findById (long id) {
        return recipeRepository.findById(id).get();

    }

    public Iterable <Recipe> findAll(){
        return recipeRepository.findAll();
    }

    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public void saveRecipeIngredientToRecipe(float quantita, Long recipeId, Long IngredientId){

    Recipe recipe = this.findById(recipeId);
    Ingredient ingredient = this.ingredientService.findById(IngredientId);

    RecipeIngredient nuovoIngrediente = new RecipeIngredient( recipe, ingredient, quantita);
    recipe.getIngredients().add(nuovoIngrediente);

    this.ingredientService.saveRecipyIngredient(nuovoIngrediente);
    this.save(recipe);

    }

}