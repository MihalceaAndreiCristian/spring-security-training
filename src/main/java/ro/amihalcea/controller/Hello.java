package ro.amihalcea.SpringSecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/hello")
    public String greet(HttpServletRequest request){

        return String.format("Greetings from session %s.", request.getSession().getId());
    }
}
