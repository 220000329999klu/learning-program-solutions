import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class MyServiceTest {
    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doNothing().when(mockApi).logAction();
        MyService service = new MyService(mockApi);
        service.log();
        verify(mockApi).logAction();
    }
}