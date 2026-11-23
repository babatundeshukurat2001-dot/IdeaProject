package services;


import ng.ourChemo.data.repositories.UserRepository;
import ng.ourChemo.data.repositories.UserRepositoryImpl;
import ng.ourChemo.dtos.requests.RegisterUserRequest;
import ng.ourChemo.dtos.requests.UserLoginRequest;
import ng.ourChemo.dtos.requests.UserLogoutRequest;
import ng.ourChemo.dtos.responses.UserLoginResponse;
import ng.ourChemo.services.AuthServices;
import ng.ourChemo.services.AuthServicesImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthServicesImplTest {

    private AuthServices authService;
    private UserRepository user;


    @BeforeEach
    void setUp() {
        user = new UserRepositoryImpl();
        authService = new AuthServicesImpl();
        user.deleteAll();
    }


    @Test
    void registerChemistIncreasesTheUsers() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("username");
        request.setPassword("password");
        request.setFullName("fullName");
        authService.registerChemist(request);
        assertEquals(1, user.count());
    }

    @Test
    void registerChemistWithDuplicateUsernameThrowsIllegalArgumentException() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("username");
        request.setPassword("password");
        request.setFullName("Yinka Adeola");
        authService.registerChemist(request);
        RegisterUserRequest request2 = new RegisterUserRequest();
        request2.setUsername("username");
        request2.setPassword("password123");
        request2.setFullName("Olamide Olatife");
        assertThrows(IllegalArgumentException.class, () -> authService.registerChemist(request2));
    }
    @Test
    void RegisteredChemistCanLoginSuccessfully() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("Horpeyemi");
        request.setPassword("password");
        request.setFullName("Opeyemi Titi");
        authService.registerChemist(request);
        assertEquals(1, user.count());

        UserLoginRequest loginRequest = new UserLoginRequest();
        loginRequest.setUsername("Horpeyemi");
        loginRequest.setPassword("password");

        UserLoginResponse response = authService.login(loginRequest);
        assertTrue(response.getLoggedIn());
    }
    @Test
    public void RegisteredChemistLoginWithWrongPasswordThrowsIllegalArgumentException() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("Horpeyemi");
        request.setPassword("password");
        request.setFullName("Opeyemi Titi");
        authService.registerChemist(request);

        UserLoginRequest loginRequest = new UserLoginRequest();
        loginRequest.setUsername("Horpeyemi");
        loginRequest.setPassword("delight");
        UserLoginResponse  newLogin = new UserLoginResponse();
        assertFalse(newLogin.getLoggedIn());
        assertThrows(IllegalArgumentException.class, () -> authService.login(loginRequest));

    }
    @Test
    public void reqisterChemistLoginWithWrongUsernameThrowsIllegalArgumentException() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("Horpeyemi");
        request.setPassword("password");
        request.setFullName("Opeyemi Titi");
        authService.registerChemist(request);

        UserLoginRequest loginRequest = new UserLoginRequest();
        loginRequest.setUsername("Horpeyemi");
        loginRequest.setPassword("password");
        UserLoginResponse  newLogin = new UserLoginResponse();

        assertFalse(newLogin.getLoggedIn());
        assertThrows(IllegalArgumentException.class, () -> authService.login(loginRequest));
    }
    @Test
    public void registerChemistLoginSuccessfullyAndLogsOut() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("Horpeyemi");
        request.setPassword("password");
        request.setFullName("Opeyemi Titi");
        authService.registerChemist(request);
        UserLoginRequest loginRequest = new UserLoginRequest();
        loginRequest.setUsername("Horpeyemi");
        loginRequest.setPassword("password");
        authService.login(loginRequest);
        UserLoginResponse loginResponse = new UserLoginResponse();
        loginResponse.setUsername("Horpeyemi");
        loginResponse.setLoggedIn(true);
        assertTrue(loginResponse.getLoggedIn());
        UserLogoutRequest  logoutRequest = new UserLogoutRequest();
        logoutRequest.setUsername("Horpeyemi");
        authService.logout(logoutRequest);
        assertFalse(user.findByUsername("Horpeyemi").getLoggedIn());
    }
    @Test
    public void registerChemistLoginSuccessfullyAndLogsOutWithWrongUsernameThrowsException() {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("Horpeyemi");
        request.setPassword("password");
        request.setFullName("Opeyemi Titi");
        authService.registerChemist(request);
        UserLoginRequest loginRequest = new UserLoginRequest();
        loginRequest.setUsername("Horpeyemi");
        loginRequest.setPassword("password");
        authService.login(loginRequest);
        UserLoginResponse loginResponse = new UserLoginResponse();
        loginResponse.setUsername("Horpeyemi");
        loginResponse.setLoggedIn(true);
        UserLogoutRequest  logoutRequest = new UserLogoutRequest();
        logoutRequest.setUsername("wrong username");
        assertThrows(IllegalArgumentException.class, () -> authService.logout(logoutRequest));

    }

}