package task6;

import java.util.Scanner;

public class Task_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름을 입력해주세요 : ");
        String name = sc.nextLine();

        System.out.println();

        System.out.print("나이를 입력해주세요 : ");
        int age = sc.nextInt();

        System.out.println("이름 = " + name + " 나이 = " + age);
    }
}
