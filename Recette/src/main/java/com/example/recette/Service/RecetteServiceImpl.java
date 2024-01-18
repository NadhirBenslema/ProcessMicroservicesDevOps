package com.example.recette.Service;

import com.example.recette.Entity.Recette;
import com.example.recette.Repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetteServiceImpl implements RecetteService {

    @Autowired
    private RecetteRepository recetteRepository;
    @Override
    public Recette addRecette(Recette recette) {
        return recetteRepository.save(recette);
    }

    @Override
    public List<Recette> retrieveAllRecipes() {
        return recetteRepository.findAll();
    }

    @Override
    public Optional<Recette> findRecipeById(Integer id) {
        return recetteRepository.findById(id);
    }

    @Override
    public String deleteRecipeById(Integer id) {
        recetteRepository.deleteById(id);
        if (recetteRepository.findById(id).isPresent()){
            Recette existingR = recetteRepository.findById(id).get();
            recetteRepository.delete(existingR);
            return "Introuvable !";
        }
        return "Recette deleted successfully !";
    }

    @Override
    public Recette updateRecipe(Recette recette, Integer id) {
        if (recetteRepository.findById(id).isPresent()) {
            Recette existingRecette = recetteRepository.findById(id).get();
            existingRecette.setTitle(recette.getTitle());
            existingRecette.setDescription(recette.getDescription());
            existingRecette.setAverageRating(recette.getAverageRating());

            return recetteRepository.save(existingRecette);
        }
        return null;
    }
}
