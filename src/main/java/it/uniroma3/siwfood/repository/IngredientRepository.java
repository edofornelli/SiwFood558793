package it.uniroma3.siwfood.repository;

import it.uniroma3.siwfood.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long>{
    public boolean existsByName(String name);
}
