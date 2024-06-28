package alebid.stasjavademo.controllers;

import alebid.stasjavademo.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "users")
    public String getAllUsers(Model model){
        var users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users/index";
    }

    @GetMapping(value = "users/{id}")
    public String userDetails(@PathVariable int id, Model model){
        var user = userRepository.findById(id);
        if(user.isPresent())
            model.addAttribute("user", user.get());
        return "users/details";
    }




}
