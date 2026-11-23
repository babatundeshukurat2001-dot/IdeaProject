package ng.ourChemo.data.repositories;

import ng.ourChemo.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepositoryImpl();
        userRepository.deleteAll();
    }

    @Test
    void newRepositoryCountIsZero() {
        assertEquals(0, userRepository.count());
    }

    @Test
    void saveUserCountIsOne() {
        userRepository.save(new User());
        assertEquals(1, userRepository.count());
    }

    @Test
    void saveUserIsAssignedIdStartingFromOne() {
        User user = userRepository.save(new User());
        assertEquals(1, user.getId());
    }

    @Test
    void saveTwoUsersIdsIncrementCorrectly() {
        User first = userRepository.save(new User());
        User second = userRepository.save(new User());
        assertEquals(1, first.getId());
        assertEquals(2, second.getId());
    }

    @Test
    void saveTwoUsersCountIsTwo() {
        userRepository.save(new User());
        userRepository.save(new User());
        assertEquals(2, userRepository.count());
    }

    @Test
    void deleteUserCountDecreases() {
        User user = userRepository.save(new User());
        userRepository.save(new User());
        userRepository.delete(user);
        assertEquals(1, userRepository.count());
    }

    @Test
    void deleteAllCountIsZero() {
        userRepository.save(new User());
        userRepository.save(new User());
        userRepository.deleteAll();
        assertEquals(0, userRepository.count());
    }

    @Test
    public void deleteAllThenSaveStartsCountFromOne() {
        userRepository.save(new User());
        userRepository.deleteAll();
        User user = userRepository.save(new User());
        assertEquals(1, userRepository.count());
    }

    @Test
    public void findByIdReturnsCorrectUser() {
        User user = userRepository.save(new User());
        User found = userRepository.findById(user.getId());
        assertEquals(user.getId(), found.getId());
    }

    @Test
    public void findByUsernameReturnsCorrectUser() {
        User user = new User();
        user.setUsername("john");
        userRepository.save(user);
        User found = userRepository.findByUsername("john");
        assertEquals("john", found.getUsername());
    }
    @Test
    public void deleteUserById () {
        User user = userRepository.save(new User());
        User second = userRepository.save(new User());
        userRepository.deleteById(user.getId());
        assertEquals(1, userRepository.count());
    }

}