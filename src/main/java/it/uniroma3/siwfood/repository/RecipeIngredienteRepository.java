package it.uniroma3.siwfood.repository;

import it.uniroma3.siwfood.model.Ingredient;
import it.uniroma3.siwfood.model.Recipe;
import it.uniroma3.siwfood.model.RecipeIngredient;
import org.springframework.data.repository.CrudRepository;

public interface RecipeIngredienteRepository extends CrudRepository<RecipeIngredient, Long> {

    boolean existsByIngredientAndRecipe(Ingredient ingredient, Recipe recipe);

}
