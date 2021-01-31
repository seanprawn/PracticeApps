package com.example.recyclerviewrecipes;

public class Recipe {
    public String recipeTitle;
    public String recipeShortDesc;
    public String recipeDetails;

    public Recipe(String title, String desc, String details)
    {
        this.recipeTitle = title;
        this.recipeShortDesc = desc;
        this.recipeDetails = details;
    }
}
