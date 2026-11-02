package acro.universe.service;

import acro.universe.exception.ErrorMessages;
import acro.universe.exception.ResourceNotFoundException;
import acro.universe.model.UserModel;
import acro.universe.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
                () -> new ResourceNotFoundException(
                        String.format(ErrorMessages.USER_NOT_FOUND, id)
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
            throw new ResourceNotFoundException(
                    String.format(ErrorMessages.USER_NOT_FOUND, id)
            );
        }
        userRepository.deleteById(id);
    }

}
