package pro.sky.recipesapp.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.recipesapp.dto.RecipeDTO;
import pro.sky.recipesapp.model.Recipe;
import pro.sky.recipesapp.sevice.RecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    public final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    public RecipeDTO getRecipe(@PathVariable("id") int id){
        return recipeService.getRecipe(id);
    }
@PostMapping
    public RecipeDTO addRecipe(@RequestBody Recipe recipe){
        return recipeService.addRecipe(recipe);
}
}
