package com.openclassrooms.mddapi.Controllers;

import com.openclassrooms.mddapi.Dto.UserDto;
import com.openclassrooms.mddapi.Services.UserService;
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
    public UserDto createUser(@RequestBody UserDto user) {
        return this.userService.saveUser(user);
    }

  @PutMapping("/save/{id}")
  public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto user) {
    user.setId(id);
    return this.userService.save(user);
  }

  @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        this.userService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<UserDto> findById(@PathVariable long id) {
        return this.userService.findById(id);
    }

    @GetMapping()
    public List<UserDto> getAll() {
        return this.userService.getAll();
    }
}
