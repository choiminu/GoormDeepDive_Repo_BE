package task2;

import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자를 입력해주세요 : ");

        int input = sc.nextInt();
        System.out.println(input % 2 == 0 ? "짝수 입니다" : "홀수 입니다.");
    }
}
