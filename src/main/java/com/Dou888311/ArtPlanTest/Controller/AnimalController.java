package com.Dou888311.ArtPlanTest.Controller;

import com.Dou888311.ArtPlanTest.Config.UserDetailsImpl;
import com.Dou888311.ArtPlanTest.DTO.AnimalDTO;
import com.Dou888311.ArtPlanTest.Entity.Animal;
import com.Dou888311.ArtPlanTest.Service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @PostMapping("/api/animal/registration")
    public Map<String, String> animalRegistration(@RequestBody Animal animal, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return animalService.animalRegistration(animal, userDetails);
    }

    @PutMapping("/api/animal/update/{id}")
    public String animalUpdate(@PathVariable String id,
                               @AuthenticationPrincipal UserDetailsImpl userDetails,
                               @RequestBody Animal animal) {
        return animalService.animalUpdate(id, userDetails, animal);
    }

    @DeleteMapping("/api/animal/delete/{id}")
    public String animalDelete(@PathVariable String id,
                               @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return animalService.animalDelete(id, userDetails);
    }

    @PostMapping("/api/animal/find")
    public Animal animalFind(@RequestBody AnimalDTO animal) {
        return animalService.findAnimal(animal);
    }

    @GetMapping("/api/animal/showall")
    public List<Animal> showAllAnimals(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return animalService.getAll(userDetails);
    }
}
