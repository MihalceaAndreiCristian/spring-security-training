package ro.amihalcea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.amihalcea.model.User;
import ro.amihalcea.repository.UserRepository;

import java.util.List;

@Service
public class UserService {


    private UserRepository repo;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var usersaved = repo.save(user);
        if ( usersaved != null) {
            return user;
        }
        throw new RuntimeException(String.format("Issue while registering user %s.\n", user.getUsername()));
    }

}
