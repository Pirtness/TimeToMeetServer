package springBootRestService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springBootRestService.entities.Message;
import springBootRestService.entities.User;
import springBootRestService.repos.UserRepo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("")
    public Map<String, String> login(@RequestParam String username, @RequestParam String password) {
        User user = userRepo.findByUsername(username);
        Map<String, String> result = new HashMap<>();
        if (user == null) {
            result.put("result", "Такого пользователя не существует");
            return result;
        }
        if (user.getPassword().equals(password)) {
            result.put("result", "success");
            return result;
        } else {
            result.put("result", "Неверный пароль");
            return result;
        }
    }

    @PostMapping("/reg")
    public Map<String, String> register(@RequestParam String username, @RequestParam String password) {
        User user = userRepo.findByUsername(username);
        Map<String, String> result = new HashMap<>();

        if (user != null) {
            result.put("result", "Такой пользователь уже существует");
            return result;
        }

        user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userRepo.save(user);
        result.put("result", "success");
        return result;
    }


    @GetMapping("/show_all")
    public Iterable<User> getLogins() {
        Iterable<User> usrs = userRepo.findAll();
        return usrs;
    }

//    @GetMapping("/show")
//    public User registration(@RequestParam String username) {
//        User userFromDb = userRepo.findByUsername(username);
//        return userFromDb;
//    }
//
//    @GetMapping("")
//    public User addUser(@RequestParam String login, @RequestParam String password) {
//        User userFromDb = userRepo.findByUsername(login);
//
//        if (userFromDb == null) {
//            User user = new User();
//            user.setUsername(login);
//            user.setPassword(password);
//            user.setActive(true);
//            user.setRoles(Collections.singleton(Role.USER));
//            userRepo.save(user);
//            return user;
//        }
//
//        return userFromDb;
//    }
}


