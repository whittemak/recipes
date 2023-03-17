package pro.sky.recipesapp.sevice;

import org.springframework.stereotype.Service;
import pro.sky.recipesapp.dto.IngredientDTO;
import pro.sky.recipesapp.exceptions.IngredientNotFoundExeption;
import pro.sky.recipesapp.model.Ingredient;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public List<IngredientDTO> getAllIngredients() {
        List<IngredientDTO> result = new ArrayList<>();
        for (Map.Entry<Integer, Ingredient> entry : ingredients.entrySet()) {
            result.add(IngredientDTO.from(entry.getKey(), entry.getValue()));
        }
        return result;
    }
    public IngredientDTO updateIngredient(int id, Ingredient ingredient) {
        Ingredient existingIngredient = ingredients.get(id);
        if (existingIngredient == null) {
            throw new IngredientNotFoundExeption();
        }
        ingredients.put(id, ingredient);
        return IngredientDTO.from(id, ingredient);
    }

    public IngredientDTO deleteById(int id) {
        Ingredient existingIngredient = ingredients.remove(id);
        if (existingIngredient == null) {
            throw new IngredientNotFoundExeption();
        }
        return IngredientDTO.from(id, existingIngredient);
    }
}

