package com.example.recette.Repository;

import com.example.recette.Entity.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetteRepository extends JpaRepository<Recette,Integer> {
}
