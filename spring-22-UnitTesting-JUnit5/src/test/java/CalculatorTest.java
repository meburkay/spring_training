import org.junit.jupiter.api.*;

//this import is for the Assertions methods. They are all static and with this import we can use them directly.
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
    static void setUpAll() {
        System.out.println("BeforeAll is executed.");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("AfterAll is executed.");
    }

    @BeforeEach
    void setUpEach() {
        System.out.println("BeforeEach is executed.");
    }

    @AfterEach
    void tearDownEach() {
        System.out.println("AfterEach is executed.");
    }

    @Test
    void add2() {
        System.out.println("Add2 method");

        //Here we implement assertThrows method. first parameter is the exception we expect, the second part we define by lambda and execute the method if it throws the same exception that we define at the first argument it succeeds else it fails. And if doesn't throw any exception it fails again.
//        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(3, 2));
//        assertThrows(AccessDeniedException.class, () -> Calculator.add2(3, 2));
        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(2, 3));
    }

    @Test
    void add() {
        System.out.println("Add method");
        int actual = Calculator.add(2, 3);
        assertEquals(5, actual, "Test failed.");
    }

    @Test
    void testCase1() {
//        System.out.println("Test Case 1");

        //This is a direct fail method and it gives our fail message at console.
        fail("Not implemented yet.");
    }

    @Test
    void testCase2() {
        System.out.println("Test Case 2");
        assertEquals("add", Calculator.operator);
        assertTrue(Calculator.operator.equals("add"));
    }

    @Test
    void testCase3() {
        System.out.println("Test Case 3");
        //it looks at the array length and compare the elements one by one if matches it succeed otherwise it fails. It doesn't look to the reference object.
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 3, 2}, "Arrays are not same.");
    }

    @Test
    void testCase4() {

        System.out.println("Test Case 4");

        String nullString = null;
        String notNullString = "Cydeo";

        assertNull(nullString);
        assertNotNull(notNullString);

//        assertNull(notNullString);
        assertNotNull(nullString);

    }

    // 2.10 PM

    @Test
    void testCase5() {
        System.out.println("Test Case 5");
    }

}
