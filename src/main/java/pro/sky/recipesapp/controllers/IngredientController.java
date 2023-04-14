package pro.sky.recipesapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipesapp.dto.IngredientDTO;
import pro.sky.recipesapp.model.Ingredient;
import pro.sky.recipesapp.sevice.IngredientService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/ingredient")
@Tag(name = "ингридиенты", description = "операции с ингридиентами")
public class IngredientController {
    public final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @GetMapping
    @Operation(description = "получение списка всех ингридентов")
    public List<IngredientDTO> getIngredients(){
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/{id}")
    @Operation(description = "получение ингридента по айди")
    public IngredientDTO getIngredient(@PathVariable("id") int id){
        return ingredientService.getIngredient(id);
    }
    @PostMapping
    @Operation(description = "добавление ингридиента")
    public IngredientDTO addIngredient(@RequestBody Ingredient ingredient) throws IOException {
        return ingredientService.addIngredient(ingredient);
    }
    @PutMapping("/{id}")
    @Operation(description = "редактирование ингридиента")
    public IngredientDTO editIngredient(@PathVariable("id") int id, @RequestBody Ingredient ingredient) throws IOException {
        return ingredientService.updateIngredient(id, ingredient);
    }
    @DeleteMapping("/{id}")
    @Operation(description = "удаление ингридиента по айди")
    public IngredientDTO deleteIngredient(@PathVariable("id") int id) throws IOException {
        return ingredientService.deleteById(id);
    }
}

