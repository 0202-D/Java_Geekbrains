package Lesson_2;

/**
 * @author Dm.Petrov
 */
public class Test {
    public static void main(String[] args) {
        String[][] arrayOne = {{"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
        };
        String[][] arrayTwo = {{"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1", "1"},
                {"1", "1", "1", "1"},
        };
        String[][] arrayThree = {{"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "Z", "1", "1"},
                {"1", "1", "1", "1"},
        };
        try {
            int result = checkAndSumArray(arrayOne);
            System.out.println(result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
        try {
            int result = checkAndSumArray(arrayTwo);
            System.out.println(result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
        try {
            int result = checkAndSumArray(arrayThree);
            System.out.println(result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int checkAndSumArray(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        int sum = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException("Wrong array size");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("Wrong array size");
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
              try {
                  sum += Integer.parseInt(arr[i][j]);
              }
              catch (NumberFormatException e){
                  throw new MyArrayDataException("Wrong element in index - "+"["+i+"]"+" "+"["+j+"]");
              }

            }

        }
        return sum;
    }
}
