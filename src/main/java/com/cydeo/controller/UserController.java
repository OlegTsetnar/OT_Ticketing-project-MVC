package com.cydeo.controller;


import com.cydeo.boostrap.DataGenerator;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    // we can inject RoleService and UserService with constructor and use to get a roles.

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll()); //bring me all roles from dataBase-->service
        model.addAttribute("users", userService.findAll());

        return "user/create";
    }

    @PostMapping("/create")
    // use @ModelAttribute to catch all data of created object when we click save button
    public String insertUser(@ModelAttribute("user") UserDTO user, Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());

        userService.save(user);
        model.addAttribute("users", userService.findAll());
        return "/user/create";
    }

    @GetMapping("/update/{username}")
    // use @pathParam to catch unique URL end point when we click update button
    // *** <a class="btn btn-warning rounded-0" th:href="@{/user/update/{id}(id=${user.userName})}">Update</a> ***
    public String editUser(@PathVariable ("username") String username, Model model) {

        model.addAttribute("user", userService.findById(username));
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "/user/update";
    }

    @PostMapping("/update/{username}")
    // Spring smart to understand which user based on th:href="@{/user/update/{id}(id=${user.userName})}" when we click update,
    // we don't need to userName, we can use UserDTO user
    public String updateUser (@PathVariable ("username") String username, UserDTO user){

        userService.update(user);

        return "redirect:/user/create";
    }

   @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable ("username") String username){

        userService.deleteById(username);

        return "redirect:/user/create";
   }


}
