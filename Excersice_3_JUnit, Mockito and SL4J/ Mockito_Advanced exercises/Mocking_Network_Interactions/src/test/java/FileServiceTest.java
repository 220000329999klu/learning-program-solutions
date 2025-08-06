import org.junit.jupiter.api.Test;
import java.io.FileWriter;
import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class FileServiceTest {

    @Test
    public void testDownloadAndSave() throws IOException {
        // Mock dependencies
        NetworkClient mockClient = mock(NetworkClient.class);
        FileWriter mockWriter = mock(FileWriter.class); // Needs mock-maker-inline

        // Stub network call
        when(mockClient.fetchData()).thenReturn("Mock Data");

        // Inject mocks
        NetworkService service = new NetworkService(mockClient, mockWriter);

        // Execute method
        String result = service.downloadAndSave();

        // Verify behavior
        assertEquals("Saved: Mock Data", result);
        verify(mockClient).fetchData();
        verify(mockWriter).write("Mock Data");
    }
}