package springBootRestService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springBootRestService.entities.Message;
import springBootRestService.entities.Role;
import springBootRestService.entities.User;
import springBootRestService.repos.UserRepo;

import java.util.Collections;

@RestController
@RequestMapping("/reg")
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/show_all")
    public Iterable<User> getLogins() {
        Iterable<User> usrs = userRepo.findAll();
        return usrs;
    }

    @GetMapping("/show")
    public User registration(@RequestParam String username) {
        User userFromDb = userRepo.findByUsername(username);
        return userFromDb;
    }

    @GetMapping("")
    public User addUser(@RequestParam String login, @RequestParam String password) {
        User userFromDb = userRepo.findByUsername(login);

        if (userFromDb == null) {
            User user = new User();
            user.setUsername(login);
            user.setPassword(password);
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));
            userRepo.save(user);
            return user;
        }

        return userFromDb;
    }
}


