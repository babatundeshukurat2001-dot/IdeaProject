package ng.ourChemo.services;


import ng.ourChemo.data.models.User;
import ng.ourChemo.data.repositories.UserRepository;
import ng.ourChemo.data.repositories.UserRepositoryImpl;
import ng.ourChemo.dtos.requests.RegisterUserRequest;
import ng.ourChemo.dtos.requests.UserLoginRequest;
import ng.ourChemo.dtos.requests.UserLogoutRequest;
import ng.ourChemo.dtos.responses.RegisterUserResponse;
import ng.ourChemo.dtos.responses.UserLoginResponse;
import ng.ourChemo.dtos.responses.UserLogoutResponse;
import ng.ourChemo.utils.Mapper;

import static ng.ourChemo.utils.Mapper.mapToLogin;

public class AuthServicesImpl implements AuthServices {

    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public RegisterUserResponse registerChemist(RegisterUserRequest registerUserRequest) {
        if (userRepository.findByUsername(registerUserRequest.getUsername().replaceAll(" ", "")) != null) {
            throw new IllegalArgumentException("Username " + registerUserRequest.getUsername() + " already exists");
        }
        userRepository.save(Mapper.mapToUser(registerUserRequest));
        return null;
    }

    @Override
    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        User user = userRepository.findByUsername(userLoginRequest.getUsername());
        if (user == null) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (!user.getPassword().equals(userLoginRequest.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }
        userRepository.save(Mapper.mapToLogin(userLoginRequest));
        UserLoginResponse response = new UserLoginResponse();
        response.setUsername(user.getUsername());
        response.setLoggedIn(true);
        return response;
    }

    @Override
    public UserLogoutResponse logout(UserLogoutRequest userLogoutRequest) {
        User user = userRepository.findByUsername(userLogoutRequest.getUsername());
        if (user == null) {
            throw new IllegalArgumentException("Invalid username");
        }
        user.setLoggedIn(false);
        UserLogoutResponse response = new UserLogoutResponse();
        response.setUsername(user.getUsername());
        response.setLoggedIn(false);
        userRepository.save(user);
        return response;

    }
}