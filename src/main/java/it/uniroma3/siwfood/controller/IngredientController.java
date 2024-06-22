package it.uniroma3.siwfood.controller;

import it.uniroma3.siwfood.controller.validator.IngredientValidator;
import it.uniroma3.siwfood.model.Ingredient;
import it.uniroma3.siwfood.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IngredientController {

    @Autowired
    IngredientService ingredientService;
    @Autowired
    IngredientValidator IngredientValidator;

    @GetMapping("/Chef/ingredientOperations")
    public String ingredientOperations(Model model) {
        return "/Chef/ingredientOperations.html";
    }


    @GetMapping("/Chef/formNewIngredient")
    public String formNewIngredient(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "/Chef/formNewIngredient";
    }

    @PostMapping("/Chef/ingredient")
    public String newIngredient(@ModelAttribute("ingredient") Ingredient ingredient, BindingResult bindingResult, Model model) {
        this.IngredientValidator.validate(ingredient, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/Chef/formNewIngredient";
        }
        else {
            this.ingredientService.save(ingredient);
            model.addAttribute("ingredient", ingredient);
        }
        return "/Chef/ingredientOperations.html";
    }

}
