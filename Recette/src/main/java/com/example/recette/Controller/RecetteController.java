package com.example.recette.Controller;

import com.example.recette.Entity.Recette;
import com.example.recette.Service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/recette")
public class RecetteController {
    @Autowired
    private RecetteService recetteService;

    @PostMapping("/add")
    @ResponseStatus
    public ResponseEntity<Recette> createRecette(@RequestBody Recette recette){
        return new ResponseEntity<>(recetteService.addRecette(recette), HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    @ResponseStatus
    public List<Recette> getAllRecipes(){
        return recetteService.retrieveAllRecipes();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus
    public Optional<Recette> getRecipesById(@PathVariable("id")Integer id){
        return recetteService.findRecipeById(id);
    }

    @PutMapping( value = "/update/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus
    public ResponseEntity<Recette> updateRecipe(@RequestBody Recette recette,@PathVariable("id") Integer id){
        return new ResponseEntity<>(recetteService.updateRecipe(recette,id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  ResponseEntity<String> deleteRecette(@PathVariable("id") Integer id){
            return new ResponseEntity<>(recetteService.deleteRecipeById(id), HttpStatus.OK);
    }

}
