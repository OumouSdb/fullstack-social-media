package Controllers;

import Models.User;
import Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public User createUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        this.userService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable long id) {
        return this.userService.findById(id);
    }

    @GetMapping()
    public List<User> getAll() {
        return this.userService.getAll();
    }
}
