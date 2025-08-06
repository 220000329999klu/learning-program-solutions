

import org.example.User;
import org.example.UserController;
import org.example.UserRepository;
import org.example.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {
    private UserRepository mockRepo;
    private UserService userService;
    private UserController userController;

    @BeforeEach
    public void setUp() {
        mockRepo = mock(UserRepository.class);
        userService = new UserService(mockRepo);
        userController = new UserController(userService);
    }

    @Test
    public void testFetchUsers() {
        User user = new User(1, "Alice");
        when(mockRepo.findAll()).thenReturn(List.of(user));

        List<User> result = userController.fetchUsers();
        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getName());
    }
}