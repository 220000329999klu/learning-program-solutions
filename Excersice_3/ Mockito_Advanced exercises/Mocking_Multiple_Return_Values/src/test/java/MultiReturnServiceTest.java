import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

public class MultiReturnServiceTest {

    @Test
    public void testMultipleReturnValues() {
        Iterator<String> mockIterator = mock(Iterator.class);
        when(mockIterator.next()).thenReturn("First").thenReturn("Second").thenReturn("Third");
        String result = mockIterator.next() + ", " + mockIterator.next() + ", " + mockIterator.next();
        assertEquals("First, Second, Third", result);
    }
}