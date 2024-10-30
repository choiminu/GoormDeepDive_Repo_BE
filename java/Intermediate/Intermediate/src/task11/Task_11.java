package task11;

import java.util.Arrays;

public class Task_11 {
    public static void main(String[] args) {
        int[] arr = {10,2,5,1,6,7,8};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public class TurnCountValidator {
        public static int validateTurnCount(String turnCount) {
            int intTurnCount = Integer.parseInt(turnCount);
            if (intTurnCount < 1) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INT_NUMBER.getMessage());
            }
            return intTurnCount;
        }
    }
}
