package pro.sky.recipesapp.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.recipesapp.dto.RecipeDTO;
import pro.sky.recipesapp.model.Recipe;
import pro.sky.recipesapp.sevice.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    public final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @GetMapping
    public List<RecipeDTO> getRecipes(){
        return recipeService.getAllRecipes();
    }


    @GetMapping("/{id}")
    public RecipeDTO getRecipe(@PathVariable("id") int id){
        return recipeService.getRecipe(id);
    }
@PostMapping
    public RecipeDTO addRecipe(@RequestBody Recipe recipe){
        return recipeService.addRecipe(recipe);
}
@PutMapping
    public RecipeDTO editRecipe(@PathVariable("id") int id, @RequestBody Recipe recipe){
        return recipeService.updateRecipe(id, recipe);
}
@DeleteMapping("/{id}")
    public RecipeDTO deleteRecipe(@PathVariable("id") int id){
        return recipeService.deleteById(id);
}
}
