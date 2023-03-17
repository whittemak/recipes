package pro.sky.recipesapp.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.recipesapp.dto.IngredientDTO;
import pro.sky.recipesapp.dto.RecipeDTO;
import pro.sky.recipesapp.model.Ingredient;
import pro.sky.recipesapp.model.Recipe;
import pro.sky.recipesapp.sevice.IngredientService;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    public final IngredientController ingredientService;

    public IngredientController(IngredientController ingredientService) {
        this.ingredientService = ingredientService;
    }
    @GetMapping
    public List<IngredientDTO> getIngredients(){
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/{id}")
    public IngredientDTO getIngredient(@PathVariable("id") int id){
        return ingredientService.getIngredient(id);
    }
    @PostMapping
    public IngredientDTO addIngredient(@RequestBody Ingredient ingredient){
        return ingredientService.addIngredient(ingredient);
    }
    @PutMapping
    public IngredientDTO editIngredient(@PathVariable("id") int id, @RequestBody Ingredient ingredient){
        return ingredientService.updateIngredient(id, ingredient);
    }
    @DeleteMapping("/{id}")
    public IngredientDTO deleteIngredient(@PathVariable("id") int id){
        return ingredientService.deleteById(id);
    }
}

