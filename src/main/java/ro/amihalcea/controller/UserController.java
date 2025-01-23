package ro.amihalcea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.amihalcea.model.User;
import ro.amihalcea.service.UserService;

@RestController
public class UserController {


    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping ("register")
    public User register(@RequestBody User user){

        return service.registerUser(user);
    }

}
