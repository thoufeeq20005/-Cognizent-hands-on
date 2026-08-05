package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

    Calculator c = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(10, c.add(5,5));
    }

    @Test
    public void testSubtract() {
        assertEquals(2, c.subtract(5,3));
    }

    @Test
    public void testTrue() {
        assertTrue(c.isPositive(5));
    }

    @Test
    public void testFalse() {
        assertFalse(c.isPositive(-5));
    }

    @Test
    public void testNotNull() {
        assertNotNull(c.getMessage());
    }

    @Test
    public void testNull() {
        assertNull(c.getNullValue());
    }
}