package Test1;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @org.junit.jupiter.api.Test
    void fizzBuzz() {
        Numbers numbers = new Numbers();
        String actual = numbers.fizzBuzz(15);
        String expected = "FizzBuzz";

        assertEquals(expected, actual);
    }
}