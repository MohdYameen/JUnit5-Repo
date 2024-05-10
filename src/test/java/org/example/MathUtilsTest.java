package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD) // this is equivalent to not using it, default behaviour.

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeAll //
    static void beforeAllInit(){
        System.out.println("This needs to run before all");
    }

    @BeforeEach // tells junit to run this before each of the test methods.
    void init(){
        mathUtils = new MathUtils();
    }

    @AfterEach // beforeAll and AfterAll runs before the instance are created and after instance are terminated.
    void cleanup(){
        System.out.println("Cleaning up....");
    }

    @Test
    void testAdd(){
        int expected = 3;
        int actual = mathUtils.add(1,2);
        assertEquals(expected, actual,  "The add method should add two numbers"); //assertEquals does almost everything that all others assert methods can do.
    }

    @Test
    void testDivide(){
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0),"divide by zero should throw");
    }

    @Test
    void testComputeCircleArea(){
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "This returns the area of given circle");
    }


}
