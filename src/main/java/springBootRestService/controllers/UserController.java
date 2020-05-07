package springBootRestService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springBootRestService.repos.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController  {
    @Autowired
    UserRepo userRepo;

    //@GetMapping
    //public
}
