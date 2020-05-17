package springBootRestService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springBootRestService.entities.User;
import springBootRestService.repos.UserRepo;

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

        try {
            user = new User();
            user.setUsername(username);
            user.setPassword(password);

            userRepo.save(user);
            result.put("result", "success");
            return result;
        } catch (Exception e) {
            result.put("result", e.getMessage());
            return result;
        }
    }


    @GetMapping("/show_all")
    public Iterable<User> getLogins() {
        Iterable<User> usrs = userRepo.findAll();
        return usrs;
    }
    
}


