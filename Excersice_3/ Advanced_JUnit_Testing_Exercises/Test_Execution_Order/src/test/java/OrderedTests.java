import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void firstTest() {
        System.out.println("Running First Test");
    }

    @Test
    @Order(2)
    void secondTest() {
        System.out.println("Running Second Test");
    }

    @Test
    @Order(3)
    void thirdTest() {
        System.out.println("Running Third Test");
    }
}