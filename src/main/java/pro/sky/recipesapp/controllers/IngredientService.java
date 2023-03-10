package pro.sky.recipesapp.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.recipesapp.dto.IngredientDTO;
import pro.sky.recipesapp.dto.RecipeDTO;
import pro.sky.recipesapp.model.Ingredient;
import pro.sky.recipesapp.model.Recipe;

@RestController
@RequestMapping("/ingredient")
public class IngredientService {
    public final IngredientService ingredientService;

    public IngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @GetMapping("/{id}")
    public IngredientDTO getIngredient(@PathVariable("id") int id){
        return ingredientService.getIngredient(id);
    }
    @PostMapping
    public IngredientDTO addIngredient(@RequestBody Ingredient ingredient){
        return ingredientService.addIngredient(ingredient);
    }
}
