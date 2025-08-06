import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserById() {
        com.example.model.User user = new com.example.model.User();
        user.setId(1L);
        user.setName("John");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        com.example.model.User result = userService.getUserById(1L);
        assertEquals("John", result.getName());
    }
}