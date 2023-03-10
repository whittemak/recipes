package pro.sky.recipesapp.dto;

import pro.sky.recipesapp.model.Ingredient;

public class IngredientDTO {
    private final int id;
    private final String title;
    private final int number;
    private final String measureUnit;

    public IngredientDTO(int id, String title, int number, String measureUnit) {
        this.id = id;
        this.title = title;
        this.number = number;
        this.measureUnit = measureUnit;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getNumber() {
        return number;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }
    public static IngredientDTO from(int id, Ingredient ingredient){
        return new IngredientDTO(id, ingredient.getTitle(), ingredient.getNumber(), ingredient.getMeasureUnit());
    }
}
