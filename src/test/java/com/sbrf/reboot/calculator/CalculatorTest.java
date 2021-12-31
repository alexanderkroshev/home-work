package com.sbrf.reboot.calculator;

import com.sbrf.reboot.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void getAddition() {
        assertEquals(9, new Calculator().getAddition(4, 5));
    }

    @Test
    void getSubtraction() {
        assertEquals(-1, new Calculator().getSubtraction(4, 5));
    }

    @Test
    void getMultiplication() {
        assertEquals(20, new Calculator().getMultiplication(4, 5));
    }

    @Test
    void getDivision() {
        assertEquals(3, new Calculator().getDivision(9, 3));
    }

    @Test
    void getLog() {
        assertEquals(1, new Calculator().getLog(Math.E));
    }

    @Test
    void getExp() {
        assertEquals(Math.E, new Calculator().getExp(1));
    }

    @Test
    void getPow() {
        assertEquals(8, new Calculator().getPow(2,3));
    }

    @Test
    void classHasSevenMethods() {
        assertEquals(7, Calculator.class.getMethods().length - Object.class.getMethods().length);
    }
}