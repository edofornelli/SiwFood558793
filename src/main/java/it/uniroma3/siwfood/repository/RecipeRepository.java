package it.uniroma3.siwfood.repository;
import it.uniroma3.siwfood.model.Chef;
import it.uniroma3.siwfood.model.Recipe;
import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    public boolean existsByNameAndChef(String name, Chef chef);

}
