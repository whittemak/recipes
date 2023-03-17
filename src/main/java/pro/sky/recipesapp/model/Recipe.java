package pro.sky.recipesapp.model;

import java.util.List;
@Data
@AllArgsConstructor
public class Recipe {
    private String title;
    private int cookingTime;
    private List<Ingredient> ingredients;
    private List<String> steps;

}
