package com.Dou888311.ArtPlanTest.Repository;

import com.Dou888311.ArtPlanTest.Entity.Animal;
import com.Dou888311.ArtPlanTest.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, String> {

    Animal findAnimalById(String id);
    Boolean existsByName(String name);
}
