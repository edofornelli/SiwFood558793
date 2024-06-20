package it.uniroma3.siwfood.controller;

import it.uniroma3.siwfood.model.Chef;
import it.uniroma3.siwfood.model.Image;
import it.uniroma3.siwfood.model.Ingredient;
import it.uniroma3.siwfood.model.Recipe;
import it.uniroma3.siwfood.service.ChefService;
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
public class ChefController {

    @Autowired
    ChefService chefService;

    @GetMapping("/chef/{id}")
    public String getChef (@PathVariable("id") Long id, Model model) {
        model.addAttribute("chef", this.chefService.findById(id));
        return "chef.html";
    }


    @GetMapping("/Admin/chefs")
    public String showChefs (Model model) {
        model.addAttribute("listaChefs", this.chefService.findAll());
        return "/Admin/chefs.html";
    }


    @GetMapping("/Admin/chefOperations")
    public String recipeOperations(Model model) {
        return "/Admin/chefOperations.html";
    }



    @GetMapping("/Admin/modifyChef/{id}")
    public String modifyChef(@PathVariable("id") Long id, Model model) {
        model.addAttribute("chef", this.chefService.findById(id));
        return "/Admin/modifyChef.html";
    }

    @PostMapping("/chefUpdate")
    public String chefUpdate(@Valid @ModelAttribute("chef") Chef chef, BindingResult bindingResult, Model model) {
        Chef oldChef = this.chefService.findById(chef.getId());
        chef.setImages(oldChef.getImages());

        if (bindingResult.hasErrors()) {
            return "/Admin/modifyChef.html";
        }
        else {
            this.chefService.save(chef);

        }
        return "redirect:chef/" + chef.getId();
    }



    @GetMapping("/Admin/formNewChef")
    public String formNewChef(Model model) {
        model.addAttribute("chef", new Chef());
        return "/Admin/formNewChef.html";
    }

    @GetMapping("/addChef")
    public String addChef(Model model) {
        model.addAttribute("chef", new Chef());
        return "addChef.html";
    }


    @PostMapping("/chef")
    public String newChef(@RequestParam("files") MultipartFile[] files, @Valid @ModelAttribute("chef") Chef chef, BindingResult bindingResult, Model model) {

            if(files==null) {
                bindingResult.reject("image.null");
            }
            chef.setImages(new ArrayList<>());
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
                    chef.getImages().add(immagine);
                } catch (IOException ex) {
                    bindingResult.reject("image.readError");
                }
            }
            this.chefService.save(chef);
            return "redirect:chef/" + chef.getId();
    }


}
