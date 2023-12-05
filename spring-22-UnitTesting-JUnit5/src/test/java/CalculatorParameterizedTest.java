import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTest {

    //We put @ParameterizedTest at the top. And used annotations to give test values. Here we use @ValueSource and give the values. When we execute all the values give to the method as arguments and tested one by one.
    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
    void testCase1(String arg) {
        Assertions.assertFalse(arg.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9})
    void testCase1(int num) {
        Assertions.assertEquals(0, num % 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
//    @EmptySource            // ""
//    @NullSource
    @NullAndEmptySource
    void testCase3(String arg) {
        Assertions.assertFalse(arg.isEmpty());
    }

    //here we use @MethodSource annotation. We create a method that returns values as a Stream or iterable of an array. We put that method name to @MethodSource and method test all the returning elements for the operation
    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase4(String arg) {
        Assertions.assertFalse(arg.isEmpty());
    }

    static String[] stringProvider() {
        return new String[]{"Java", "JS", "TS"};
    }

    //Here we give the test data as a Csv format and it give the data to parameters and tests.
    @ParameterizedTest
    @CsvSource({
            "10, 20, 30",
            "20, 20, 40",
            "30, 20, 100"
    })
    void testCase5(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }

    //Here we give a CsvFileSource to the method and it take the data from that source and use. When we put the csv file under the resources folder we only give the file name because in default it looks directly there. And we use a second parameter here to exclude the titles at the file. If we do not use that second parameter it try to test the titles as argument and fails.
    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1)
    void testCase6(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }


}
