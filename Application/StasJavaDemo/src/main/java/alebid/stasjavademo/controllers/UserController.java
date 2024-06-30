package alebid.stasjavademo.controllers;

import alebid.stasjavademo.entities.User;
import alebid.stasjavademo.repositories.RoleRepository;
import alebid.stasjavademo.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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
        user.ifPresent(value -> model.addAttribute("user", value));
        return "users/details";
    }

    //Create methods
    @GetMapping(value = "/users/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepository.findAll());
        return "users/create";
    }

    @PostMapping(value = "/users/create")
    public String create(@Valid User user, BindingResult br, Model model) {
        //Save
        if (!br.hasErrors()) {
            userRepository.save(user);
            return "redirect:/users";
        } else {
            model.addAttribute("roles", roleRepository.findAll());
            return "users/create";
        }
    }

    //Edit methods
    @GetMapping(value = "/users/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        var user = userRepository.findById(id);
        if (user.isPresent()){
            model.addAttribute("user", user.get());
            model.addAttribute("roles", roleRepository.findAll());
        }
        return "users/edit";
    }


    @PostMapping(value = "/users/edit/{id}")
    public String edit(@Valid User user, BindingResult br, Model model) {

        if (!br.hasErrors()) {
            userRepository.save(user);
            return "redirect:/users";
        } else {
            model.addAttribute("roles", roleRepository.findAll());
            return "/users/edit";
        }

    }

    // Delete methods
    @GetMapping(value = "/users/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        var user = userRepository.findById(id);
        if (user.isPresent())
            model.addAttribute("user", user.get());
        return "users/delete";
    }

    @PostMapping(value = "/users/delete/{id}")
    public String deleteConfirm(@PathVariable int id, Model model) {
        var user = userRepository.findById(id);
        if(user.isPresent()) {
                userRepository.deleteById(id);
                return "redirect:/users";
        }else{
            return "redirect:/users";
        }
    }

}
