package ro.amihalcea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.amihalcea.model.User;
import ro.amihalcea.model.UserPrincipal;
import ro.amihalcea.repository.UserRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {


    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user== null){
            System.out.println("User 404.");
            throw new UsernameNotFoundException("User not found.");
        }

        System.out.printf("User with id %s found.\n",user.getId());

        return new UserPrincipal(user);
    }
}
