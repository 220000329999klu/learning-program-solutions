import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;

public class PerformanceTesterTes {

    @Test
    void testTaskCompletesInTime() {
        PerformanceTester tester = new PerformanceTester();
        assertTimeout(Duration.ofSeconds(1), () -> tester.performTask());
    }
}