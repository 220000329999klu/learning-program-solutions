package com.testing.assertions;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {

        assertEquals(6, 3 + 3);


        assertTrue(7 > 3);


        assertFalse(7 < 3);


        assertNull(null);


        assertNotNull(new Object());
    }
}