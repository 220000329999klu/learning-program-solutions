import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FixtureTest {

    private Calculator calc;


    @Before
    public void setUp() {
        calc = new Calculator();
        System.out.println("Setup done");
    }


    @After
    public void tearDown() {
        System.out.println("Teardown done");
    }

    @Test
    public void testAddAAA() {

        int result = calc.add(10, 20);

        assertEquals(30, result);
    }

    @Test
    public void testSubtractAAA() {
        int result = calc.subtract(20, 5);
        assertEquals(15, result);
    }
}