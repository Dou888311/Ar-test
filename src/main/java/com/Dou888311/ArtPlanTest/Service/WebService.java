package com.Dou888311.ArtPlanTest.Service;

import com.Dou888311.ArtPlanTest.Config.UserDetailsImpl;
import com.Dou888311.ArtPlanTest.Entity.Animal;
import com.Dou888311.ArtPlanTest.Entity.User;
import com.Dou888311.ArtPlanTest.Repository.AnimalRepository;
import com.Dou888311.ArtPlanTest.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class WebService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AnimalRepository animalRepository;

    public ModelAndView userRegistration() {
        return new ModelAndView("newuser");
    }

    public ModelAndView animalRegistration() {return new ModelAndView("newanimal");}

    public ModelAndView home() {return new ModelAndView("login");}

    public ModelAndView animal() {return new ModelAndView("animal");}

    public String myAnimals(Model model, UserDetailsImpl userDetails) {
        User currentUser = userRepository.findUserByUsername(userDetails.getUsername());
        List<Animal> list = currentUser.getAnimals();
        model.addAttribute("animals", list);
        return "myanimals";
    }

    public ModelAndView findAnimal() {
        return new ModelAndView("findanimal");
    }
}
