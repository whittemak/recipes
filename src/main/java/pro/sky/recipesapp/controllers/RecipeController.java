package pro.sky.recipesapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipesapp.dto.RecipeDTO;
import pro.sky.recipesapp.model.Recipe;
import pro.sky.recipesapp.sevice.RecipeService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/recipe")
@Tag(name = "рецепты", description = "операции с рецептами")
public class RecipeController {
    public final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @GetMapping
    @Operation(description = "получение списка всех рецептов")
    public List<RecipeDTO> getRecipes(){
        return recipeService.getAllRecipes();
    }


    @GetMapping("/{id}")
    @Operation(description = "получение рецепта по айди")
    public RecipeDTO getRecipe(@PathVariable("id") int id){
        return recipeService.getRecipe(id);
    }
@PostMapping
@Operation(description = "добавление рецепта")
    public RecipeDTO addRecipe(@RequestBody Recipe recipe) throws IOException {
        return recipeService.addRecipe(recipe);
}
@PutMapping("/{id}")
@Operation(description = "редактирование рецепта")
    public RecipeDTO editRecipe(@PathVariable("id") int id, @RequestBody Recipe recipe) throws IOException {
        return recipeService.updateRecipe(id, recipe);
}
@DeleteMapping("/{id}")
@Operation(description = "удаление рецепта")
    public RecipeDTO deleteRecipe(@PathVariable("id") int id) throws IOException {
        return recipeService.deleteById(id);
}
}
