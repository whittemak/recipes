package pro.sky.recipesapp.sevice;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pro.sky.recipesapp.dto.RecipeDTO;
import pro.sky.recipesapp.exceptions.RecipeNotFoundException;
import pro.sky.recipesapp.model.Recipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecipeService {
    private final static String STORE_FILE_NAME = "recipes";
    private int idCounter = 0;
    private final Map<Integer, Recipe> recipes = new HashMap<>();
    private final FileService fileService;

    public RecipeService(FileService fileService) {
        this.fileService = fileService;
    }
    @PostConstruct
    private void init(){
        readFromFile();
    }

    public RecipeDTO addRecipe(Recipe recipe) throws IOException {
        int id = idCounter++;
        recipes.put(id, recipe);
        this.fileService.saveToFile(STORE_FILE_NAME, this.recipes);
        return RecipeDTO.from(id, recipe);
    }

    public RecipeDTO getRecipe(int id) {
        Recipe recipe = recipes.get(id);
        if (recipe != null) {
            return RecipeDTO.from(id, recipe);
        }
        return null;
    }

    public List<RecipeDTO> getAllRecipes() {
        List<RecipeDTO> result = new ArrayList<>();
        for (Map.Entry<Integer, Recipe> entry : recipes.entrySet()) {
            result.add(RecipeDTO.from(entry.getKey(), entry.getValue()));
        }
        return result;
    }

    public RecipeDTO updateRecipe(int id, Recipe recipe) throws IOException {
        Recipe existingRecipe = recipes.get(id);
        if (existingRecipe == null) {
            throw new RecipeNotFoundException();
        }
        recipes.put(id, recipe);
        this.fileService.saveToFile(STORE_FILE_NAME, this.recipes);
        return RecipeDTO.from(id, recipe);
    }

    public RecipeDTO deleteById(int id) throws IOException {
        Recipe existingRecipe = recipes.remove(id);
        if (existingRecipe == null) {
            throw new RecipeNotFoundException();
        }
        this.fileService.saveToFile(STORE_FILE_NAME, this.recipes);
        return RecipeDTO.from(id, existingRecipe);
    }
}






















