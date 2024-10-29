package task9;

import java.util.Scanner;

public class Task_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuffer sb = new StringBuffer(sc.nextLine());

        System.out.println(sb.reverse());

        System.out.println(sb.toString().toUpperCase());
    }
}
