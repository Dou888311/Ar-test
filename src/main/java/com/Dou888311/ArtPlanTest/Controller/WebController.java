package com.Dou888311.ArtPlanTest.Controller;

import com.Dou888311.ArtPlanTest.Config.UserDetailsImpl;
import com.Dou888311.ArtPlanTest.Service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @Autowired
    WebService webService;

    @GetMapping("/user/registration")
    public ModelAndView userRegistration() {
        return webService.userRegistration();
    }

    @GetMapping("/user/home")
    public ModelAndView home() {return webService.home();}

    @GetMapping("/animal")
    public ModelAndView animal() {return webService.animal();}

    @GetMapping("/myanimals")
    public String myAnimals(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return webService.myAnimals(model, userDetails);}

    @GetMapping("/addanimal")
    public ModelAndView animalRegistration() {return webService.animalRegistration();}

    @GetMapping("/findanimal")
    public ModelAndView findAnimal() {return webService.findAnimal();}

}
