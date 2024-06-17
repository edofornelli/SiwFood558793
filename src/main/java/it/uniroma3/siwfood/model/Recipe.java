package it.uniroma3.siwfood.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Recipe {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToOne
    private Chef chef;

    @OneToMany
    private Set <Ingredient> ingredients = new HashSet<>();

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



    public Set<Ingredient> getIngredients() {
        return ingredients;
    }
    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    public void setName(String name) {
        this.name = name;
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, ingredients, name);
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
        return id == other.id && Objects.equals(ingredients, other.ingredients) && Objects.equals(name, other.name);
    }

}