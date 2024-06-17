package it.uniroma3.siwfood.service;

import it.uniroma3.siwfood.model.Recipe;
import it.uniroma3.siwfood.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe findById (long id) {
        return recipeRepository.findById(id).get();

    }

    public Iterable <Recipe> findAll(){
        return recipeRepository.findAll();
    }
}