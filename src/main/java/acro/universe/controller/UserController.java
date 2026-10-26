package acro.universe.controller;

import acro.universe.model.UserModel;
import acro.universe.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.findAllUsers();
    }
    @PostMapping
    public void createUser(@RequestBody UserModel user) {
        userService.createUser(user);
    }
    @PutMapping
    public void updateUser(@RequestBody UserModel user) {
        userService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody UserModel user) {
        userService.deleteUserById(user.getId());
    }

    @GetMapping("/{id}")
    public UserModel findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }
}
