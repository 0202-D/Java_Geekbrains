package Level_3_Lesson_6_Testing;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dm.Petrov
 * DATE: 06.02.2022
 */
public class MethodsTest {
    private Methods methods;

    @BeforeEach
    public void init() {
        methods = new Methods();
    }

    @Test
    public void fooTest() {
        boolean result = methods.checkOneAndFour(new int[]{0, 2, 3, 7});
        assertFalse(result);
        result = methods.checkOneAndFour(new int[]{0, 2, 3, 1, 7, 45});
        assertTrue(result);
        result = methods.checkOneAndFour(new int[]{0, 13, 99, 67, 0, 0, 4, 3, 9});
        assertTrue(result);
    }

    @Test
    public void afterFourArrayException() {
        try {
            methods.afterFourArray(new int[]{0, 2, 3, 1, 7, 45});
            fail();
        } catch (Exception ignored) {

        }

    }

    @MethodSource("dataAfterFourArray")
    @ParameterizedTest
    public void testAfterFourArray(int[] array, int[] result) {
        assertArrayEquals(result, methods.afterFourArray(array));
    }

    public static Stream<Arguments> dataAfterFourArray() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 4, 4, 4}, new int[]{}));
        out.add(Arguments.arguments(new int[]{75, 12, 0, 33, 1, 4, 64, 1, 7}, new int[]{64, 1, 7}));
        out.add(Arguments.arguments(new int[]{4, 17, 0, 0, 44, 5}, new int[]{17, 0, 0, 44, 5}));
        return out.stream();
    }
}