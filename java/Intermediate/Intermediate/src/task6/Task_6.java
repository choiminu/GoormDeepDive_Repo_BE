package task6;

import java.util.Scanner;

public class Task_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력 해주세요 ex : (9 + 10) : ");
        String input = sc.nextLine();

        try {
            String[] split = input.split(" ");

            int num1 = Integer.parseInt(split[0]);
            var operation = (split[1]);
            int num2 = Integer.parseInt(split[2]);

            if (operation.equals("+")) {
                System.out.println("덧셈 결과 = " + (num1 + num2));
            }

            if (operation.equals("-")) {
                System.out.println("뺄셈 결과 = " + (num1 - num2));
            }

            if (operation.equals("*")) {
                System.out.println("곱셈 결과 = " + (num1 * num2));
            }

            if (operation.equals("/")) {
                System.out.println("나눗셈 결과 = " + (num1 / num2));
            }

        } catch (Exception e) {
            System.out.println("잘못된 값을 입력하였습니다.");
        }
    }
}

