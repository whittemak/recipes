package pro.sky.recipesapp.sevice;

import org.springframework.stereotype.Service;
import pro.sky.recipesapp.dto.IngredientDTO;
import pro.sky.recipesapp.dto.RecipeDTO;
import pro.sky.recipesapp.model.Ingredient;
import pro.sky.recipesapp.model.Recipe;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientService {
    private int idCounter = 0;
    private final Map<Integer, Ingredient> ingredients = new HashMap<>();
    public IngredientDTO addIngredient(Ingredient ingredient){
        int id = idCounter++;
        ingredients.put(id, ingredient);
        return IngredientDTO.from(id, ingredient);
    }
    public IngredientDTO getIngredient(int id){
        Ingredient ingredient = ingredients.get(id);
        if (ingredient != null){
            return IngredientDTO.from(id, ingredient);
        }
        return null;
    }
}

