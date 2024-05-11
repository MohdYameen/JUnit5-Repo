package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

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

//    @AfterEach // beforeAll and AfterAll runs before the instance are created and after instance are terminated.
//    void cleanup(){
//        System.out.println("Cleaning up....");
//    }

    @Nested
    class AddTest{
        @Test
        @DisplayName("Testing Add Positive Method")
        void testAddPositive(){
            assertEquals(3, mathUtils.add(1,2),  "The add method should add two numbers"); //assertEquals does almost everything that all others assert methods can do.
        }
        @Test
        @DisplayName("Testing Add Negative Method")
        void testAdNegative(){
            assertEquals(-2, mathUtils.add(-1,-1),  "The add method should add two numbers"); //assertEquals does almost everything that all others assert methods can do.
        }
    }

    @Test
    @DisplayName("Testing Add Method")
    void testAdd(){
        int expected = 3;
        int actual = mathUtils.add(1,2);
        assertEquals(expected, actual,  "The add method should add two numbers"); //assertEquals does almost everything that all others assert methods can do.
    }

    @Test
    @Disabled("TDD, Should not run")
    void testDisabled(){
        fail("This  test should be displayed");
    }

    @Test
    //@EnabledOnOs(OS.LINUX) // test will not run as this is windows
    void testDivide(){
        //assumeTrue(value); // if value is false, then this test case will not run.
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0),"divide by zero should throw");
    }

    @Test
    void testComputeCircleArea(){
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "This returns the area of given circle");
    }

    @Test
    @DisplayName("Test Mulitply Method")
    void testMultiply(){

        assertAll(
                () -> assertEquals(4, mathUtils.multiple(2,2)),
                () -> assertEquals(0, mathUtils.multiple(2,0)),
                () -> assertEquals(-2, mathUtils.multiple(2,-1))
        );
    }


}
