package task7;

import java.util.Arrays;
import java.util.Scanner;

public class Task_7 {
    public static void main(String[] args) {
        int[] arr = {10, 9 ,3, 7, 5};
        Scanner sc = new Scanner(System.in);

        System.out.println("배열의 평균 값 : " +average(arr));

        int index = sc.nextInt();
        int value = sc.nextInt();
        changeElements(arr, index, value);

        System.out.println("배열의 요소 변경 : " +  Arrays.toString(arr));
    }

    public static double average(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / arr.length;
    }

    public static void changeElements(int[] arr, int index, int value) {
        arr[index] = value;
    }
}
