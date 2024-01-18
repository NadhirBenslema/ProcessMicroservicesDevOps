package com.example.recette.Service;

import com.example.recette.Entity.Recette;

import java.util.List;
import java.util.Optional;

public interface RecetteService {
    Recette addRecette(Recette recette);
    List<Recette> retrieveAllRecipes();
    Optional<Recette> findRecipeById(Integer id);
    String deleteRecipeById(Integer id);
    Recette updateRecipe(Recette recette,Integer id);

}
