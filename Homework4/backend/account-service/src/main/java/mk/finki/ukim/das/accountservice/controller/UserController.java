package mk.finki.ukim.das.accountservice.controller;

import mk.finki.ukim.das.accountservice.model.User;
import mk.finki.ukim.das.accountservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<User> getAllObjects(){
        return userService.findAll();
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public Long getUserById(@PathVariable String username){
        return userService.getId(username);
    }

}
