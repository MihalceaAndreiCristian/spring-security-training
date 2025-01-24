package ro.amihalcea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.amihalcea.model.User;
import ro.amihalcea.service.JwtService;
import ro.amihalcea.service.UserService;

@RestController
public class UserController {


    private final UserService service;
    private final AuthenticationManager manager;
    private final JwtService jwtService;

    @Autowired
    public UserController(UserService service, AuthenticationManager manager, JwtService jwtService) {
        this.service = service;
        this.manager = manager;
        this.jwtService = jwtService;
    }

    @PostMapping ("register")
    public User register(@RequestBody User user){

        return service.registerUser(user);
    }

    @PostMapping("login")
    public String login(@RequestBody User user){

        Authentication authentication =
                manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }else {
            return "Failure" ;
        }

    }
}
