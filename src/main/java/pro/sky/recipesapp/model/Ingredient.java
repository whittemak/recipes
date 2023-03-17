package pro.sky.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {
    private String title;
    private int number;
    private String measureUnit;

}
