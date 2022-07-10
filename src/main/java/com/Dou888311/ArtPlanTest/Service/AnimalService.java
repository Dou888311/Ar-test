package com.Dou888311.ArtPlanTest.Service;

import com.Dou888311.ArtPlanTest.Config.UserDetailsImpl;
import com.Dou888311.ArtPlanTest.DTO.AnimalDTO;
import com.Dou888311.ArtPlanTest.Entity.Animal;
import com.Dou888311.ArtPlanTest.Exceptions.AnimalRightsException;
import com.Dou888311.ArtPlanTest.Exceptions.NoSuchAnimalException;
import com.Dou888311.ArtPlanTest.Exceptions.UsernameAlreadyExists;
import com.Dou888311.ArtPlanTest.Repository.AnimalRepository;
import com.Dou888311.ArtPlanTest.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;
    @Autowired
    UserRepository userRepository;

    public Map<String, String> animalRegistration(Animal animal, UserDetailsImpl userDetails) {
        if (!animalRepository.existsByName(animal.getName())) {
            animal.setUser(userRepository.findUserByUsername(userDetails.getUsername()));
            UUID uuid = UUID.randomUUID();
            animal.setId(uuid.toString());
            animalRepository.save(animal);
            return Map.of("Your Animal id", animal.getId());
        } else {
            throw new UsernameAlreadyExists("Current animal name is already taken. Registration failed.");
        }
    }

    public Animal findAnimal(AnimalDTO animal) {
        return animalRepository.findAnimalById(animal.getId());
    }

    public List<Animal> getAll(UserDetailsImpl userDetails) {
        return userRepository.findUserByUsername(userDetails.getUsername()).getAnimals();
    }

    public String animalUpdate(String id, UserDetailsImpl userDetails, Animal updatingAnimal) {
        if (animalRepository.existsById(id)) {
            if (rightUserValidation(id, userDetails.getUsername())) {
                updatingAnimal.setId(id);
                updatingAnimal.setUser(userRepository.findUserByUsername(userDetails.getUsername()));
                animalRepository.save(updatingAnimal);
                return "Animal with id " + id + " successfully updated!";
            } else {
                throw new AnimalRightsException("Animal with id: " + id + "is not yours. You can`t update him. Update failing.");
            }
        } else {
            throw new NoSuchAnimalException("There is no animal with such id: " + id);
        }
    }

    public String animalDelete(String id, UserDetailsImpl userDetails) {
        if (animalRepository.existsById(id)) {
            if (rightUserValidation(id, userDetails.getUsername())) {
                animalRepository.delete(animalRepository.findAnimalById(id));
                return "Animal with id " + id + " successfully deleted!";
            } else {
                throw new AnimalRightsException("Animal with id: " + id + "is not yours. You can`t delete him. Deleting failing.");
            }
        } else {
            throw new NoSuchAnimalException("There is no animal with such id: " + id);
        }
    }

    public boolean rightUserValidation(String animalId, String currentUserUsername) {
        return animalRepository.findAnimalById(animalId).getUser().getUsername().equals(currentUserUsername);
    }
}
