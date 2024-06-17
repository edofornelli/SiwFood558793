package it.uniroma3.siwfood.service;

import it.uniroma3.siwfood.model.Ingredient;
import it.uniroma3.siwfood.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public Ingredient findById (long id) {
        return ingredientRepository.findById(id).get();

    }

    public Iterable<Ingredient> findAll(){
        return ingredientRepository.findAll();
    }
}