package Level_3_Lesson_6_Testing;

import java.util.Arrays;

/**
 * @author Dm.Petrov
 * DATE: 06.02.2022
 */
public class Methods {
    public  int[] afterFourArray(int[] array) throws RuntimeException {
        int check = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                check = i;
                break;
            }
            if (i == 0) {
                throw new RuntimeException("4 not found");
            }
        }

        int[] result = new int[array.length - check - 1];

        System.arraycopy(array, check + 1, result, 0, result.length);
        return result;

    }
    public  boolean checkOneAndFour(int[]arr){
        for (int j : arr) {
            if (j == 1 || j == 4) {
                return true;
            }
        }
        return false;
    }
}
