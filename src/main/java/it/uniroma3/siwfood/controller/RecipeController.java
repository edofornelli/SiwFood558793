package it.uniroma3.siwfood.controller;

import it.uniroma3.siwfood.model.Chef;
import it.uniroma3.siwfood.model.Image;
import it.uniroma3.siwfood.model.Recipe;
import it.uniroma3.siwfood.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class RecipeController {

    @Autowired  RecipeService recipeService;

    @GetMapping("/recipe/{id}")
    public String getRecipe (@PathVariable("id") Long id, Model model) {
        model.addAttribute("recipe", this.recipeService.findById(id));
        return "recipe.html";
    }


    @GetMapping("/recipes")
    public String showRecipes (Model model) {
        model.addAttribute("recipes", this.recipeService.findAll());
        return "recipes.html";
    }

    @GetMapping("/recipeOperations")
    public String recipeOperations(Model model) {
        return "recipeOperations.html";
    }

    @GetMapping("/Chef/formNewRecipe")
    public String formNewRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "/Chef/formNewRecipe.html";
    }

    @GetMapping("/formSearchRecipe")
    public String formSearchRecipe(Model model) {
        model.addAttribute("recipe");
        return "formSearchRecipe.html";
    }

//    @PostMapping("/recipe")
//    public String newRecipe(@ModelAttribute("recipe") Recipe recipe, Model model) {
//        this.recipeService.save(recipe);
//        model.addAttribute("recipe", recipe);
//        return "redirect:recipe/"+recipe.getId();
//    }

    @PostMapping("/recipe")
    public String newRecipe(@RequestParam("files") MultipartFile[] files, @Valid @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult, Model model) {

        if(files==null) {
            bindingResult.reject("image.null");
        }
        recipe.setImages(new ArrayList<>());
        for (MultipartFile file : files) {
            try {
                Image immagine = new Image();
                immagine.setFilename(file.getOriginalFilename());
                immagine.setImageData(file.getBytes());
                String format = immagine.getFormat();
                if (!(format.equals("jpeg") || format.equals("png") || format.equals("jpg"))) {
                    bindingResult.reject("image.formatNotSupported");
                    continue;
                }
                recipe.getImages().add(immagine);
            } catch (IOException ex) {
                bindingResult.reject("image.readError");
            }
        }
        this.recipeService.save(recipe);
        return "redirect:recipe/" + recipe.getId();
    }

    @GetMapping("/Chef/modifyRecipe")
    public String modifyRecipe(Model model) {
        model.addAttribute("recipe");
        return "/Chef/modifyRecipe.html";
    }


}
