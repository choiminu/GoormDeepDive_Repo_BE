package level_3.bj25304;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalPrice = sc.nextInt();
        int count = sc.nextInt();
        sc.nextLine();

        int sum = 0;
        for (int i = 0; i < count; i++) {
            String[] input = sc.nextLine().split(" ");
            int orderPrice = Integer.parseInt(input[0]);
            int orderCount = Integer.parseInt(input[1]);
            sum += orderPrice * orderCount;
        }
        System.out.println(sum == totalPrice ? "Yes" : "No");
    }
}
