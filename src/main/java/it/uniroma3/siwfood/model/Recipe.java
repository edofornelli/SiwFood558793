package it.uniroma3.siwfood.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Recipe {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String name;

    @ManyToOne
    private Chef chef;

    @OneToMany
    private Set <RecipeIngredient> ingredients = new HashSet<>();

    public Recipe() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Chef getChef() {
        return chef;
    }
    public void setChef(Chef chef) {
        this.chef = chef;
    }
    public String getName() {
        return name;
    }



    public Set<RecipeIngredient> getIngredients() {
        return ingredients;
    }
    public void setIngredients(Set<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }
    public void setName(String name) {
        this.name = name;
    }


    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> images;

    public Image getFirstImage() {
        return this.images.get(0);
    }

    public List<Image> getAllImagesWithoutFirst(){
        try {
            return this.images.subList(1, images.size());
        } catch(Exception e) {
            return null;
        }
    }

    public List<Image> getImages() {
        return images;
    }
    public void setImages(List<Image> images) {
        this.images = images;
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Recipe other = (Recipe) obj;
        return id == other.id && Objects.equals(chef, other.chef) && Objects.equals(name, other.name);
    }

}