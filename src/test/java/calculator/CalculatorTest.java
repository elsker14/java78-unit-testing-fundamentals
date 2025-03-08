package calculator;

/*
    Create Calculator class and implement operations: addition, subtraction, multiplication, division.
    Then create CalculatorTest class with tests above operations.

    User Story: tichet in Jira de tipul Story care sa va indice BUSINESS LEVEL ce trebuie sa faca functionalitatea
        - Who?
        - What?
        - Why?
        As a user of digital scientific calculator,
        I want to be able to do addition, subtraction, multiplication, division,
        So I can do calculations faster.

    Acceptance Criteria:
        - For divide by zero should throw ArithmeticException.

    Tasks & Sub-tasks:
        - addition (assigned to Peeps 1)
            -- failing test
            -- implementation & passing test
            -- refactor & commit
        - subtraction (assigned to Peeps 2)
        - multiplication (assigned to Peeps 3)
        - division (assigned to Peeps 4)

    Conform metologiei TDD:
    1. scriem testul care pica
    2. scriem implementarea care trece testul
    3. refactorizam

    Testele unitare se comporta ca Source Of Truth.
 */

import org.example.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculatorUT = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5.0, calculatorUT.add(2,3));   // if(5 == calculatorUT.add(2,3) { test pass } else { throw new Exception() }
        assertEquals(-1.0, calculatorUT.add(-2, 1));
        assertEquals(0.0, calculatorUT.add(2, -2));
    }

    @Test
    public void testSubtract() {
        assertEquals(-1.0, calculatorUT.subtract(2,3));
        assertEquals(-3.0, calculatorUT.subtract(-2, 1));
        assertEquals(4.0, calculatorUT.subtract(2, -2));
    }

    @Test
    public void testMultiply() {
        assertEquals(6.0, calculatorUT.multiply(2,3));
        assertEquals(-2.0, calculatorUT.multiply(-2, 1));
        assertEquals(-4.0, calculatorUT.multiply(2, -2));
    }

    @Test
    public void testDivide() {
        assertEquals(1.5, calculatorUT.divide(3,2));
        assertEquals(-2.0, calculatorUT.divide(-2, 1));
        assertEquals(-1.0, calculatorUT.divide(2, -2));

        /*
        Al doilea argument al metodei assertThrows este o interfata functionala neparametrizata,
        numita Executable.
         */
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculatorUT.divide(1,0);
        });
        assertEquals("Divide by zero", exception.getMessage());
    }

}
