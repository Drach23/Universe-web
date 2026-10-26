package acro.universe.service;

import acro.universe.model.UserModel;
import acro.universe.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> findAllUsers() {
        return userRepository.findAll();
    }

    public UserModel findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException(
                        "user not found: " + id
                )
        );
    }

    public void createUser(UserModel user) {
        userRepository.save(user);
    }

    public void updateUser(UserModel user) {
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User with id " + id + " does not exist");
        }
        userRepository.deleteById(id);
    }

}
